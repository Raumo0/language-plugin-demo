package com.github.raumo0.languageplugindemo.utils;

import com.github.raumo0.languageplugindemo.psi.MoveFile;
import com.github.raumo0.languageplugindemo.MoveFileType;
import com.github.raumo0.languageplugindemo.psi.MoveProperty;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MoveUtil {
    /**
     * Searches the entire project for Move language files with instances of the Move property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<MoveProperty> findProperties(Project project, String key) {
        List<MoveProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(MoveFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            MoveFile moveFile = (MoveFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (moveFile != null) {
                MoveProperty[] properties = PsiTreeUtil.getChildrenOfType(moveFile, MoveProperty.class);
                if (properties != null) {
                    for (MoveProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<MoveProperty> findProperties(Project project) {
        List<MoveProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(MoveFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            MoveFile moveFile = (MoveFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (moveFile != null) {
                MoveProperty[] properties = PsiTreeUtil.getChildrenOfType(moveFile, MoveProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

    /**
     * Attempts to collect any comment elements above the Move key/value pair.
     */
    public static @NotNull String findDocumentationComment(MoveProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result), "\n ");
    }
}
