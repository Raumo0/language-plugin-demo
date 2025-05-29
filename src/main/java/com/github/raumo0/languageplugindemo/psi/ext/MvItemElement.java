package com.github.raumo0.languageplugindemo.psi.ext;

import com.intellij.psi.PsiElement;
import com.github.raumo0.languageplugindemo.psi.MvNameIdentifierOwner;

/**
 * Interface representing an item element in Move language.
 * Items are top-level declarations like constants, modules, etc.
 */
public interface MvItemElement extends MvNameIdentifierOwner {
    // This interface serves as a marker for item elements in the Move language
    // It extends MvNameIdentifierOwner to ensure all items have identifiable names
}