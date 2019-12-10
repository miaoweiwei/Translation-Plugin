package com.miaozi.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.miaozi.plugin.manager.ViewManager;
import com.miaozi.plugin.model.Language;
import org.jetbrains.annotations.NotNull;

import javax.swing.text.View;

/**
 * @author miaoweiwei
 * @create 2019-12-09 22:07
 */
public class ChineseAction extends ToggleAction {
    @Override
    public boolean displayTextInToolbar() {
        return true;
    }

    @Override
    public boolean isSelected(@NotNull AnActionEvent e) {
        String id = e.getActionManager().getId(this);
        if (id != null) {
            if (id.contains("Source") && "zh".equals(ViewManager.getSourceLanguage().getCode())) {
                return true;
            } else if (id.contains("Target") && "zh".equals(ViewManager.getTargetLanguage().getCode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setSelected(@NotNull AnActionEvent e, boolean state) {
        String id = e.getActionManager().getId(this);
        if (id != null) {
            if (id.contains("Source")) {
                ViewManager.setSourceLanguage(ViewManager.getLanguageMap().get("zh"));
            } else if (id.contains("Target")) {
                ViewManager.setTargetLanguage(ViewManager.getLanguageMap().get("zh"));
            }
        }
    }
}
