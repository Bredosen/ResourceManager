package bredo.cmd.mc.resourcemanager.resources.creator;

import bredo.cmd.mc.resourcemanager.data.creator.DataStoreCreator;
import bredo.cmd.mc.resourcemanager.filecontexts.creator.FileContextCreator;
import bredo.cmd.mc.resourcemanager.resources.managers.ResourceManager;
import bredo.cmd.mc.resourcemanager.resources.manipulators.ResourceManipulator;
import bredo.cmd.mc.resourcemanager.resources.utilities.Resource;
import bredo.cmd.mc.resourcemanager.serialization.creator.SerializationCreator;

public final class ResourceCreator {

    private ResourceCreator() {}

    public static void create(final String name, final boolean select) {
        // Create Resource instance
        final Resource resource = Resource.createInstance(name);

        // Create FileContext and set resource's call key.
        resource.setFileContextCallKey(resource.getName());
        FileContextCreator.create(resource.getFileContextCallKey());

        // Create Serialization and set resource's call key.
        resource.setSerializationCallKey(resource.getName());
        SerializationCreator.create(resource.getSerializationCallKey());

        // Create DataStore and set resource's call key.
        resource.setDataCallKey(resource.getName());
        DataStoreCreator.create(resource.getDataCallKey());

        // Register Resource and select if selected.
        ResourceManager.resourceRegistry().registerElement(resource);
        if (select) ResourceManipulator.selectResource(name);
    }

    public static void create(final String name) {
        create(name, false);
    }
}
