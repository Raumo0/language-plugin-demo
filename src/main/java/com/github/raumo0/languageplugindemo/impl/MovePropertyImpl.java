// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.raumo0.languageplugindemo.MoveTypes.*;
import com.github.raumo0.languageplugindemo.*;
import com.intellij.navigation.ItemPresentation;

public class MovePropertyImpl extends MoveNamedElementImpl implements MoveProperty {

  public MovePropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MoveVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MoveVisitor) accept((MoveVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return MovePsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return MovePsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return MovePsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return MovePsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return MovePsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return MovePsiImplUtil.getPresentation(this);
  }

}
