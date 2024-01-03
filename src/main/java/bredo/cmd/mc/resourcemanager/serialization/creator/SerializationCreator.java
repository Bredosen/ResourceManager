package bredo.cmd.mc.resourcemanager.serialization.creator;

import bredo.cmd.mc.resourcemanager.serialization.manager.SerializationManager;
import bredo.cmd.mc.resourcemanager.serialization.types.JsonSerialization;
import bredo.cmd.mc.resourcemanager.serialization.utilities.Serialization;

public final class SerializationCreator {

    public static void create(final String name) {
        // Create serialization instance.
        final Serialization serialization = Serialization.createInstance(name);

        // Set serialization to Json serialization.
        serialization.setISerialization(JsonSerialization.getInstance());

        // Register serialization.
        SerializationManager.serializationRegistry().registerElement(serialization);
    }
}
