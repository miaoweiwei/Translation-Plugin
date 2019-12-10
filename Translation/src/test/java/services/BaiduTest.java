package services;

import com.miaozi.plugin.services.Baidu;
import org.junit.Test;

/**
 * @author miaoweiwei
 * @create 2019-12-09 9:53
 */
public class BaiduTest {
    @Test
    public void testloadMainPage() {
        Baidu baidu = Baidu.getInstance();
        baidu.loadMainPage();
    }

    @Test
    public void testLangdetect() {
        Baidu baidu = Baidu.getInstance();
        String res = baidu.langdetect("你好");
    }

    @Test
    public void testTranslation() {
        Baidu baidu = Baidu.getInstance();
        try {
            String result = baidu.translation("你们好呀", "zh", "en");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        String str = "'zh': '中文',\n" +
                "'jp': '日语',\n" +
                "'jpka': '日语假名',\n" +
                "'th': '泰语',\n" +
                "'fra': '法语',\n" +
                "'en': '英语',\n" +
                "'spa': '西班牙语',\n" +
                "'kor': '韩语',\n" +
                "'tr': '土耳其语',\n" +
                "'vie': '越南语',\n" +
                "'ms': '马来语',\n" +
                "'de': '德语',\n" +
                "'ru': '俄语',\n" +
                "'ir': '伊朗语',\n" +
                "'ara': '阿拉伯语',\n" +
                "'est': '爱沙尼亚语',\n" +
                "'be': '白俄罗斯语',\n" +
                "'bul': '保加利亚语',\n" +
                "'hi': '印地语',\n" +
                "'is': '冰岛语',\n" +
                "'pl': '波兰语',\n" +
                "'fa': '波斯语',\n" +
                "'dan': '丹麦语',\n" +
                "'tl': '菲律宾语',\n" +
                "'fin': '芬兰语',\n" +
                "'nl': '荷兰语',\n" +
                "'ca': '加泰罗尼亚语',\n" +
                "'cs': '捷克语',\n" +
                "'hr': '克罗地亚语',\n" +
                "'lv': '拉脱维亚语',\n" +
                "'lt': '立陶宛语',\n" +
                "'rom': '罗马尼亚语',\n" +
                "'af': '南非语',\n" +
                "'no': '挪威语',\n" +
                "'pt_BR': '巴西语',\n" +
                "'pt': '葡萄牙语',\n" +
                "'swe': '瑞典语',\n" +
                "'sr': '塞尔维亚语',\n" +
                "'eo': '世界语',\n" +
                "'sk': '斯洛伐克语',\n" +
                "'slo': '斯洛文尼亚语',\n" +
                "'sw': '斯瓦希里语',\n" +
                "'uk': '乌克兰语',\n" +
                "'iw': '希伯来语',\n" +
                "'el': '希腊语',\n" +
                "'hu': '匈牙利语',\n" +
                "'hy': '亚美尼亚语',\n" +
                "'it': '意大利语',\n" +
                "'id': '印尼语',\n" +
                "'sq': '阿尔巴尼亚语',\n" +
                "'am': '阿姆哈拉语',\n" +
                "'as': '阿萨姆语',\n" +
                "'az': '阿塞拜疆语',\n" +
                "'eu': '巴斯克语',\n" +
                "'bn': '孟加拉语',\n" +
                "'bs': '波斯尼亚语',\n" +
                "'gl': '加利西亚语',\n" +
                "'ka': '格鲁吉亚语',\n" +
                "'gu': '古吉拉特语',\n" +
                "'ha': '豪萨语',\n" +
                "'ig': '伊博语',\n" +
                "'iu': '因纽特语',\n" +
                "'ga': '爱尔兰语',\n" +
                "'zu': '祖鲁语',\n" +
                "'kn': '卡纳达语',\n" +
                "'kk': '哈萨克语',\n" +
                "'ky': '吉尔吉斯语',\n" +
                "'lb': '卢森堡语',\n" +
                "'mk': '马其顿语',\n" +
                "'mt': '马耳他语',\n" +
                "'mi': '毛利语',\n" +
                "'mr': '马拉提语',\n" +
                "'ne': '尼泊尔语',\n" +
                "'or': '奥利亚语',\n" +
                "'pa': '旁遮普语',\n" +
                "'qu': '凯楚亚语',\n" +
                "'tn': '塞茨瓦纳语',\n" +
                "'si': '僧加罗语',\n" +
                "'ta': '泰米尔语',\n" +
                "'tt': '塔塔尔语',\n" +
                "'te': '泰卢固语',\n" +
                "'ur': '乌尔都语',\n" +
                "'uz': '乌兹别克语',\n" +
                "'cy': '威尔士语',\n" +
                "'yo': '约鲁巴语',\n" +
                "'yue': '粤语',\n" +
                "'wyw': '文言文',\n" +
                "'cht': '中文繁体'";
        String[] temp = str.split(",");
        String res = "";
        for (String st : temp) {
            st = st.trim();
            st = st.replace("\'", "\"");
            st = st.replace(":", ",");
            res += "put(" + st + ");\n";
        }

        System.out.println(res);

    }
}
