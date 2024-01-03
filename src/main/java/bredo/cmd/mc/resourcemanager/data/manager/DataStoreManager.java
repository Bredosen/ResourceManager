package bredo.cmd.mc.resourcemanager.data.manager;

import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class DataManager {

    //<editor-fold desc="Singleton & Constructor">
    private final static DataManager SINGLETON;

    static {
        SINGLETON = new DataManager();
    }

    private DataManager() {
        dataRegistry = new Registry<>("DataStore");
    }

    public static DataManager dataManager() {
        return SINGLETON;
    }
    //</editor-fold>

    public void initialize() {
        //TODO: Something
    }

    //<editor-fold desc="Resource Registry">
    private final Registry<DataStore> dataRegistry;

    public static Registry<DataStore> dataRegistry() {
        return dataManager().dataRegistry;
    }
    //</editor-fold>
}
