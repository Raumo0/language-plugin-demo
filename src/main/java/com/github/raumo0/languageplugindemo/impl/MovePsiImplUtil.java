package com.github.raumo0.languageplugindemo.impl;

import com.github.raumo0.languageplugindemo.MoveProperty;
import com.github.raumo0.languageplugindemo.MoveTypes;
import com.intellij.lang.ASTNode;

public class MovePsiImplUtil {
    public static String getKey(MoveProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(MoveTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(MoveProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(MoveTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }
}
