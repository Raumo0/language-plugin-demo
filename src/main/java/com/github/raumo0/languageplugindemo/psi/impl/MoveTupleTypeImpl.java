// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.raumo0.languageplugindemo.psi.MoveTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.raumo0.languageplugindemo.psi.*;

public class MoveTupleTypeImpl extends ASTWrapperPsiElement implements MoveTupleType {

  public MoveTupleTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MoveVisitor visitor) {
    visitor.visitTupleType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MoveVisitor) accept((MoveVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MoveType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MoveType.class);
  }

}
