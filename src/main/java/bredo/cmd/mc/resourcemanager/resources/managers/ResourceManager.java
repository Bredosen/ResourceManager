package bredo.cmd.mc.resourcemanager.resources.managers;

import bredo.cmd.mc.resourcemanager.resources.utilities.Resource;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class ResourceManager {

    //<editor-fold desc="Singleton & Constructor">
    private final static ResourceManager SINGLETON;

    static {
        SINGLETON = new ResourceManager();
    }

    private ResourceManager() {
        resourceRegistry = new Registry<>("Resource");
    }

    public static ResourceManager resourceManager() {
        return SINGLETON;
    }
    //</editor-fold>

    //<editor-fold desc="Resource Registry">
    private final Registry<Resource> resourceRegistry;

    public static Registry<Resource> resourceRegistry() {
        return resourceManager().resourceRegistry;
    }
    //</editor-fold>
}
