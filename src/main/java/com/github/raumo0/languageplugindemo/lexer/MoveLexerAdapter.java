package com.github.raumo0.languageplugindemo.lexer;

import com.intellij.lexer.FlexAdapter;

public class MoveLexerAdapter extends FlexAdapter {

    public MoveLexerAdapter() {
        super(new MoveLexer(null));
    }

}
