package bredo.cmd.mc.resourcemanager.serialization.types;

import bredo.cmd.mc.resourcemanager.data.utilities.Data;
import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;
import bredo.cmd.mc.resourcemanager.serialization.interfaces.ISerialization;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class JsonSerialization implements ISerialization {

    //<editor-fold desc="Singleton & Constructor">
    private final static JsonSerialization SINGLETON;

    static {
        SINGLETON = new JsonSerialization();
    }

    private JsonSerialization() {
    }

    public static JsonSerialization getInstance() {
        return SINGLETON;
    }
    //</editor-fold>

    @Override
    public void save(final FileContext fileContext, final Registry<Data> dataRegistry) {

    }

    @Override
    public void load(final Registry<Data> dataRegistry, final FileContext fileContext) {

    }
}
