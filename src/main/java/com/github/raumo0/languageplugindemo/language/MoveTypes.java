// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.language;

import com.github.raumo0.languageplugindemo.psi.MoveElementType;
import com.github.raumo0.languageplugindemo.psi.MoveTokenType;
import com.github.raumo0.languageplugindemo.psi.impl.MovePropertyImpl;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface MoveTypes {

  IElementType PROPERTY = new MoveElementType("PROPERTY");

  IElementType COMMENT = new MoveTokenType("COMMENT");
  IElementType CRLF = new MoveTokenType("CRLF");
  IElementType KEY = new MoveTokenType("KEY");
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
