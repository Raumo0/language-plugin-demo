package com.github.raumo0.languageplugindemo.parser;

import com.github.raumo0.languageplugindemo.*;
import com.github.raumo0.languageplugindemo.language.MoveTokenSets;
import com.github.raumo0.languageplugindemo.language.MoveTypes;
import com.github.raumo0.languageplugindemo.lexer.MoveLexerAdapter;
import com.github.raumo0.languageplugindemo.psi.MoveFile;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

final class MoveParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(MoveLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new MoveLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return MoveTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new MoveParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new MoveFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return MoveTypes.Factory.createElement(node);
    }

}