package com.github.raumo0.languageplugindemo.annotator;

import com.github.raumo0.languageplugindemo.psi.MoveProperty;
import com.github.raumo0.languageplugindemo.style.highlight.MoveSyntaxHighlighter;
import com.github.raumo0.languageplugindemo.utils.MoveUtil;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MoveAnnotator implements Annotator {

    // Define strings for the Move language prefix - used for annotations, line markers, etc.
    public static final String MOVE_PREFIX_STR = "move";
    public static final String MOVE_SEPARATOR_STR = ":";

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        // Ensure the PSI Element is an expression
        if (!(element instanceof PsiLiteralExpression literalExpression)) {
            return;
        }

        // Ensure the PSI element contains a string that starts with the prefix and separator
        String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
        if (value == null || !value.startsWith(MOVE_PREFIX_STR + MOVE_SEPARATOR_STR)) {
            return;
        }

        // Define the text ranges (start is inclusive, end is exclusive)
        // "move:key"
        //  01234567890
        TextRange prefixRange = TextRange.from(element.getTextRange().getStartOffset(), MOVE_PREFIX_STR.length() + 1);
        TextRange separatorRange = TextRange.from(prefixRange.getEndOffset(), MOVE_SEPARATOR_STR.length());
        TextRange keyRange = new TextRange(separatorRange.getEndOffset(), element.getTextRange().getEndOffset() - 1);

        // highlight "move" prefix and ":" separator
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create();
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(separatorRange).textAttributes(MoveSyntaxHighlighter.SEPARATOR).create();


        // Get the list of properties for given key
        String key = value.substring(MOVE_PREFIX_STR.length() + MOVE_SEPARATOR_STR.length());
        List<MoveProperty> properties = MoveUtil.findProperties(element.getProject(), key);
        if (properties.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
                    .range(keyRange)
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                    // ** Tutorial step 19. - Add a quick fix for the string containing possible properties
//                    .withFix(new MoveCreatePropertyQuickFix(key))
                    .create();
        } else {
            // Found at least one property, force the text attributes to Move syntax value character
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(keyRange).textAttributes(MoveSyntaxHighlighter.VALUE).create();
        }
    }

}
