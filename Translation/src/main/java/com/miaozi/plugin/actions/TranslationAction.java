package com.miaozi.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.miaozi.plugin.manager.ViewManager;
import com.miaozi.plugin.utils.DataKeys;
import com.miaozi.plugin.model.Language;
import com.miaozi.plugin.services.Translation;
import com.miaozi.plugin.services.TranslationBaidu;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author miaoweiwei
 * @create 2019-12-06 15:32
 */
public class TranslationAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        JTextArea sourceText = e.getData(DataKeys.TRANSLATION_SOURCE_JTEXT);
        JTextArea targetText = e.getData(DataKeys.TRANSLATION_TARGET_JTEXT);

        Language sourceLanguage = ViewManager.getSourceLanguage();
        Language targetLanguage = ViewManager.getTargetLanguage();


        /*
          调用翻译API
         */

        String text = sourceText.getText();

        Translation translation = TranslationBaidu.getInstance(sourceLanguage, targetLanguage);
        String translationContent = translation.translation(text);


        targetText.setText(translationContent);
        System.out.println("源语言类型：" + sourceLanguage.getName());
        System.out.println("源语言：" + text);
        System.out.println("目标语言类型：" + sourceLanguage.getName());
        System.out.println("目标语言：" + translationContent);
    }
}
