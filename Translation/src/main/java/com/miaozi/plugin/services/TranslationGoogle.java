package com.miaozi.plugin.services;

import com.miaozi.plugin.manager.ViewManager;
import com.miaozi.plugin.model.Language;

/**
 * @author miaoweiwei
 * @create 2019-12-07 22:48
 */
public class TranslationGoogle implements Translation {
    private Language sourceLanguage = ViewManager.getDefaultLanguage();
    private Language targetLanguage = ViewManager.getDefaultLanguage();

    private static TranslationGoogle instance = null;

    private TranslationGoogle() {
    }

    public static TranslationGoogle getInstance() {
        if (instance == null) {
            synchronized (TranslationGoogle.class) {
                if (instance == null) {
                    instance = new TranslationGoogle();
                }
            }
        }
        return instance;
    }

    public static TranslationGoogle getInstance(Language sourceLanguage, Language targetLanguage) {
        TranslationGoogle translationGoogle = TranslationGoogle.getInstance();
        translationGoogle.setSourceLanguage(sourceLanguage);
        translationGoogle.setTargetLanguage(targetLanguage);
        return translationGoogle;
    }


    @Override

    public String translation(String content) {
        String translationContent = "";
        if (targetLanguage.equals(ViewManager.getDefaultLanguage())) {
            translationContent = content;
        } else {

        }

        return translationContent;
    }

    @Override
    public void setSourceLanguage(Language language) {
        sourceLanguage = language;
    }

    @Override
    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    @Override
    public void setTargetLanguage(Language language) {
        targetLanguage = language;
    }

    @Override
    public Language getTargetLanguage() {
        return targetLanguage;
    }
}
