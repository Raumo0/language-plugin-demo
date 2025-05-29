package com.github.raumo0.languageplugindemo.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a let binding in Move language.
 * Let bindings are used to declare local variables.
 * Example: let x: u8 = 10;
 */
public interface MoveLetBinding extends MvNameIdentifierOwner {

    /**
     * Gets the pattern of this let binding.
     *
     * @return The pattern element
     */
    @Nullable
    MovePattern getPattern();

    /**
     * Gets the type annotation of this let binding, if any.
     *
     * @return The type element, or null if not specified
     */
    @Nullable
    MoveType getType();

    /**
     * Gets the initialization expression of this let binding.
     *
     * @return The expression element
     */
    @Nullable
    MoveExpr getExpr();

    /**
     * Gets the 'mut' keyword element of this let binding, if any.
     * A let binding with 'mut' keyword declares a mutable variable.
     *
     * @return The 'mut' keyword element, or null if not specified
     */
    @Nullable
    PsiElement getMut();

    /**
     * Checks if this let binding declares a mutable variable.
     *
     * @return true if the variable is mutable, false otherwise
     */
    boolean isMutable();
}


