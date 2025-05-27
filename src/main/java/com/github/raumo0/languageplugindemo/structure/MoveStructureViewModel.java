package com.github.raumo0.languageplugindemo.structure;

import com.github.raumo0.languageplugindemo.psi.MoveProperty;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MoveStructureViewModel extends StructureViewModelBase implements
        StructureViewModel.ElementInfoProvider {

    public MoveStructureViewModel(@Nullable Editor editor, PsiFile psiFile) {
        super(psiFile, editor, new MoveStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter @NotNull [] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }


    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element.getValue() instanceof MoveProperty;
    }

    @Override
    protected Class<?> @NotNull [] getSuitableClasses() {
        return new Class[]{MoveProperty.class};
    }

}