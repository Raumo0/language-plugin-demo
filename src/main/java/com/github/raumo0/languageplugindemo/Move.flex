package com.github.raumo0.languageplugindemo;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.github.raumo0.languageplugindemo.psi.MoveElementTypes;
import static com.github.raumo0.languageplugindemo.psi.MoveElementTypes.*;

%%

%class MoveLexerGen
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

// Whitespace
WHITE_SPACE_CHAR = [\ \t\f\n\r]
WHITE_SPACE = {WHITE_SPACE_CHAR}+

// Comments
LINE_COMMENT = "//" [^\r\n]*
BLOCK_COMMENT_START = "/*"
BLOCK_COMMENT_END = "*/"

// Identifiers
IDENTIFIER = [a-zA-Z][a-zA-Z0-9_]*
QUOTE_IDENTIFIER = \`[^`\r\n]*\`

// Literals
DECIMAL_DIGIT = [0-9]
HEX_DIGIT = [0-9a-fA-F]
INTEGER_LITERAL = {DECIMAL_DIGIT}+
HEX_INTEGER_LITERAL = 0[xX]{HEX_DIGIT}+

// Contextual keywords
MUT_KW = "mut"
CONST_KW = "const"
LET_KW = "let"

%state BLOCK_COMMENT

%%

<YYINITIAL> {
  {WHITE_SPACE}               { return TokenType.WHITE_SPACE; }
  {LINE_COMMENT}              { return LINE_COMMENT; }
  {BLOCK_COMMENT_START}       { yybegin(BLOCK_COMMENT); return BLOCK_COMMENT; }

  // Keywords for variables and constants
  {CONST_KW}                  { return CONST_KW; }
  {LET_KW}                    { return LET_KW; }
  {MUT_KW}                    { return MUT_KW; }

  // Literals
  {INTEGER_LITERAL}           { return INTEGER_LITERAL; }
  {HEX_INTEGER_LITERAL}       { return HEX_INTEGER_LITERAL; }

  // Identifiers
  {IDENTIFIER}                { return IDENTIFIER; }
  {QUOTE_IDENTIFIER}          { return QUOTE_IDENTIFIER; }

  // Operators and symbols needed for variable declarations
  "="                         { return EQ; }
  ";"                         { return SEMICOLON; }
  ":"                         { return COLON; }
  "::"                        { return COLON_COLON; }
}

<BLOCK_COMMENT> {
  {BLOCK_COMMENT_END}         { yybegin(YYINITIAL); return BLOCK_COMMENT; }
  [^*/]+                      { return BLOCK_COMMENT; }
  [*/]                        { return BLOCK_COMMENT; }
}

[^]                           { return TokenType.BAD_CHARACTER; }