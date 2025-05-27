package com.github.raumo0.languageplugindemo.psi;

import com.github.raumo0.languageplugindemo.MoveLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MoveElementType extends IElementType {

    public MoveElementType(@NotNull @NonNls String debugName) {
        super(debugName, MoveLanguage.INSTANCE);
    }

}
