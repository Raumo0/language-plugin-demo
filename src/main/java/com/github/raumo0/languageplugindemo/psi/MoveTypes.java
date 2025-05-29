// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.raumo0.languageplugindemo.psi.impl.*;

public interface MoveTypes {

//  IElementType CONST = new MoveElementType("CONST");
  IElementType EXPR = new MoveElementType("EXPR");
  IElementType INITIALIZER = new MoveElementType("INITIALIZER");
  IElementType LITERAL_EXPR = new MoveElementType("LITERAL_EXPR");
  IElementType PATH_EXPR = new MoveElementType("PATH_EXPR");
  IElementType PATTERN = new MoveElementType("PATTERN");
  IElementType TUPLE_EXPR = new MoveElementType("TUPLE_EXPR");
  IElementType TUPLE_PATTERN = new MoveElementType("TUPLE_PATTERN");
  IElementType TUPLE_TYPE = new MoveElementType("TUPLE_TYPE");
  IElementType TYPE = new MoveElementType("TYPE");
  IElementType TYPE_ASCRIPTION = new MoveElementType("TYPE_ASCRIPTION");

  IElementType BOOL_LITERAL = new MoveTokenType("BOOL_LITERAL");
  IElementType COLON = new MoveTokenType(":");
  IElementType COMMA = new MoveTokenType(",");
  IElementType CONST = new MoveTokenType("const");
  IElementType EQ = new MoveTokenType("=");
  IElementType HEX_INTEGER_LITERAL = new MoveTokenType("HEX_INTEGER_LITERAL");
  IElementType IDENTIFIER = new MoveTokenType("IDENTIFIER");
  IElementType INTEGER_LITERAL = new MoveTokenType("INTEGER_LITERAL");
  IElementType LET = new MoveTokenType("let");
  IElementType L_BRACE = new MoveTokenType("{");
  IElementType L_PAREN = new MoveTokenType("(");
  IElementType R_BRACE = new MoveTokenType("}");
  IElementType R_PAREN = new MoveTokenType(")");
  IElementType SEMICOLON = new MoveTokenType(";");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CONST) {
        return new MoveConstImpl(node);
      }
      else if (type == INITIALIZER) {
        return new MoveInitializerImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new MoveLiteralExprImpl(node);
      }
      else if (type == PATH_EXPR) {
        return new MovePathExprImpl(node);
      }
      else if (type == PATTERN) {
        return new MovePatternImpl(node);
      }
      else if (type == TUPLE_EXPR) {
        return new MoveTupleExprImpl(node);
      }
      else if (type == TUPLE_PATTERN) {
        return new MoveTuplePatternImpl(node);
      }
      else if (type == TUPLE_TYPE) {
        return new MoveTupleTypeImpl(node);
      }
      else if (type == TYPE) {
        return new MoveTypeImpl(node);
      }
      else if (type == TYPE_ASCRIPTION) {
        return new MoveTypeAscriptionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
