package com.miaozi.plugin.actions;

import com.intellij.openapi.actionSystem.*;
import com.miaozi.plugin.manager.ViewManager;
import com.miaozi.plugin.model.Language;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author miaoweiwei
 * @create 2019-12-06 15:31
 */
public class SelectTypeAction extends ActionGroup implements Toggleable {
    AnAction[] anActions = null;

    @Override
    public boolean displayTextInToolbar() {
        return true;
    }

    @NotNull
    @Override
    public AnAction[] getChildren(@Nullable AnActionEvent anActionEvent) {
        List<Language> languages = ViewManager.getLanguages();
        if (anActions == null || anActions.length != languages.size()) {
            List<AnAction> anActionList = Lists.newArrayList();
            if (languages != null && !languages.isEmpty()) {
                for (Language language : languages) {
                    anActionList.add(new LanguageAction(language.getName(), language));
                }
            }
            anActions = new AnAction[anActionList.size()];
            anActionList.toArray(anActions);
        }

        return anActions;
    }

    @Override
    public void update(@NotNull final AnActionEvent e) {
        boolean selected = isSelected(e);
        final Presentation presentation = e.getPresentation();
        presentation.putClientProperty(SELECTED_PROPERTY, selected);

        Language language = ViewManager.getDefaultLanguage();

        String id = e.getActionManager().getId(this);
        if ("translation.Source.SelectType".equals(id)) {
            language = ViewManager.getSourceLanguage();
        }
        if ("translation.Target.SelectType".equals(id)) {
            language = ViewManager.getTargetLanguage();
        }
        presentation.setText(language.getName());
        presentation.setIcon(null);
    }

    public boolean isSelected(@NotNull AnActionEvent e) {
        String id = e.getActionManager().getId(this);
        Language defaultLanguage = ViewManager.getDefaultLanguage();
        Language language;

        if ("translation.Source.SelectType".equals(id)) {
            language = ViewManager.getSourceLanguage();
            return !language.equals(defaultLanguage);
        }
        if ("translation.Target.SelectType".equals(id)) {
            language = ViewManager.getTargetLanguage();
            return !language.equals(defaultLanguage);
        }
        return true;
    }

    public void setSelected(@NotNull AnActionEvent e, boolean state) {

    }
}