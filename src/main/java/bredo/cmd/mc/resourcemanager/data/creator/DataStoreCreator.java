package bredo.cmd.mc.resourcemanager.data.creator;

import bredo.cmd.mc.resourcemanager.data.manager.DataManager;
import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;

public final class DataCreator {

    public static void create(final String name) {
        final DataStore dataStore = DataStore.createInstance(name);
        DataManager.dataRegistry().registerElement(dataStore);
    }
}
