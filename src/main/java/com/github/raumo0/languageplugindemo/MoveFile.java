package com.github.raumo0.languageplugindemo.psi;

import com.github.raumo0.languageplugindemo.MoveFileType;
import com.github.raumo0.languageplugindemo.MoveLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a Move language file in the PSI structure.
 * This class provides methods to access the scripts, modules, and module specs defined in the file.
 */
public class MoveFile extends PsiFileBase {

    /**
     * Constructs a new Move file with the given file view provider.
     *
     * @param fileViewProvider The file view provider for this file
     */
    public MoveFile(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, MoveLanguage.INSTANCE);
    }

    /**
     * Gets the file type of this file.
     *
     * @return The Move file type
     */
    @NotNull
    @Override
    public FileType getFileType() {
        return MoveFileType.INSTANCE;
    }

    /**
     * Gets a string representation of this file.
     *
     * @return The name of the file
     */
    @Override
    public String toString() {
        return "Move File: " + getName();
    }

//    /**
//     * Gets all scripts defined in this file.
//     *
//     * @return A list of all scripts in the file
//     */
//    @NotNull
//    public List<MvScript> scripts() {
//        return childrenOfType(MvScript.class);
//    }
//
//    /**
//     * Gets all modules defined in this file.
//     *
//     * @return A list of all modules in the file
//     */
//    @NotNull
//    public List<MvModule> modules() {
//        return new FileModules(this).getResults();
//    }
//
//    /**
//     * Gets all module specs defined in this file.
//     *
//     * @return A list of all module specs in the file
//     */
//    @NotNull
//    public List<MvModuleSpec> moduleSpecs() {
//        return childrenOfType(MvModuleSpec.class);
//    }

    /**
     * Gets all children of the specified type in this file.
     *
     * @param <T> The type of children to get
     * @param clazz The class of the children to get
     * @return A list of all children of the specified type
     */
//    @NotNull
//    private <T> List<T> childrenOfType(@NotNull Class<T> clazz) {
//        T[] children = PsiTreeUtil.getChildrenOfType(this, clazz);
//        if (children == null) {
//            return List.of();
//        }
//        return Arrays.stream(children)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//    }
}