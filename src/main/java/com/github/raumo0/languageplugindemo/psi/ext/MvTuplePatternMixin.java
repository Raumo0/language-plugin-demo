package com.github.raumo0.languageplugindemo.psi.ext;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.github.raumo0.languageplugindemo.psi.MoveElementTypes;
import com.github.raumo0.languageplugindemo.psi.MovePattern;
import com.github.raumo0.languageplugindemo.psi.MoveTuplePattern;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Mixin class for tuple patterns in Move language.
 * A tuple pattern is a pattern enclosed in parentheses, e.g., (x, y, z)
 */
public abstract class MvTuplePatternMixin extends ASTWrapperPsiElement implements MoveTuplePattern {

    /**
     * Constructs a new tuple pattern mixin with the given AST node.
     *
     * @param node The AST node
     */
    public MvTuplePatternMixin(@NotNull ASTNode node) {
        super(node);
    }

    /**
     * Gets all patterns that make up this tuple.
     *
     * @return An array of patterns in the tuple
     */
    @NotNull
    public MovePattern[] getPatterns() {
        return PsiTreeUtil.getChildrenOfType(this, MovePattern.class);
    }

    /**
     * Gets the number of patterns in the tuple.
     *
     * @return The size of the tuple
     */
    public int getSize() {
        MovePattern[] patterns = getPatterns();
        return patterns != null ? patterns.length : 0;
    }

    /**
     * Gets the pattern at the specified index in the tuple.
     *
     * @param index The index of the pattern to retrieve
     * @return The pattern at the specified index, or null if the index is out of bounds
     */
    public MovePattern getPatternAt(int index) {
        MovePattern[] patterns = getPatterns();
        if (patterns != null && index >= 0 && index < patterns.length) {
            return patterns[index];
        }
        return null;
    }

    /**
     * Gets all patterns in the tuple as a list.
     *
     * @return A list of patterns in the tuple
     */
    @NotNull
    public List<MovePattern> getPatternList() {
        MovePattern[] patterns = getPatterns();
        return patterns != null ? Arrays.asList(patterns) : List.of();
    }

    /**
     * Gets the left parenthesis element of the tuple pattern.
     *
     * @return The left parenthesis element
     */
    public PsiElement getLParen() {
        return findChildByType(MoveElementTypes.L_PAREN);
    }

    /**
     * Gets the right parenthesis element of the tuple pattern.
     *
     * @return The right parenthesis element
     */
    public PsiElement getRParen() {
        return findChildByType(MoveElementTypes.R_PAREN);
    }

    /**
     * Gets the comma elements that separate the patterns in the tuple.
     *
     * @return An array of comma elements
     */
    public PsiElement[] getCommas() {
        return findChildrenByType(MoveElementTypes.COMMA, PsiElement.class);
    }

    /**
     * Checks if this tuple pattern is empty (contains no patterns).
     *
     * @return true if the tuple is empty, false otherwise
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Checks if this tuple pattern is a unit tuple (contains no patterns).
     * A unit tuple is represented as () in Move.
     *
     * @return true if this is a unit tuple, false otherwise
     */
    public boolean isUnitTuple() {
        return isEmpty();
    }
}