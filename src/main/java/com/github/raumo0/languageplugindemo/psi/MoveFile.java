package com.github.raumo0.languageplugindemo.psi;

import com.github.raumo0.languageplugindemo.MoveFileType;
import com.github.raumo0.languageplugindemo.MoveLanguage;
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
