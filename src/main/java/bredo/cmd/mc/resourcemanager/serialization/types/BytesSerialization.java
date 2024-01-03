package bredo.cmd.mc.resourcemanager.serialization.types;

import bredo.cmd.mc.resourcemanager.data.utilities.Data;
import bredo.cmd.mc.resourcemanager.serialization.interfaces.ISerialization;
import bredo.cmd.mc.unilink.utilities.Registry;

import java.io.File;

public final class BytesSerialization implements ISerialization {

    //<editor-fold desc="Singleton & Constructor">
    private final static BytesSerialization SINGLETON;

    static {
        SINGLETON = new BytesSerialization();
    }

    private BytesSerialization() {
    }

    public static BytesSerialization getInstance() {
        return SINGLETON;
    }
    //</editor-fold>

    @Override
    public void save(final File file, final Registry<Data> dataRegistry) {

    }

    @Override
    public void load(final Registry<Data> dataRegistry, final File file) {

    }
}
