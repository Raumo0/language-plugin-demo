// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi;

import com.github.raumo0.languageplugindemo.psi.ext.MvItemElement;
import com.github.raumo0.languageplugindemo.psi.ext.MvPatternMixin;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class MoveVisitor extends PsiElementVisitor {

  public void visitConst(@NotNull MoveConst o) {
    visitMvItemElement(o);
    // visitMvTypeAscriptionOwner(o);
  }

  public void visitExpr(@NotNull MoveExpr o) {
    visitPsiElement(o);
  }

  public void visitInitializer(@NotNull MoveInitializer o) {
    visitPsiElement(o);
  }

  public void visitLiteralExpr(@NotNull MoveLiteralExpr o) {
    visitExpr(o);
  }

  public void visitPathExpr(@NotNull MovePathExpr o) {
    visitExpr(o);
  }

  public void visitPattern(@NotNull MovePattern o) {
    visitPsiElement(o);
  }

  public void visitTupleExpr(@NotNull MoveTupleExpr o) {
    visitExpr(o);
  }

  public void visitTuplePattern(@NotNull MoveTuplePattern o) {
    visitPsiElement(o);
  }

  public void visitTupleType(@NotNull MoveTupleType o) {
    visitPsiElement(o);
  }

  public void visitType(@NotNull MoveType o) {
    visitPsiElement(o);
  }

  public void visitTypeAscription(@NotNull MoveTypeAscription o) {
    visitPsiElement(o);
  }

  public void visitMvItemElement(@NotNull MvItemElement o) {
    visitElement(o);
  }

  public void visitMvPatternMixin(@NotNull MvPatternMixin o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
