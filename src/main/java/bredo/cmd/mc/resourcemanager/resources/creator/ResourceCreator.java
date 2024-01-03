package bredo.cmd.mc.resourcemanager.creators;

import bredo.cmd.mc.resourcemanager.managers.ResourceManager;
import bredo.cmd.mc.resourcemanager.utilities.Resource;

public final class ResourceCreator {

    private ResourceCreator() {
    }

    public static ResourceCreator createInstance() {
        return new ResourceCreator();
    }

    public void create(final String name) {
        final Resource resource = new Resource(name);
        ResourceManager.resourceRegistry().registerElement(resource);
    }
}
