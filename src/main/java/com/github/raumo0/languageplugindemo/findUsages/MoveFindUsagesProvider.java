package com.github.raumo0.languageplugindemo.findUsages;

import com.github.raumo0.languageplugindemo.language.MoveTokenSets;
import com.github.raumo0.languageplugindemo.annotator.MoveAnnotator;
import com.github.raumo0.languageplugindemo.lexer.MoveLexerAdapter;
import com.github.raumo0.languageplugindemo.psi.MoveProperty;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MoveFindUsagesProvider implements FindUsagesProvider {

    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new MoveLexerAdapter(),
                MoveTokenSets.IDENTIFIERS,
                MoveTokenSets.COMMENTS,
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof MoveProperty) {
            return "move property";
        }
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof MoveProperty) {
            return ((MoveProperty) element).getKey();
        }
        return "";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof MoveProperty) {
            return ((MoveProperty) element).getKey() +
                    MoveAnnotator.MOVE_SEPARATOR_STR +
                    ((MoveProperty) element).getValue();
        }
        return "";
    }

}
