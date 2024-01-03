package bredo.cmd.mc.resourcemanager.data.creator;

import bredo.cmd.mc.resourcemanager.data.manager.DataStoreManager;
import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;

public final class DataStoreCreator {

    public static void create(final String name) {
        final DataStore dataStore = DataStore.createInstance(name);
        DataStoreManager.dataStoreRegistry().registerElement(dataStore);
    }
}
