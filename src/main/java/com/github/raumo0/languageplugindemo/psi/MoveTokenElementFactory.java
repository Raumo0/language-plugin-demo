package com.github.raumo0.languageplugindemo.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.github.raumo0.languageplugindemo.psi.MoveFile;
import com.github.raumo0.languageplugindemo.MoveFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Factory for creating Move language token elements.
 * This class provides utility methods for creating various PSI elements
 * by parsing code fragments.
 */
public class MoveTokenElementFactory {

    /**
     * Creates an identifier token with the given name.
     *
     * @param project The current project
     * @param name The name for the identifier
     * @return The AST node for the new identifier
     */
    @NotNull
    public static ASTNode createIdentifier(@NotNull Project project, @NotNull String name) {
        final MoveFile file = createFile(project, "let " + name + " = 0;");
        MoveLetBinding binding = PsiTreeUtil.findChildOfType(file, MoveLetBinding.class);
        if (binding != null) {
            PsiElement identifier = binding.getNameIdentifier();
            if (identifier != null) {
                return identifier.getNode();
            }
        }
        throw new IllegalStateException("Failed to create identifier: " + name);
    }

    /**
     * Creates a constant binding with the given name, type, and value.
     *
     * @param project The current project
     * @param name The name for the constant
     * @param type The type for the constant (can be null)
     * @param value The value for the constant
     * @return The constant binding element
     */
    @NotNull
    public static MoveConstBinding createConstBinding(@NotNull Project project, @NotNull String name,
                                                      @Nullable String type, @NotNull String value) {
        String typeStr = type != null ? ": " + type : "";
        final MoveFile file = createFile(project, "const " + name + typeStr + " = " + value + ";");
        MoveConstBinding binding = PsiTreeUtil.findChildOfType(file, MoveConstBinding.class);
        if (binding != null) {
            return binding;
        }
        throw new IllegalStateException("Failed to create const binding: " + name);
    }

    /**
     * Creates a let binding with the given name, type, and value.
     *
     * @param project The current project
     * @param name The name for the variable
     * @param type The type for the variable (can be null)
     * @param value The value for the variable
     * @return The let binding element
     */
    @NotNull
    public static MoveLetBinding createLetBinding(@NotNull Project project, @NotNull String name,
                                                  @Nullable String type, @NotNull String value) {
        String typeStr = type != null ? ": " + type : "";
        final MoveFile file = createFile(project, "let " + name + typeStr + " = " + value + ";");
        MoveLetBinding binding = PsiTreeUtil.findChildOfType(file, MoveLetBinding.class);
        if (binding != null) {
            return binding;
        }
        throw new IllegalStateException("Failed to create let binding: " + name);
    }

    /**
     * Creates a type element with the given type text.
     *
     * @param project The current project
     * @param typeText The text of the type
     * @return The type element
     */
    @NotNull
    public static MoveType createType(@NotNull Project project, @NotNull String typeText) {
        final MoveFile file = createFile(project, "let x: " + typeText + " = 0;");
        MoveType type = PsiTreeUtil.findChildOfType(file, MoveType.class);
        if (type != null) {
            return type;
        }
        throw new IllegalStateException("Failed to create type: " + typeText);
    }

    /**
     * Creates a pattern element with the given pattern text.
     *
     * @param project The current project
     * @param patternText The text of the pattern
     * @return The pattern element
     */
    @NotNull
    public static MovePattern createPattern(@NotNull Project project, @NotNull String patternText) {
        final MoveFile file = createFile(project, "let " + patternText + " = 0;");
        MovePattern pattern = PsiTreeUtil.findChildOfType(file, MovePattern.class);
        if (pattern != null) {
            return pattern;
        }
        throw new IllegalStateException("Failed to create pattern: " + patternText);
    }

    /**
     * Creates a tuple pattern element with the given elements.
     *
     * @param project The current project
     * @param elements The elements of the tuple pattern
     * @return The tuple pattern element
     */
    @NotNull
    public static MoveTuplePattern createTuplePattern(@NotNull Project project, @NotNull String... elements) {
        String patternText = "(" + String.join(", ", elements) + ")";
        final MoveFile file = createFile(project, "let " + patternText + " = 0;");
        MoveTuplePattern pattern = PsiTreeUtil.findChildOfType(file, MoveTuplePattern.class);
        if (pattern != null) {
            return pattern;
        }
        throw new IllegalStateException("Failed to create tuple pattern: " + patternText);
    }

    /**
     * Creates an expression element with the given expression text.
     *
     * @param project The current project
     * @param exprText The text of the expression
     * @return The expression element
     */
    @NotNull
    public static MoveExpr createExpr(@NotNull Project project, @NotNull String exprText) {
        final MoveFile file = createFile(project, "let x = " + exprText + ";");
        MoveExpr expr = PsiTreeUtil.findChildOfType(file, MoveExpr.class);
        if (expr != null) {
            return expr;
        }
        throw new IllegalStateException("Failed to create expression: " + exprText);
    }

    /**
     * Creates a colon token.
     *
     * @param project The current project
     * @return The colon token node
     */
    @NotNull
    public static ASTNode createColon(@NotNull Project project) {
        final MoveFile file = createFile(project, "let x: u8 = 0;");
        PsiElement colon = findFirstChildByType(file, MoveElementTypes.COLON);
        if (colon != null) {
            return colon.getNode();
        }
        throw new IllegalStateException("Failed to create colon");
    }

    /**
     * Creates an equals token.
     *
     * @param project The current project
     * @return The equals token node
     */
    @NotNull
    public static ASTNode createEquals(@NotNull Project project) {
        final MoveFile file = createFile(project, "let x = 0;");
        PsiElement eq = findFirstChildByType(file, MoveElementTypes.EQ);
        if (eq != null) {
            return eq.getNode();
        }
        throw new IllegalStateException("Failed to create equals");
    }

    /**
     * Creates a semicolon token.
     *
     * @param project The current project
     * @return The semicolon token node
     */
    @NotNull
    public static ASTNode createSemicolon(@NotNull Project project) {
        final MoveFile file = createFile(project, "let x = 0;");
        PsiElement semicolon = findFirstChildByType(file, MoveElementTypes.SEMICOLON);
        if (semicolon != null) {
            return semicolon.getNode();
        }
        throw new IllegalStateException("Failed to create semicolon");
    }

    /**
     * Creates a comma token.
     *
     * @param project The current project
     * @return The comma token node
     */
    @NotNull
    public static ASTNode createComma(@NotNull Project project) {
        final MoveFile file = createFile(project, "let (x, y) = (1, 2);");
        PsiElement comma = findFirstChildByType(file, MoveElementTypes.COMMA);
        if (comma != null) {
            return comma.getNode();
        }
        throw new IllegalStateException("Failed to create comma");
    }

    /**
     * Creates a left parenthesis token.
     *
     * @param project The current project
     * @return The left parenthesis token node
     */
    @NotNull
    public static ASTNode createLParen(@NotNull Project project) {
        final MoveFile file = createFile(project, "let (x) = (1);");
        PsiElement lparen = findFirstChildByType(file, MoveElementTypes.L_PAREN);
        if (lparen != null) {
            return lparen.getNode();
        }
        throw new IllegalStateException("Failed to create left parenthesis");
    }

    /**
     * Creates a right parenthesis token.
     *
     * @param project The current project
     * @return The right parenthesis token node
     */
    @NotNull
    public static ASTNode createRParen(@NotNull Project project) {
        final MoveFile file = createFile(project, "let (x) = (1);");
        PsiElement rparen = findFirstChildByType(file, MoveElementTypes.R_PAREN);
        if (rparen != null) {
            return rparen.getNode();
        }
        throw new IllegalStateException("Failed to create right parenthesis");
    }

    /**
     * Creates a dummy Move file with the given text.
     *
     * @param project The current project
     * @param text The text for the file
     * @return The created file
     */
    @NotNull
    private static MoveFile createFile(@NotNull Project project, @NotNull String text) {
        String fileName = "dummy.move";
        return (MoveFile) PsiFileFactory.getInstance(project)
                .createFileFromText(fileName, MoveFileType.INSTANCE, text);
    }

    /**
     * Finds the first child of the given element with the specified type.
     *
     * @param element The parent element
     * @param type The type to search for
     * @return The first child with the specified type, or null if none is found
     */
    @Nullable
    private static PsiElement findFirstChildByType(@NotNull PsiElement element, @NotNull IElementType type) {
        for (PsiElement child : element.getChildren()) {
            if (child.getNode().getElementType() == type) {
                return child;
            }
            PsiElement result = findFirstChildByType(child, type);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}