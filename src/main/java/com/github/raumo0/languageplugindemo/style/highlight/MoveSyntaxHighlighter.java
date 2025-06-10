package com.github.raumo0.languageplugindemo.style.highlight;

import com.github.raumo0.languageplugindemo.language.MoveTypes;
import com.github.raumo0.languageplugindemo.lexer.MoveLexerAdapter;
import com.github.raumo0.languageplugindemo.style.color.MoveColor;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MoveSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("MOVE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("MOVE_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("MOVE_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("MOVE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("MOVE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey PARENTHESES =
            createTextAttributesKey("MOVE_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACES =
            createTextAttributesKey("MOVE_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKETS =
            createTextAttributesKey("MOVE_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new MoveLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        MoveColor moveColor = map(tokenType);
        return pack(moveColor != null ? moveColor.getTextAttributesKey() : null);
    }

    private static MoveColor map(IElementType tokenType) {
        if (tokenType.equals(MoveTypes.SEPARATOR)) {
            return MoveColor.SEPARATOR;
        }
        if (tokenType.equals(MoveTypes.KEY)) {
            return MoveColor.KEY;
        }
        if (tokenType.equals(MoveTypes.VALUE)) {
            return MoveColor.VALUE;
        }
        if (tokenType.equals(MoveTypes.COMMENT) || tokenType.equals(MoveTypes.COMMENT_LINE)) {
            return MoveColor.LINE_COMMENT;
        }
        if (tokenType.equals(MoveTypes.PARENTHESIS_L) || tokenType.equals(MoveTypes.PARENTHESIS_R)) {
            return MoveColor.PARENTHESES;
        }
        if (tokenType.equals(MoveTypes.BRACE_L) || tokenType.equals(MoveTypes.BRACE_R)) {
            return MoveColor.BRACES;
        }
        if (tokenType.equals(MoveTypes.BRACKET_L) || tokenType.equals(MoveTypes.BRACKET_R)) {
            return MoveColor.BRACKETS;
        }
        if (tokenType.equals(MoveTypes.SEMICOLON)) {
            return MoveColor.SEMICOLON;
        }
        if (tokenType.equals(MoveTypes.DOT)) {
            return MoveColor.DOT;
        }
        if (tokenType.equals(MoveTypes.COMMA)) {
            return MoveColor.COMMA;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return MoveColor.BAD_CHARACTER;
        }

        return null;
    }
}
