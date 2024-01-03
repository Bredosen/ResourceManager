package bredo.cmd.mc.resourcemanager.utilities;

import bredo.cmd.mc.resourcemanager.utilities.components.FileManager;
import bredo.cmd.mc.unilink.utilities.RegistryElement;

public final class Resource extends RegistryElement {

    private final FileManager fileManager;

    public Resource(final String name) {
        super(name);
        this.fileManager = new FileManager(this);
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
