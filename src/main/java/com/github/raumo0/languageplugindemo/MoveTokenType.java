package com.github.raumo0.languageplugindemo;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MoveTokenType extends IElementType {
    public MoveTokenType(@NotNull @NonNls String debugName) {
        super(debugName, MoveLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SimpleTokenType." + super.toString();
    }
}
