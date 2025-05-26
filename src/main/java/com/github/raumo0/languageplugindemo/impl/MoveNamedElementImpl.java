package com.github.raumo0.languageplugindemo.impl;

import com.github.raumo0.languageplugindemo.MoveNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class MoveNamedElementImpl extends ASTWrapperPsiElement implements MoveNamedElement {

    public MoveNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
