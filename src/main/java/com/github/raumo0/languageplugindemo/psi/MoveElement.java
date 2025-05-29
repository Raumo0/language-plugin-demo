package com.github.raumo0.languageplugindemo.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Base interface for all Move language PSI elements.
 * This interface serves as a marker for elements that belong to the Move language.
 * It extends PsiElement to integrate with IntelliJ's PSI framework.
 */
public interface MoveElement extends PsiElement {
    /**
     * Gets the language version that this element is compatible with.
     * This can be used to check compatibility with different Move language versions.
     *
     * @return A string representing the Move language version
     */
    @NotNull
    default String getLanguageVersion() {
        return "1.0"; // Default language version, can be overridden
    }

    /**
     * Checks if this element is valid in the current context.
     * This can be used for additional validation beyond what the parser does.
     *
     * @return true if the element is valid, false otherwise
     */
    default boolean isValidMoveElement() {
        return true; // By default, all elements are considered valid
    }
}