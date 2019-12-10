package com.miaozi.plugin.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.miaozi.plugin.manager.ViewManager;
import org.jetbrains.annotations.NotNull;

/**
 * @author miaoweiwei
 * @create 2019-12-06 15:32
 */
public class AutoIdentifyAction extends ToggleAction {
    @Override
    public boolean displayTextInToolbar() {
        return true;
    }

    @Override
    public boolean isSelected(@NotNull AnActionEvent e) {
        return ViewManager.getSourceLanguage().equals(ViewManager.getDefaultLanguage());
    }

    @Override
    public void setSelected(@NotNull AnActionEvent e, boolean state) {
        ViewManager.setSourceLanguage(ViewManager.getDefaultLanguage());
        e.getPresentation().putClientProperty(SELECTED_PROPERTY, state);
    }
}
