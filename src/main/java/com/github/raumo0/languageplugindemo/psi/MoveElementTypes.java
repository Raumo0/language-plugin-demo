package com.github.raumo0.languageplugindemo.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * Holds element types for the Move language grammar.
 * This class is generated from the BNF grammar and contains all token types and element types.
 */
public interface MoveElementTypes {
    // Keywords
    IElementType LET = new MoveTokenType("LET");
    IElementType CONST = new MoveTokenType("CONST");
    IElementType MUT = new MoveTokenType("MUT");

    // Identifiers and literals
    IElementType IDENTIFIER = new MoveTokenType("IDENTIFIER");
    IElementType INTEGER_LITERAL = new MoveTokenType("INTEGER_LITERAL");
    IElementType HEX_INTEGER_LITERAL = new MoveTokenType("HEX_INTEGER_LITERAL");
    IElementType BOOL_LITERAL = new MoveTokenType("BOOL_LITERAL");

    // Operators and punctuation
    IElementType SEMICOLON = new MoveTokenType("SEMICOLON");
    IElementType COLON = new MoveTokenType("COLON");
    IElementType EQ = new MoveTokenType("EQ");
    IElementType COMMA = new MoveTokenType("COMMA");
    IElementType L_PAREN = new MoveTokenType("L_PAREN");
    IElementType R_PAREN = new MoveTokenType("R_PAREN");
    IElementType L_BRACE = new MoveTokenType("L_BRACE");
    IElementType R_BRACE = new MoveTokenType("R_BRACE");

    // PSI elements
    IElementType LET_BINDING = new MoveElementType("LET_BINDING");
    IElementType CONST_BINDING = new MoveElementType("CONST_BINDING");
    IElementType TYPE_ASCRIPTION = new MoveElementType("TYPE_ASCRIPTION");
    IElementType INITIALIZER = new MoveElementType("INITIALIZER");
    IElementType PATTERN = new MoveElementType("PATTERN");
    IElementType IDENTIFIER_PATTERN = new MoveElementType("IDENTIFIER_PATTERN");
    IElementType TUPLE_PATTERN = new MoveElementType("TUPLE_PATTERN");
    IElementType TYPE = new MoveElementType("TYPE");
    IElementType PRIMITIVE_TYPE = new MoveElementType("PRIMITIVE_TYPE");
    IElementType TUPLE_TYPE = new MoveElementType("TUPLE_TYPE");
    IElementType EXPR = new MoveElementType("EXPR");
    IElementType LITERAL_EXPR = new MoveElementType("LITERAL_EXPR");
    IElementType PATH_EXPR = new MoveElementType("PATH_EXPR");
    IElementType TUPLE_EXPR = new MoveElementType("TUPLE_EXPR");

    // Token sets for easier handling of related tokens
    TokenSet KEYWORDS = TokenSet.create(LET, CONST);
    TokenSet LITERALS = TokenSet.create(INTEGER_LITERAL, HEX_INTEGER_LITERAL, BOOL_LITERAL);
    TokenSet OPERATORS = TokenSet.create(EQ);
    TokenSet PUNCTUATION = TokenSet.create(SEMICOLON, COLON, COMMA, L_PAREN, R_PAREN, L_BRACE, R_BRACE);
    TokenSet EXPRESSIONS = TokenSet.create(EXPR, LITERAL_EXPR, PATH_EXPR, TUPLE_EXPR);
    TokenSet PATTERNS = TokenSet.create(PATTERN, IDENTIFIER_PATTERN, TUPLE_PATTERN);
    TokenSet TYPES = TokenSet.create(TYPE, PRIMITIVE_TYPE, TUPLE_TYPE);

    // Common whitespace and comments
    IElementType WHITE_SPACE = new MoveTokenType("WHITE_SPACE");
    IElementType COMMENT = new MoveTokenType("COMMENT");
    IElementType DOC_COMMENT = new MoveTokenType("DOC_COMMENT");

    // Token set for comments
    TokenSet COMMENTS = TokenSet.create(COMMENT, DOC_COMMENT);

    // Token set for whitespace
    TokenSet WHITESPACES = TokenSet.create(WHITE_SPACE);
}
