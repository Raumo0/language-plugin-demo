package com.github.raumo0.languageplugindemo.psi.ext;

import com.github.raumo0.languageplugindemo.psi.MoveElement;
import com.github.raumo0.languageplugindemo.psi.MoveType;

/**
 * Interface for PSI elements that can have type ascriptions (type annotations).
 * Elements like constants, let bindings, and function parameters can have type ascriptions.
 */
public interface MvTypeAscriptionOwner extends MoveElement {
    /**
     * Returns the type associated with this element, if available.
     *
     * @return The type of this element, or null if no type is specified
     */
    MoveType getType();
}