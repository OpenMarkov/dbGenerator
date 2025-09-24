package org.openmarkov.dbgenerator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openmarkov.core.localize.StringDatabase;
import org.openmarkov.dbgenerator.gui.DBGeneratorGUI;
import org.openmarkov.gui.toolplugin.ToolPlugin;

import javax.swing.*;

public final class DBGeneratorPlugin implements ToolPlugin {
    
    @Override public @NotNull String menuOptionText() {
        return StringDatabase.getUniqueInstance().getString("Menus", "Tools.DBGenerator.Label");
    }
    
    @Override public @Nullable Character mnemonic() {
        var mnemonic = StringDatabase.getUniqueInstance().getString("Menus", "Tools.DBGenerator.Mnemonic");
        if (mnemonic == null || mnemonic.isEmpty()) return null;
        return mnemonic.charAt(0);
    }
    
    @Override public @NotNull ToolPluginGroup pluginGroup() {
        return ToolPluginGroup.EXPORT;
    }
    
    @Override public int priorityInGroup() {
        return 0;
    }
    
    @Override public void showDialog(@Nullable JFrame parent) {
        new DBGeneratorGUI(parent).setVisible(true);
    }
    
    
}