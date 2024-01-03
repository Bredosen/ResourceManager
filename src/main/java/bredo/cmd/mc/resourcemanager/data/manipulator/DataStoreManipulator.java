package bredo.cmd.mc.resourcemanager.data.manipulator;

import bredo.cmd.mc.resourcemanager.data.manager.DataStoreManager;
import bredo.cmd.mc.resourcemanager.data.utilities.Data;
import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;
import bredo.cmd.mc.resourcemanager.data.validator.DataStoreValidator;
import bredo.cmd.mc.unilink.utilities.Registry;
import bredo.cmd.mc.unilink.validators.Validator;

public final class DataStoreManipulator {

    //<editor-fold desc="Constructor">
    private DataStoreManipulator() {
    }
    //</editor-fold>

    //<editor-fold desc="Current DataStore">
    private static String currentDataStore;

    public static void selectDataStore(final String dataStore) {
        Validator.validateString(dataStore, "DataStore name", true);
        currentDataStore = dataStore;
    }

    public static void deselectDataStore() {
        currentDataStore = null;
    }

    public static String currentDataStore() {
        return currentDataStore;
    }

    private static void validateCurrentDataStore() {
        DataStoreValidator.validateDataStoreName(currentDataStore());
    }
    //</editor-fold>

    //<editor-fold desc="Get DataRegistry">
    public static Registry<Data> getDataRegistry(final String dataStoreName) {
        DataStoreValidator.validateDataStoreName(dataStoreName);
        final DataStore dataStore = DataStoreManager.dataStoreRegistry().retrieveElement(dataStoreName);
        return dataStore.getDataRegistry();
    }

    public static Registry<Data> getDataRegistry() {
        validateCurrentDataStore();
        return getDataRegistry(currentDataStore());
    }
    //</editor-fold>
}
