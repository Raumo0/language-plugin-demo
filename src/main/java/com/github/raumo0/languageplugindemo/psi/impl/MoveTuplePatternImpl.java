// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.raumo0.languageplugindemo.psi.MoveTypes.*;
import com.github.raumo0.languageplugindemo.psi.ext.MvTuplePatternMixin;
import com.github.raumo0.languageplugindemo.psi.*;

public class MoveTuplePatternImpl extends MvTuplePatternMixin implements MoveTuplePattern {

  public MoveTuplePatternImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MoveVisitor visitor) {
    visitor.visitTuplePattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MoveVisitor) accept((MoveVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MovePattern> getPatternList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MovePattern.class);
  }

}
