package com.miaozi.plugin.utils;

import com.intellij.openapi.actionSystem.DataKey;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;

/**
 * @author miaoweiwei
 * @create 2019-12-06 17:29
 */
public class DataKeys {
    public static final DataKey<JTextArea> TRANSLATION_SOURCE_JTEXT = DataKey.create("TRANSLATION_SOURCE_JTEXT");
    public static final DataKey<JTextArea> TRANSLATION_TARGET_JTEXT = DataKey.create("TRANSLATION_TARGET_JTEXT");
}
