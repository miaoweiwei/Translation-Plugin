package com.miaozi.plugin.window;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBScrollPane;
import com.miaozi.plugin.utils.DataKeys;

import javax.swing.*;

/**
 * @author miaoweiwei
 * @create 2019-12-06 15:23
 */
public class NavigatorPanel extends SimpleToolWindowPanel implements DataProvider {

    private JPanel toolbarPanel; // 工具栏panel
    private JPanel contentPanel; // 内容panel
    private JBScrollPane contentScrollPane;

    private JTextArea sourceText; // 源语言输入框
    private JTextArea targetText; // 目标语言输入框


    public NavigatorPanel(ToolWindow toolWindow, Project project) {
        super(Boolean.TRUE, Boolean.TRUE);
        final ActionManager actionManager = ActionManager.getInstance();

        toolbarPanel = new JPanel(); //工具栏panel
        toolbarPanel.setLayout(new BoxLayout(toolbarPanel, BoxLayout.Y_AXIS));

        // 加载工具栏
        ActionToolbar actionToolbar = actionManager.createActionToolbar("translation Toolbar", (DefaultActionGroup) actionManager.getAction("translation.NavigatorActionsToolbar"), true);
        // actionToolbar.setTargetComponent(tree);
        toolbarPanel.add(actionToolbar.getComponent());

        /*************这里写其他的一些设置**************/
        // 把工具栏加载到窗体上
        setToolbar(toolbarPanel);

        /****************************************************************/
        //内容
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        //源语言
        SimpleToolWindowPanel sourceGroupPanel = new SimpleToolWindowPanel(Boolean.TRUE, Boolean.TRUE);
        ActionToolbar sourceToolbar = actionManager.createActionToolbar("Source language toolbar", (DefaultActionGroup) actionManager.getAction("translation.SourceToolbar"), true);
        // sourceToolbar.setTargetComponent(tree);
        sourceGroupPanel.setToolbar(sourceToolbar.getComponent());

        sourceText = new JTextArea();
        sourceText.setLineWrap(true); //设置自动换行
        sourceText.setVisible(true);

        //设置显示垂直滚动条，不显示水平滚动条
//        sourceScrollPane = new JBScrollPane(sourceText, JBScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JBScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        sourceGroupPanel.setContent(sourceScrollPane);
        sourceGroupPanel.setContent(sourceText);

        contentPanel.add(sourceGroupPanel);

        //目标语言
        SimpleToolWindowPanel targetGroupPanel = new SimpleToolWindowPanel(Boolean.TRUE, Boolean.TRUE);
        ActionToolbar targetToolbar = actionManager.createActionToolbar("find Toolbar", (DefaultActionGroup) actionManager.getAction("translation.TargetToolbar"), true);
        // targetGroupPanel.setTargetComponent(tree);
        targetGroupPanel.setToolbar(targetToolbar.getComponent());

        targetText = new JTextArea();
        String text = "Translation Results";
        targetText.setToolTipText(text);
        targetText.setText(text);
        targetText.setLineWrap(true); //设置自动换行
        targetText.setEditable(false); //设置不可编辑
        targetText.setVisible(true);

//        targetScrollPane = new JBScrollPane(targetText, JBScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JBScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        targetGroupPanel.setContent(targetScrollPane);
        targetGroupPanel.setContent(targetText);

        contentPanel.add(targetGroupPanel);

        contentScrollPane = new JBScrollPane(contentPanel, JBScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JBScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setContent(contentScrollPane);
    }

    @Override
    public Object getData(String dataId) {
        if (DataKeys.TRANSLATION_SOURCE_JTEXT.is(dataId)) {
            return sourceText;
        }
        if (DataKeys.TRANSLATION_TARGET_JTEXT.is(dataId)) {
            return targetText;
        }
        return super.getData(dataId);
    }
}
