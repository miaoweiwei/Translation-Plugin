package com.miaozi.plugin.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author miaoweiwei
 * @create 2019-12-09 21:32
 */
public class PluginDictionary {
    private static HashMap languageDic = null;

    public static Map<String, String> getLanguageDic() {

        if (languageDic == null) {
            synchronized (PluginDictionary.class) {
                if (languageDic == null) {
                    languageDic = new HashMap() {{
                        put("zh", "中文");
                        put("jp", "日语");
                        put("jpka", "日语假名");
                        put("th", "泰语");
                        put("fra", "法语");
                        put("en", "英语");
                        put("spa", "西班牙语");
                        put("kor", "韩语");
                        put("tr", "土耳其语");
                        put("vie", "越南语");
                        put("ms", "马来语");
                        put("de", "德语");
                        put("ru", "俄语");
                        put("ir", "伊朗语");
                        put("ara", "阿拉伯语");
                        put("est", "爱沙尼亚语");
                        put("be", "白俄罗斯语");
                        put("bul", "保加利亚语");
                        put("hi", "印地语");
                        put("is", "冰岛语");
                        put("pl", "波兰语");
                        put("fa", "波斯语");
                        put("dan", "丹麦语");
                        put("tl", "菲律宾语");
                        put("fin", "芬兰语");
                        put("nl", "荷兰语");
                        put("ca", "加泰罗尼亚语");
                        put("cs", "捷克语");
                        put("hr", "克罗地亚语");
                        put("lv", "拉脱维亚语");
                        put("lt", "立陶宛语");
                        put("rom", "罗马尼亚语");
                        put("af", "南非语");
                        put("no", "挪威语");
                        put("pt_BR", "巴西语");
                        put("pt", "葡萄牙语");
                        put("swe", "瑞典语");
                        put("sr", "塞尔维亚语");
                        put("eo", "世界语");
                        put("sk", "斯洛伐克语");
                        put("slo", "斯洛文尼亚语");
                        put("sw", "斯瓦希里语");
                        put("uk", "乌克兰语");
                        put("iw", "希伯来语");
                        put("el", "希腊语");
                        put("hu", "匈牙利语");
                        put("hy", "亚美尼亚语");
                        put("it", "意大利语");
                        put("id", "印尼语");
                        put("sq", "阿尔巴尼亚语");
                        put("am", "阿姆哈拉语");
                        put("as", "阿萨姆语");
                        put("az", "阿塞拜疆语");
                        put("eu", "巴斯克语");
                        put("bn", "孟加拉语");
                        put("bs", "波斯尼亚语");
                        put("gl", "加利西亚语");
                        put("ka", "格鲁吉亚语");
                        put("gu", "古吉拉特语");
                        put("ha", "豪萨语");
                        put("ig", "伊博语");
                        put("iu", "因纽特语");
                        put("ga", "爱尔兰语");
                        put("zu", "祖鲁语");
                        put("kn", "卡纳达语");
                        put("kk", "哈萨克语");
                        put("ky", "吉尔吉斯语");
                        put("lb", "卢森堡语");
                        put("mk", "马其顿语");
                        put("mt", "马耳他语");
                        put("mi", "毛利语");
                        put("mr", "马拉提语");
                        put("ne", "尼泊尔语");
                        put("or", "奥利亚语");
                        put("pa", "旁遮普语");
                        put("qu", "凯楚亚语");
                        put("tn", "塞茨瓦纳语");
                        put("si", "僧加罗语");
                        put("ta", "泰米尔语");
                        put("tt", "塔塔尔语");
                        put("te", "泰卢固语");
                        put("ur", "乌尔都语");
                        put("uz", "乌兹别克语");
                        put("cy", "威尔士语");
                        put("yo", "约鲁巴语");
                        put("yue", "粤语");
                        put("wyw", "文言文");
                        put("cht", "中文繁体");
                    }};
                }
            }
        }

        return languageDic;
    }
}
