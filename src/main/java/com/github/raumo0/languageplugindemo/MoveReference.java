package com.github.raumo0.languageplugindemo;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

final class MoveReference extends PsiPolyVariantReferenceBase<PsiElement> {

    private final String key;

    MoveReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText()
                .substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        List<MoveProperty> properties = MoveUtil.findProperties(project, key);
        List<ResolveResult> results = new ArrayList<>();
        for (MoveProperty property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<MoveProperty> properties = MoveUtil.findProperties(project);
        List<LookupElement> variants = new ArrayList<>();
        for (MoveProperty property : properties) {
            if (property.getKey() != null && !property.getKey().isEmpty()) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(MoveIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }

}
