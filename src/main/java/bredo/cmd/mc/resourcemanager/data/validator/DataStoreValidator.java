package bredo.cmd.mc.resourcemanager.data.validator;

import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;
import bredo.cmd.mc.unilink.validators.Validator;

public final class DataStoreValidator {

    public static void validateDataStore(final DataStore dataStore) {
        Validator.validateObject(dataStore, "DataStore");
    }

    public static void validateDataStoreName(final String dataName) {
        Validator.validateString(dataName, true, "DataStore name");
    }
}
