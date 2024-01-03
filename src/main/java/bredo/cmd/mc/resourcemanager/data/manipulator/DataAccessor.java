package bredo.cmd.mc.resourcemanager.data.manipulator;

import bredo.cmd.mc.resourcemanager.data.manager.DataStoreManager;
import bredo.cmd.mc.resourcemanager.data.utilities.Data;
import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;
import bredo.cmd.mc.unilink.validators.Validator;

public final class DataAccessor {

    public static Data get(final String dataStoreName, final String name) {
        Validator.validateString(dataStoreName, "DataStore name", true);
        Validator.validateObject(name, "DataStore path");

        final DataStore dataStore = DataStoreManager.dataStoreRegistry().retrieveElement(dataStoreName);
        dataStore.validateLoaded();

        return dataStore.getDataRegistry().retrieveElement(name);
    }

    public static void set(final String dataStoreName, final String name, final Object value) {
        Validator.validateString(dataStoreName, "DataStore name", true);
        Validator.validateObject(name, "DataStore path");
        Validator.validateObject(value, "Data value");

        final DataStore dataStore = DataStoreManager.dataStoreRegistry().retrieveElement(dataStoreName);
        dataStore.validateLoaded();

        final Data data = dataStore.getDataRegistry().retrieveElement(name);
        data.setValue(value);
    }

    public static Object getObject(final String dataStoreName, final String name) {
        final Data data = get(dataStoreName, name);
        return data.getValue();
    }

    public static String getString(final String dataStoreName, final String name) {
        return (String) getObject(dataStoreName, name);
    }

    public static int getInt(final String dataStoreName, final String name) {
        return (int) getObject(dataStoreName, name);
    }

    public static double getDouble(final String dataStoreName, final String name) {
        return (double) getObject(dataStoreName, name);
    }

}
