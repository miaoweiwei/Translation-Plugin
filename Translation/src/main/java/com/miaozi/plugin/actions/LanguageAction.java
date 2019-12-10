package com.miaozi.plugin.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.intellij.openapi.actionSystem.impl.ActionManagerImpl;
import com.miaozi.plugin.manager.ViewManager;
import com.miaozi.plugin.model.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author miaoweiwei
 * @create 2019-12-06 19:54
 */
public class LanguageAction extends ToggleAction {
    private Language language;

    public LanguageAction(@Nullable String text, Language language) {
        super(text);
        this.language = language;
    }

    //判断是否选中语言
    @Override
    public boolean isSelected(@NotNull AnActionEvent e) {
//        String id = ((ActionManagerImpl) e.getActionManager()).getPrevPreformedActionId();
        String id = ((ActionManagerImpl) e.getActionManager()).getPrevPreformedActionId();

        Language language = null;
        if ("translation.Source.SelectType".equals(id)) {
            language = ViewManager.getSourceLanguage();
        }
        if ("translation.Target.SelectType".equals(id)) {
            language = ViewManager.getTargetLanguage();
        }
        return this.language.equals(language);
    }

    //设置选中的语言
    @Override
    public void setSelected(@NotNull AnActionEvent e, boolean state) {
        String id = ((ActionManagerImpl) e.getActionManager()).getPrevPreformedActionId();
        final Presentation presentation = e.getPresentation();
        if ("translation.Source.SelectType".equals(id)) {
            ViewManager.setSourceLanguage(language);
        }
        if ("translation.Target.SelectType".equals(id)) {
            ViewManager.setTargetLanguage(language);
        }
        presentation.setText(language.getName());
        presentation.putClientProperty(SELECTED_PROPERTY, state);
    }
}
