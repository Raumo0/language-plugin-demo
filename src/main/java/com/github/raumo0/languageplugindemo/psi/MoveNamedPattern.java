package com.github.raumo0.languageplugindemo.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a named pattern in Move language.
 * Named patterns are used in let bindings and function parameters to name a variable.
 * Example: let x: u8 = 10; (where 'x' is the named pattern)
 */
public interface MoveNamedPattern extends MovePattern, MvNameIdentifierOwner {

    /**
     * Gets the identifier element of this named pattern.
     *
     * @return The identifier element
     */
    @Nullable
    PsiElement getIdentifier();

    /**
     * Gets the binding mode of this named pattern, if any.
     * The binding mode can be 'mut' to indicate a mutable binding.
     *
     * @return The binding mode element, or null if not specified
     */
    @Nullable
    PsiElement getBindingMode();

    /**
     * Checks if this named pattern declares a mutable binding.
     *
     * @return true if the binding is mutable, false otherwise
     */
    boolean isMutable();
}