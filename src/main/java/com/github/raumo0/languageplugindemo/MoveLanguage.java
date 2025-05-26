package com.github.raumo0.languageplugindemo;

import com.intellij.lang.Language;

public class MoveLanguage extends Language {
    public static final MoveLanguage INSTANCE = new MoveLanguage();
    private MoveLanguage() {
        super("Move");
    }
}
