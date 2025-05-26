package com.github.raumo0.languageplugindemo;

import com.intellij.lexer.FlexAdapter;

public class MoveLexerAdapter extends FlexAdapter {

    public MoveLexerAdapter() {
        super(new MoveLexer(null));
    }

}
