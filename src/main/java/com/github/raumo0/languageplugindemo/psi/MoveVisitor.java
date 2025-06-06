// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class MoveVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull MoveProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull MoveNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
