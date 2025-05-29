// This is a generated file. Not intended for manual editing.
package com.github.raumo0.languageplugindemo.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.raumo0.languageplugindemo.psi.ext.MvItemElement;
import com.github.raumo0.languageplugindemo.psi.ext.MvTypeAscriptionOwner;

public interface MoveConst extends MvItemElement, MvTypeAscriptionOwner {

  @Nullable
  MoveInitializer getInitializer();

  @Nullable
  MoveTypeAscription getTypeAscription();

  @Nullable
  PsiElement getIdentifier();

}
