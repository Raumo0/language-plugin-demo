package com.github.raumo0.languageplugindemo;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class MoveFile extends PsiFileBase {

    public MoveFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MoveLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MoveFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Move File";
    }

}
