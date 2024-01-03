package bredo.cmd.mc.resourcemanager.data.utilities;

import bredo.cmd.mc.resourcemanager.data.validator.DataStoreValidator;
import bredo.cmd.mc.unilink.handlers.ExceptionHandler;
import bredo.cmd.mc.unilink.utilities.Registry;
import bredo.cmd.mc.unilink.utilities.RegistryElement;

public final class DataStore extends RegistryElement {

    private final Registry<Data> dataRegistry;

    private DataStore(final String name) {
        super(name);
        this.dataRegistry = new Registry<>("Data");
    }

    public static DataStore createInstance(final String name) {
        DataStoreValidator.validateDataStoreName(name);
        final DataStore dataStore = new DataStore(name);
        return dataStore;
    }

    public void validateLoaded() {
        if (!loaded()) ExceptionHandler.throwCrashException(new IllegalStateException("DataStore: '" + getName() + "' is not loaded!"));
    }

    public boolean loaded() {
        return !getDataRegistry().isEmpty();
    }

    public Registry<Data> getDataRegistry() {
        return dataRegistry;
    }
}
