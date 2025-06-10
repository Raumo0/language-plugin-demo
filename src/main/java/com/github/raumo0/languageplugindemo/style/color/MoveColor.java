package com.github.raumo0.languageplugindemo.style.color;

import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;

public enum MoveColor {
    VARIABLE("Variables//Default", DefaultLanguageHighlighterColors.IDENTIFIER),

    LINE_COMMENT("Comments//Line comment", DefaultLanguageHighlighterColors.LINE_COMMENT),

    BRACES("Braces and Operators//Braces", DefaultLanguageHighlighterColors.BRACES),
    BRACKETS("Braces and Operators//Brackets", DefaultLanguageHighlighterColors.BRACKETS),
    OPERATORS("Braces and Operators//Operation sign", DefaultLanguageHighlighterColors.OPERATION_SIGN),
    SEMICOLON("Braces and Operators//Semicolon", DefaultLanguageHighlighterColors.SEMICOLON),
    DOT("Braces and Operators//Dot", DefaultLanguageHighlighterColors.DOT),
    COMMA("Braces and Operators//Comma", DefaultLanguageHighlighterColors.COMMA),
    PARENTHESES("Braces and Operators//Parentheses", DefaultLanguageHighlighterColors.PARENTHESES),
    BAD_CHARACTER("Bad character",HighlighterColors.BAD_CHARACTER),
    SEPARATOR("Separator", DefaultLanguageHighlighterColors.OPERATION_SIGN),
    KEY("Key", DefaultLanguageHighlighterColors.KEYWORD),
    VALUE("Value",DefaultLanguageHighlighterColors.STRING), ;

    private final TextAttributesKey textAttributesKey;
    private final AttributesDescriptor attributesDescriptor;
    private final HighlightSeverity testSeverity;

    MoveColor(String humanName, TextAttributesKey defaultAttributes) {
        this.textAttributesKey = TextAttributesKey.createTextAttributesKey("org.move." + name(), defaultAttributes);
        this.attributesDescriptor = new AttributesDescriptor(humanName, textAttributesKey);
        this.testSeverity = new HighlightSeverity(name(), HighlightSeverity.INFORMATION.myVal);
    }

    public TextAttributesKey getTextAttributesKey() {
        return textAttributesKey;
    }

    public AttributesDescriptor getAttributesDescriptor() {
        return attributesDescriptor;
    }

    public HighlightSeverity getTestSeverity() {
        return testSeverity;
    }
}

