package bredo.cmd.mc.resourcemanager.managers;

import bredo.cmd.mc.resourcemanager.creators.ResourceCreator;
import bredo.cmd.mc.resourcemanager.manipulators.ResourceManipulator;
import bredo.cmd.mc.resourcemanager.utilities.Resource;
import bredo.cmd.mc.unilink.handlers.ExceptionHandler;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class ResourceManager {

    //<editor-fold desc="Singleton & Constructor">
    private final static ResourceManager SINGLETON;

    static {
        SINGLETON = new ResourceManager();
    }

    private ResourceManager() {
        resourceRegistry = new Registry<>("Resource");
        resourceCreator = ResourceCreator.createInstance();
        resourceManipulator = ResourceManipulator.createInstance();
        resourceManager().allowInitialization = true;
    }

    public static ResourceManager resourceManager() {
        return SINGLETON;
    }
    //</editor-fold>

    //<editor-fold desc="Initialization">
    private boolean allowInitialization = false;
    private boolean initialized = false;

    public static void initializeResourceManager() {
        if (!resourceManager().allowInitialization) ExceptionHandler.throwCrashException(new IllegalStateException("Could not initialize ResourceManager!"));

        resourceManager().initialized = true;
    }

    public static boolean isResourceManagerInitialized() {
        return resourceManager().initialized;
    }
    //</editor-fold>

    //<editor-fold desc="Resource Registry">
    private final Registry<Resource> resourceRegistry;

    public static Registry<Resource> resourceRegistry() {
        return resourceManager().resourceRegistry;
    }
    //</editor-fold>

    //<editor-fold desc="Resource Creator">
    private final ResourceCreator resourceCreator;

    public static ResourceCreator resourceCreator() {
        return resourceCreator();
    }
    //</editor-fold>

    //<editor-fold desc="Resource Manipulator">
    private final ResourceManipulator resourceManipulator;

    public static ResourceManipulator resourceManipulator() {
        return resourceManipulator();
    }
    //</editor-fold>

}
