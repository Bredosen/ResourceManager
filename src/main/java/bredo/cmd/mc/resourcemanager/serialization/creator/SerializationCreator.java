package bredo.cmd.mc.resourcemanager.filecontexts.creator;

import bredo.cmd.mc.resourcemanager.filecontexts.manager.FileManager;
import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;

public final class FileContextCreator {

    public static void create(final String name) {
        final FileContext fileContext = FileContext.createInstance(name);

        FileManager.fileContextRegistry().registerElement(fileContext);
    }
}
