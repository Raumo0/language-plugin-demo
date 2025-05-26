package com.github.raumo0.languageplugindemo.impl;

import com.github.raumo0.languageplugindemo.MoveElementFactory;
import com.github.raumo0.languageplugindemo.MoveProperty;
import com.github.raumo0.languageplugindemo.MoveTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

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

    public static String getName(MoveProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(MoveProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(MoveTypes.KEY);
        if (keyNode != null) {
            MoveProperty property = MoveElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(MoveProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(MoveTypes.KEY);
        return keyNode != null ? keyNode.getPsi() : null;
    }
}
