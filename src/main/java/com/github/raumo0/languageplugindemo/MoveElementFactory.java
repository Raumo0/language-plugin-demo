package com.github.raumo0.languageplugindemo;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class MoveElementFactory {

    public static MoveProperty createProperty(Project project, String name) {
        MoveFile file = createFile(project, name);
        return (MoveProperty) file.getFirstChild();
    }

    public static MoveFile createFile(Project project, String text) {
        String name = "dummy.move";
        return (MoveFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, MoveFileType.INSTANCE, text);
    }
}
