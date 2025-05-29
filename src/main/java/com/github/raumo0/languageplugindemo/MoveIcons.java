package com.github.raumo0.languageplugindemo;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public class MoveIcons {
    public static final Icon FILE = IconLoader.getIcon("/icons/move.png", MoveIcons.class);

    /** Icon for constant values */
    public static final Icon CONSTANT = AllIcons.Nodes.Constant;

    /** Icon for mutable variables */
    public static final Icon MUT_VARIABLE = AllIcons.Nodes.Variable;

    /** Icon for immutable variables */
    public static final Icon VARIABLE = AllIcons.Nodes.Variable;

}
