package com.github.raumo0.languageplugindemo.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.github.raumo0.languageplugindemo.psi.MvNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base implementation for PSI elements that own a name identifier in Move language.
 */
public abstract class MvNameIdentifierOwnerImpl extends ASTWrapperPsiElement implements MvNameIdentifierOwner {

    /**
     * Constructs a new name identifier owner with the given AST node.
     *
     * @param node The AST node
     */
    public MvNameIdentifierOwnerImpl(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * Finds the first child of the given element type.
     *
     * @param type The element type to search for
     * @return The first child of the specified type, or null if none is found
     */
    @Nullable
    protected PsiElement findChildByType(IElementType type) {
        ASTNode node = getNode().findChildByType(type);
        return node != null ? node.getPsi() : null;
    }

    /**
     * Gets the text range of the name identifier.
     * This is used for reference resolution and highlighting.
     *
     * @return The text range of the name identifier
     */
    @Override
    public int getTextOffset() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getTextOffset() : super.getTextOffset();
    }
}