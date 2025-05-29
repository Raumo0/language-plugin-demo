package com.github.raumo0.languageplugindemo.psi.ext;

import com.github.raumo0.languageplugindemo.psi.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Mixin class for constant declarations in Move language.
 * This class implements the necessary behavior for constants, including
 * name resolution and type information.
 */
public abstract class MvConstBindingMixin extends ASTWrapperPsiElement implements MoveConst, MvItemElement, MvTypeAscriptionOwner {

    /**
     * Constructs a new constant binding mixin with the given AST node.
     *
     * @param node The AST node
     */
    public MvConstBindingMixin(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * Gets the name identifier of this constant.
     * This is the IDENTIFIER token in the AST.
     *
     * @return The name identifier element
     */
    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return findChildByType(MoveElementTypes.IDENTIFIER);
    }

    /**
     * Gets the type of this constant from its type ascription.
     *
     * @return The type of the constant, or null if no type is specified
     */
    @Nullable
    @Override
    public MoveType getType() {
        // Get the TypeAscription element and then get its Type child
        return PsiTreeUtil.findChildOfType(
                PsiTreeUtil.findChildOfType(this, MoveTypeAscription.class),
                MoveType.class
        );
    }

    /**
     * Gets the initializer expression of this constant.
     *
     * @return The initializer element, or null if there is no initializer
     */
    @Nullable
    public PsiElement getInitializer() {
        // Get the Initializer element and then get its Expr child
        return PsiTreeUtil.findChildOfType(
                PsiTreeUtil.findChildOfType(this, MoveInitializer.class),
                MoveExpr.class
        );
    }

    /**
     * Gets the text representation of the type of this constant.
     *
     * @return The type as a string, or null if no type is specified
     */
    @Nullable
    public String getTypeText() {
        MoveType type = getType();
        return type != null ? type.getText() : null;
    }

    /**
     * Sets the name of this constant.
     * This method is called during rename refactorings.
     *
     * @param name The new name for the constant
     * @return The result of the rename operation
     */
    @Override
    public PsiElement setName(@NotNull String name) {
        PsiElement identifier = getNameIdentifier();
        if (identifier != null) {
            ASTNode identifierNode = identifier.getNode();
            ASTNode newIdentifierNode = MoveTokenElementFactory.createIdentifier(getProject(), name);
            getNode().replaceChild(identifierNode, newIdentifierNode);
        }
        return this;
    }
}