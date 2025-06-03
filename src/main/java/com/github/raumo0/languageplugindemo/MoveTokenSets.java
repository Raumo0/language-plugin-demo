package com.github.raumo0.languageplugindemo;

import com.intellij.psi.tree.TokenSet;

public interface MoveTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(MoveTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(MoveTypes.COMMENT);
}
