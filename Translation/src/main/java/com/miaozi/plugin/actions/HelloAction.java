package com.miaozi.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * @author miaoweiwei
 * @create 2019-12-06 15:45
 */
public class HelloAction extends AnAction {
    public HelloAction() { // 被第一次加载的时候执行
        super("Hello");
    }

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();
        Messages.showMessageDialog(project, "Hello world!", "Greeting", Messages.getInformationIcon());
    }
}
