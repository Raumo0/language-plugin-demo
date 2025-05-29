// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.raumo0.languageplugindemo.psi.MoveTypes.*;
import com.github.raumo0.languageplugindemo.psi.*;

public class MoveTupleExprImpl extends MoveExprImpl implements MoveTupleExpr {

  public MoveTupleExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MoveVisitor visitor) {
    visitor.visitTupleExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MoveVisitor) accept((MoveVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MoveExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MoveExpr.class);
  }

}
