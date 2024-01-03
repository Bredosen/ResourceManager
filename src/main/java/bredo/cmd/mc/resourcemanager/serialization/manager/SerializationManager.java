package bredo.cmd.mc.resourcemanager.serialization.manager;

import bredo.cmd.mc.resourcemanager.serialization.utilities.Serialization;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class SerializationManager {

    //<editor-fold desc="Singleton & Constructor">
    private final static SerializationManager SINGLETON;

    static {
        SINGLETON = new SerializationManager();
    }

    private SerializationManager() {
        serializationRegistry = new Registry<>("Serialization");
    }

    public static SerializationManager serializationManager() {
        return SINGLETON;
    }
    //</editor-fold>

    //<editor-fold desc="Resource Registry">
    private final Registry<Serialization> serializationRegistry;

    public static Registry<Serialization> serializationRegistry() {
        return serializationManager().serializationRegistry;
    }
    //</editor-fold>
}
