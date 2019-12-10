package com.miaozi.plugin.services;

import com.miaozi.plugin.manager.ViewManager;
import com.miaozi.plugin.model.Language;

/**
 * @author miaoweiwei
 * @create 2019-12-08 23:54
 */
public class TranslationBaidu implements Translation {
    private Language sourceLanguage = ViewManager.getDefaultLanguage();
    private Language targetLanguage = ViewManager.getDefaultLanguage();
    private static Baidu baidu;

    private static TranslationBaidu instance = null;


    private TranslationBaidu() {
        baidu = Baidu.getInstance();
    }

    public static TranslationBaidu getInstance() {
        if (instance == null) {
            synchronized (TranslationBaidu.class) {
                if (instance == null) {
                    instance = new TranslationBaidu();
                }
            }
        }
        return instance;
    }

    public static TranslationBaidu getInstance(Language sourceLanguage, Language targetLanguage) {
        TranslationBaidu translationBaidu = TranslationBaidu.getInstance();
        translationBaidu.setSourceLanguage(sourceLanguage);
        translationBaidu.setTargetLanguage(targetLanguage);
        return translationBaidu;
    }

    @Override
    public String translation(String content) {
        String res = "";
        try {
            res = baidu.translation(content, sourceLanguage, targetLanguage);
            res = baidu.parses(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void setSourceLanguage(Language language) {
        this.sourceLanguage = language;
    }

    @Override
    public Language getSourceLanguage() {
        return null;
    }

    @Override
    public void setTargetLanguage(Language language) {
        this.targetLanguage = language;
    }

    @Override
    public Language getTargetLanguage() {
        return null;
    }
}
