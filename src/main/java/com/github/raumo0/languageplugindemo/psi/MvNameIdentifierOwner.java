package com.github.raumo0.languageplugindemo.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.Nullable;

/**
 * Interface for Move language elements that have an identifier which serves as their name.
 * This interface extends PsiNameIdentifierOwner to integrate with IntelliJ's name-related functionality.
 */
public interface MvNameIdentifierOwner extends PsiNameIdentifierOwner, MoveElement {
    /**
     * Returns the PSI element that serves as this element's name identifier.
     * This is typically an IDENTIFIER token in the AST.
     *
     * @return The name identifier element, or null if this element doesn't have a name
     */
    @Nullable
    @Override
    PsiElement getNameIdentifier();

    /**
     * Gets the text of the name identifier.
     *
     * @return The name as a string, or null if there is no name identifier
     */
    @Nullable
    @Override
    default String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }
}