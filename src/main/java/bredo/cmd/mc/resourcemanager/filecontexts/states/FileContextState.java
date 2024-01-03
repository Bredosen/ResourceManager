package bredo.cmd.mc.resourcemanager.filecontexts.states;

import bredo.cmd.mc.resourcemanager.filecontexts.manager.FileContextManager;
import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;
import bredo.cmd.mc.resourcemanager.filecontexts.validator.FileContextValidator;
import org.bukkit.plugin.java.JavaPlugin;

public final class FileContextState {

    public static void initialize(final String fileContextName, final JavaPlugin javaPlugin) {
        FileContextValidator.validateFileContextName(fileContextName);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        fileContext.initializeFile(javaPlugin);
    }
}
