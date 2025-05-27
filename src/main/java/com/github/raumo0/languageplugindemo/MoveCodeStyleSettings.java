package com.github.raumo0.languageplugindemo;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class MoveCodeStyleSettings extends CustomCodeStyleSettings {

    public MoveCodeStyleSettings(CodeStyleSettings settings) {
        super("MoveCodeStyleSettings", settings);
    }

}
