package bredo.cmd.mc.resourcemanager.data.manager;

import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class DataStoreManager {

    //<editor-fold desc="Singleton & Constructor">
    private final static DataStoreManager SINGLETON;

    static {
        SINGLETON = new DataStoreManager();
    }

    private DataStoreManager() {
        dataStoreRegistry = new Registry<>("DataStore");
    }

    public static DataStoreManager dataStoreManager() {
        return SINGLETON;
    }
    //</editor-fold>

    //<editor-fold desc="Resource Registry">
    private final Registry<DataStore> dataStoreRegistry;

    public static Registry<DataStore> dataStoreRegistry() {
        return dataStoreManager().dataStoreRegistry;
    }
    //</editor-fold>
}
