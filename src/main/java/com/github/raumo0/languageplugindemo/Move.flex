// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.raumo0.languageplugindemo.MoveTypes;
import com.intellij.psi.TokenType;

%%

%class MoveLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

EOL_WS           = \n | \r | \r\n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {EOL_WS} | {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

COMMENT_LINE     = ("//".*)

KW_LET       = let

%state WAITING_VALUE

%%

<YYINITIAL> {
    {WHITE_SPACE}     { return TokenType.WHITE_SPACE; }
	{COMMENT_LINE}     { return MoveTypes.COMMENT_LINE; }
    {END_OF_LINE_COMMENT} { return MoveTypes.COMMENT; }
}

<YYINITIAL> {
	"(" { return MoveTypes.PARENTHESIS_L; }
    ")" { return MoveTypes.PARENTHESIS_R; }
    "[" { return MoveTypes.BRACKET_L; }
    "]" { return MoveTypes.BRACKET_R; }
	"{" { return MoveTypes.BRACE_L; }
	"}" { return MoveTypes.BRACE_R; }
}

<YYINITIAL> {
	;   { return MoveTypes.SEMICOLON; }
    "." { return MoveTypes.DOT; }
    "," { return MoveTypes.COMMA; }
}

<YYINITIAL> {
	{KW_LET}       { return MoveTypes.KW_LET; }
}

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return MoveTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return MoveTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return MoveTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }