package com.github.raumo0.languageplugindemo.psi.impl;

import com.github.raumo0.languageplugindemo.psi.MoveElementTypes;
import com.github.raumo0.languageplugindemo.psi.MoveNamedPattern;
import com.github.raumo0.languageplugindemo.psi.MoveTokenElementFactory;
import com.github.raumo0.languageplugindemo.psi.MoveTuplePattern;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Implementation for MoveNamedPattern.
 */
public class MoveNamedPatternImpl extends MvNameIdentifierOwnerImpl implements MoveNamedPattern {

    /**
     * Constructs a new named pattern with the given AST node.
     *
     * @param node The AST node
     */
    public MoveNamedPatternImpl(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * Gets the name of this named pattern.
     *
     * @return The name
     */
    @Override
    public String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }

    /**
     * Gets the name identifier element of this named pattern.
     * For named patterns, this is the identifier that names the variable.
     *
     * @return The name identifier element
     */
    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return getIdentifier();
    }

    @Override
    public @Nullable MoveTuplePattern getTuplePattern() {
        return null;
    }

    /**
     * Gets the identifier element of this named pattern.
     *
     * @return The identifier element
     */
    @Nullable
    @Override
    public PsiElement getIdentifier() {
        return findChildByType(MoveElementTypes.IDENTIFIER);
    }

    /**
     * Gets the binding mode of this named pattern, if any.
     * The binding mode can be 'mut' to indicate a mutable binding.
     *
     * @return The binding mode element, or null if not specified
     */
    @Nullable
    @Override
    public PsiElement getBindingMode() {
        return findChildByType(MoveElementTypes.MUT);
    }

    /**
     * Checks if this named pattern declares a mutable binding.
     *
     * @return true if the binding is mutable, false otherwise
     */
    @Override
    public boolean isMutable() {
        return getBindingMode() != null;
    }

    /**
     * Sets the name of this named pattern.
     *
     * @param name The new name
     * @return The updated named pattern
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
}
