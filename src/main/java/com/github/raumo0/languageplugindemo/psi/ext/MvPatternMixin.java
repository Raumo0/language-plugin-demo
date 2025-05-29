package com.github.raumo0.languageplugindemo.psi.ext;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base mixin class for pattern elements in the Move language.
 * Patterns are used in destructuring assignments and let bindings.
 */
public abstract class MvPatternMixin extends ASTWrapperPsiElement {

    /**
     * Constructs a new pattern mixin with the given AST node.
     *
     * @param node The AST node
     */
    public MvPatternMixin(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * For patterns that contain identifiers, this method should be implemented
     * to return the element that represents the identifier.
     *
     * @return The name identifier element, or null if this pattern doesn't contain an identifier
     */
    @Nullable
    public PsiElement getNameIdentifier() {
        return null; // To be overridden by implementing classes if needed
    }

    /**
     * Determines whether this pattern binds a new name.
     *
     * @return true if this pattern introduces a new binding, false otherwise
     */
    public boolean isBindingPattern() {
        return getNameIdentifier() != null;
    }
}