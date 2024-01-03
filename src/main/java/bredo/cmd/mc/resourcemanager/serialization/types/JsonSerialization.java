package bredo.cmd.mc.resourcemanager.serialization.types;

import bredo.cmd.mc.resourcemanager.data.utilities.Data;
import bredo.cmd.mc.resourcemanager.data.utilities.JsonData;
import bredo.cmd.mc.resourcemanager.serialization.interfaces.ISerialization;
import bredo.cmd.mc.unilink.utilities.Registry;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

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
    public void save(final File file, final Registry<Data> dataRegistry) {
        final YamlConfiguration yamlConfiguration = new YamlConfiguration();
        for (final Data data : dataRegistry.getRegistry()) {
            if (data instanceof JsonData jsonData) {
                yamlConfiguration.set(jsonData.getPath(), jsonData.getValue());
                yamlConfiguration.setComments(jsonData.getPath(), jsonData.getComments());
            } else yamlConfiguration.set(data.getName(), data.getValue());
        }

        try {
            yamlConfiguration.save(file);
        } catch (final IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void load(final Registry<Data> dataRegistry, final File file) {
        final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        for (final Data data : dataRegistry.getRegistry())
            if (yamlConfiguration.contains(data.getName())) data.setValue(yamlConfiguration.get(data.getName()));
    }
}
