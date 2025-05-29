// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.raumo0.languageplugindemo.psi.MoveTypes.*;
import com.github.raumo0.languageplugindemo.psi.ext.MvConstBindingMixin;
import com.github.raumo0.languageplugindemo.psi.*;

public class MoveConstImpl extends MvConstBindingMixin implements MoveConst {

  public MoveConstImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MoveVisitor visitor) {
    visitor.visitConst(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MoveVisitor) accept((MoveVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MoveInitializer getInitializer() {
    return findChildByClass(MoveInitializer.class);
  }

  @Override
  @Nullable
  public MoveTypeAscription getTypeAscription() {
    return findChildByClass(MoveTypeAscription.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
