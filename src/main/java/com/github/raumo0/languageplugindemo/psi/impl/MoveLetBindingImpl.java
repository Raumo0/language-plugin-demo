package com.github.raumo0.languageplugindemo.psi.impl;

import com.github.raumo0.languageplugindemo.MoveIcons;
import com.github.raumo0.languageplugindemo.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Mixin implementation for MoveLetBinding.
 */
public class MoveLetBindingImpl extends MvNameIdentifierOwnerImpl implements MoveLetBinding {

    /**
     * Constructs a new let binding with the given AST node.
     *
     * @param node The AST node
     */
    public MoveLetBindingImpl(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * Gets the name of this let binding.
     *
     * @return The name
     */
    @Override
    public String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }

    /**
     * Gets the name identifier element of this let binding.
     *
     * @return The name identifier element
     */
    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        MovePattern pattern = getPattern();
        if (pattern != null && pattern instanceof MoveNamedPattern) {
            return ((MoveNamedPattern) pattern).getNameIdentifier();
        }
        return null;
    }

    @Nullable
    @Override
    public MovePattern getPattern() {
        return findChildByClass(MovePattern.class);
    }

    @Override
    public @Nullable MoveType getType() {
        return null;
    }

    @Override
    public @Nullable MoveExpr getExpr() {
        return null;
    }

    @Override
    public @Nullable PsiElement getMut() {
        return null;
    }

    /**
     * Sets the name of this let binding.
     *
     * @param name The new name
     * @return The updated let binding
     * @throws IncorrectOperationException if the operation fails
     */
    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        PsiElement nameIdentifier = getNameIdentifier();
        if (nameIdentifier != null) {
            ASTNode newNode = MoveTokenElementFactory.createIdentifier(getProject(), name).copyElement();
            getNode().replaceChild(nameIdentifier.getNode(), newNode);
        }
        return this;
    }

    /**
     * Gets the icon for this let binding.
     *
     * @param flags The icon flags
     * @return The icon
     */
    @Override
    public Icon getIcon(int flags) {
        return isMutable() ? MoveIcons.MUT_VARIABLE : MoveIcons.VARIABLE;
    }

    /**
     * Checks if this let binding declares a mutable variable.
     *
     * @return true if the variable is mutable, false otherwise
     */
    @Override
    public boolean isMutable() {
        return getMut() != null;
    }
}
