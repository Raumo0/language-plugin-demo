// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.raumo0.languageplugindemo.psi.MoveElementType;
import com.github.raumo0.languageplugindemo.psi.MoveTokenType;
import com.github.raumo0.languageplugindemo.psi.impl.*;

public interface MoveTypes {

  IElementType PROPERTY = new MoveElementType("PROPERTY");

  IElementType BRACE_L = new MoveTokenType("{");
  IElementType BRACE_R = new MoveTokenType("}");
  IElementType BRACKET_L = new MoveTokenType("[");
  IElementType BRACKET_R = new MoveTokenType("]");
  IElementType COMMA = new MoveTokenType(",");
  IElementType COMMENT = new MoveTokenType("COMMENT");
  IElementType COMMENT_LINE = new MoveTokenType("Comment");
  IElementType CRLF = new MoveTokenType("CRLF");
  IElementType DOT = new MoveTokenType(".");
  IElementType KEY = new MoveTokenType("KEY");
  IElementType KW_LET = new MoveTokenType("let_kw");
  IElementType PARENTHESIS_L = new MoveTokenType("(");
  IElementType PARENTHESIS_R = new MoveTokenType(")");
  IElementType SEMICOLON = new MoveTokenType(";");
  IElementType SEPARATOR = new MoveTokenType("SEPARATOR");
  IElementType VALUE = new MoveTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new MovePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
