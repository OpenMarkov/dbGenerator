package org.openmarkov.dbgenerator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openmarkov.dbgenerator.gui.DBGeneratorGUI;
import org.openmarkov.gui.localize.Nls;
import org.openmarkov.gui.toolplugin.ToolPlugin;

import javax.swing.*;

public final class DBGeneratorPlugin implements ToolPlugin {
    
    @Override public @NotNull String menuOptionText() {
        return Nls.Menus.Tools.DBGenerator.Label.stringify();
    }
    
    @Override public @Nullable Character mnemonic() {
        var mnemonic = Nls.Menus.Tools.DBGenerator.Mnemonic.stringify();
        if (mnemonic == null || mnemonic.isEmpty()) return null;
        return mnemonic.charAt(0);
    }
    
    @Override public void showDialog(@Nullable JFrame parent) {
        new DBGeneratorGUI(parent).setVisible(true);
    }
    
    
}