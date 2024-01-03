package bredo.cmd.mc.resourcemanager.serialization.interfaces;

import bredo.cmd.mc.resourcemanager.data.utilities.Data;
import bredo.cmd.mc.unilink.utilities.Registry;

import java.io.File;

public interface ISerialization {

    void save(final File file, final Registry<Data> dataRegistry);

    void load(final Registry<Data> dataRegistry, final File file);
}
