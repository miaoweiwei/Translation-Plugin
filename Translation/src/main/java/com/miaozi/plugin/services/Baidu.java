package com.miaozi.plugin.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaozi.plugin.utils.Utils;
import com.miaozi.plugin.model.Language;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author miaoweiwei
 * @create 2019-12-08 23:56
 */
public class Baidu {
    private static final String MAINPAGEURL = "https://fanyi.baidu.com";
    private static final String TRANSAPI = "https://fanyi.baidu.com/v2transapi";

    private CloseableHttpClient httpClient;

    private String token;
    private String gtk;

    private static Baidu instance = null;

    private Baidu() {
        httpClient = HttpClients.createDefault();
    }

    public static Baidu getInstance() {
        if (instance == null) {
            synchronized (Baidu.class) {
                if (instance == null) {
                    instance = new Baidu();
                }
            }
        }
        return instance;
    }

    /**
     * 加载 https://fanyi.baidu.com/ 来获取 token,gtk
     */
    public void loadMainPage() {
        String patternToken = "token: '(.*?)',";
        String patterngtk = "gtk: '(.*?)'";

        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            HttpPost request = new HttpPost(MAINPAGEURL);
            response = httpClient.execute(request);
            entity = response.getEntity();

            String result = EntityUtils.toString(entity, "utf-8");

            // 创建 Pattern 对象
            Pattern r = Pattern.compile(patternToken);
            // 现在创建 matcher 对象
            Matcher m = r.matcher(result);
            if (m.find()) {
                token = m.group(1);
            }

            r = Pattern.compile(patterngtk);
            m = r.matcher(result);
            if (m.find()) {
                gtk = m.group(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    entity.getContent().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String langdetect(String query) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("query", query);
        String url = "https://fanyi.baidu.com/langdetect";
        HttpPost request = new HttpPost(url);

        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String result = null;

        try {
            request.setEntity(new UrlEncodedFormEntity(Utils.map2list(params), "utf-8"));

            response = httpClient.execute(request);
            entity = response.getEntity();

            result = EntityUtils.toString(entity, "utf-8");
            System.out.println(result);
            EntityUtils.consume(entity);

            ObjectMapper mapper = new ObjectMapper();

            if ("\"success\"".equalsIgnoreCase(mapper.readTree(result).path("msg").toString())) {
                result = mapper.readTree(result).path("lan").toString();
            }

            return result.replace("\"", "");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    entity.getContent().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (request != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    private String token(String value, String gtk) {
        String result = "";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        try {
            InputStream is = instance.getClass().getClassLoader().getResourceAsStream("tk/baidu.js");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            engine.eval(br);

            if (engine instanceof Invocable) {
                Invocable invoke = (Invocable) engine;
                result = String.valueOf(invoke.invokeFunction("token", value, gtk));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String translation(String content, String from, String to) {
        loadMainPage();
        loadMainPage();

        String token = this.token;
        String gtk = this.gtk;
        String sign = token(content, gtk);

        Map<String, String> params = new HashMap<String, String>();

        if ("auto".equals(from)) {
            from = langdetect(content);
        }

        params.put("from", from);
        params.put("to", to);
        params.put("query", content);
        params.put("transtype", "realtime");
        params.put("simple_means_flag", "3");
        params.put("sign", sign);
        params.put("token", token);

        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String result = null;
        try {
            HttpPost request = new HttpPost(TRANSAPI);
            request.setEntity(new UrlEncodedFormEntity(Utils.map2list(params), "UTF-8"));

            response = httpClient.execute(request);

            entity = response.getEntity();

            result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    entity.getContent().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public String translation(String content, Language source, Language targetLanguage) throws Exception {
        return translation(content, source.getCode(), targetLanguage.getCode());
    }

    public String parses(String text) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        text = mapper.readTree(text).path("trans_result").findPath("dst").toString();
        return text.replace("\"", "");
    }
}
