package com.github.raumo0.languageplugindemo.style.code;

import com.github.raumo0.languageplugindemo.MoveLanguage;
import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NotNull;

final class MoveCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

    @Override
    public CustomCodeStyleSettings createCustomSettings(@NotNull CodeStyleSettings settings) {
        return new MoveCodeStyleSettings(settings);
    }

    @Override
    public String getConfigurableDisplayName() {
        return "Move";
    }

    @NotNull
    public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings,
                                                    @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {
            @Override
            protected @NotNull CodeStyleAbstractPanel createPanel(@NotNull CodeStyleSettings settings) {
                return new MoveCodeStyleMainPanel(getCurrentSettings(), settings);
            }
        };
    }

    private static class MoveCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

        public MoveCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
            super(MoveLanguage.INSTANCE, currentSettings, settings);
        }

    }

}
