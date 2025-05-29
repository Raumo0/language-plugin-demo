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
 * Mixin implementation for MoveConstBinding.
 */
public class MoveConstBindingImpl extends MvNameIdentifierOwnerImpl implements MoveConstBinding {

    /**
     * Constructs a new const binding with the given AST node.
     *
     * @param node The AST node
     */
    public MoveConstBindingImpl(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * Gets the name of this const binding.
     *
     * @return The name
     */
    @Override
    public String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }

    /**
     * Gets the name identifier element of this const binding.
     * For const bindings, this is the identifier following the 'const' keyword.
     *
     * @return The name identifier element
     */
    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return findChildByType(MoveElementTypes.IDENTIFIER);
    }

    /**
     * Sets the name of this const binding.
     *
     * @param name The new name
     * @return The updated const binding
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
     * Gets the icon for this const binding.
     *
     * @param flags The icon flags
     * @return The icon
     */
    @Override
    public Icon getIcon(int flags) {
        return MoveIcons.CONSTANT;
    }

    @Override
    public @Nullable MoveType getType() {
        return null;
    }

    @Override
    public @Nullable MoveExpr getExpr() {
        return null;
    }
}
