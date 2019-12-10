package com.miaozi.plugin.manager;

import com.google.common.collect.Lists;
import com.miaozi.plugin.model.Language;
import com.miaozi.plugin.model.PluginDictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author miaoweiwei
 * @create 2019-12-06 20:02
 */
public class ViewManager {
    private static List<Language> languages = Lists.newArrayList();
    private static Map<String, Language> languageMap = new HashMap<>();
    private static Language defaultLanguage = new Language("defaultLanguage", "auto");

    private static Language sourceLanguage = defaultLanguage;
    private static Language targetLanguage = defaultLanguage;

    static {
        //加载语言列表
        LoadLanguageList();
    }

    public static void LoadLanguageList() {
        Map<String, String> languageDic = PluginDictionary.getLanguageDic();
        languageDic.forEach((key, value) -> {
            Language language = new Language(value, key);
            languages.add(language);
            languageMap.put(key, language);
        });
    }


    public static List<Language> getLanguages() {
        return languages;
    }

    public static Map<String, Language> getLanguageMap() {
        return languageMap;
    }

    public static Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public static Language getSourceLanguage() {
        return sourceLanguage;
    }

    public static void setSourceLanguage(Language sourceLanguage) {
        ViewManager.sourceLanguage = sourceLanguage;
    }

    public static Language getTargetLanguage() {
        return targetLanguage;
    }

    public static void setTargetLanguage(Language targetLanguage) {
        ViewManager.targetLanguage = targetLanguage;
    }
}
