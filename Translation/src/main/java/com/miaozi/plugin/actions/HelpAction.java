package com.miaozi.plugin.actions;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author miaoweiwei
 * @create 2019-12-06 15:41
 */
public class HelpAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        BrowserUtil.browse("https://github.com/miaoweiwei");
    }
}
