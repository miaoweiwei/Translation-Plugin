package com.miaozi.plugin.services;

import com.miaozi.plugin.model.Language;

/**
 * @author miaoweiwei
 * @create 2019-12-07 10:51
 */
public interface Translation {

    /**
     * 翻译
     *
     * @return 返回翻译结果
     */
    String translation(String content);

    /**
     * 设置源语言
     *
     * @param language
     */
    void setSourceLanguage(Language language);

    /**
     * 获取源语言
     *
     * @return
     */
    Language getSourceLanguage();

    /**
     * 设置目标语言
     *
     * @param language
     */
    void setTargetLanguage(Language language);

    /**
     * 获取目标语言
     *
     * @return
     */
    Language getTargetLanguage();
    
}
