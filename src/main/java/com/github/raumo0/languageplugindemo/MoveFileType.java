package com.github.raumo0.languageplugindemo;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MoveFileType extends LanguageFileType {
    public static final MoveFileType INSTANCE = new MoveFileType();

    private MoveFileType() {
        super(MoveLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Move File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Move language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "move";
    }

    @Override
    public Icon getIcon() {
        return MoveIcons.FILE;
    }
}
