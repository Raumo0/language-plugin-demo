package com.github.raumo0.languageplugindemo.formatter;

import com.github.raumo0.languageplugindemo.MoveLanguage;
import com.github.raumo0.languageplugindemo.language.MoveTypes;
import com.github.raumo0.languageplugindemo.psi.MoveBlock;
import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public class MoveFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, MoveLanguage.INSTANCE)
                .around(MoveTypes.SEPARATOR)
                .spaceIf(settings.getCommonSettings(MoveLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .before(MoveTypes.PROPERTY)
                .none();
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new MoveBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(codeStyleSettings)),
                        codeStyleSettings);
    }

}
