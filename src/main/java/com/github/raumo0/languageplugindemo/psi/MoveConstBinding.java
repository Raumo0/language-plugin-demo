package com.github.raumo0.languageplugindemo.psi;

import org.jetbrains.annotations.Nullable;

/**
 * Represents a const binding in Move language.
 * Const bindings are used to declare constants.
 * Example: const MAX_VALUE: u8 = 255;
 */
public interface MoveConstBinding extends MvNameIdentifierOwner {

    /**
     * Gets the type annotation of this const binding, if any.
     *
     * @return The type element, or null if not specified
     */
    @Nullable
    MoveType getType();

    /**
     * Gets the initialization expression of this const binding.
     *
     * @return The expression element
     */
    @Nullable
    MoveExpr getExpr();
}
