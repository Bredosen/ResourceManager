package bredo.cmd.mc.resourcemanager.interfaces;

import bredo.cmd.mc.resourcemanager.data.utilities.Data;
import bredo.cmd.mc.unilink.utilities.Registry;

public interface IDefaultsSetter {

    void set(final Registry<Data> dataRegistry);
}
