package com.github.raumo0.languageplugindemo.navigation;

import com.github.raumo0.languageplugindemo.psi.MoveFile;
import com.github.raumo0.languageplugindemo.MoveLanguage;
import com.github.raumo0.languageplugindemo.psi.MoveProperty;
import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

final class MoveStructureAwareNavbar extends StructureAwareNavBarModelExtension {

    @NotNull
    @Override
    protected Language getLanguage() {
        return MoveLanguage.INSTANCE;
    }

    @Override
    public @Nullable String getPresentableText(Object object) {
        if (object instanceof MoveFile) {
            return ((MoveFile) object).getName();
        }
        if (object instanceof MoveProperty) {
            return ((MoveProperty) object).getName();
        }

        return null;
    }

    @Override
    @Nullable
    public Icon getIcon(Object object) {
        if (object instanceof MoveProperty) {
            return AllIcons.Nodes.Property;
        }

        return null;
    }

}