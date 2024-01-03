package bredo.cmd.mc.resourcemanager.resources.states;

import bredo.cmd.mc.resourcemanager.data.manager.DataStoreManager;
import bredo.cmd.mc.resourcemanager.data.utilities.DataStore;
import bredo.cmd.mc.resourcemanager.filecontexts.manager.FileContextManager;
import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;
import bredo.cmd.mc.resourcemanager.interfaces.IDefaultsSetter;
import bredo.cmd.mc.resourcemanager.resources.managers.ResourceManager;
import bredo.cmd.mc.resourcemanager.resources.utilities.Resource;
import bredo.cmd.mc.resourcemanager.resources.validator.ResourceValidator;
import bredo.cmd.mc.resourcemanager.serialization.interfaces.ISerialization;
import bredo.cmd.mc.resourcemanager.serialization.manager.SerializationManager;
import bredo.cmd.mc.resourcemanager.serialization.utilities.Serialization;
import bredo.cmd.mc.unilink.handlers.ExceptionHandler;
import bredo.cmd.mc.unilink.validators.Validator;

import java.io.File;

public final class ResourceState {

    public static void save(final String resourceName) {
        ResourceValidator.validateResourceName(resourceName);
        final Object[] components = getFullResourceComponents(resourceName);
        final Serialization serialization = (Serialization) components[0];
        final FileContext fileContext = (FileContext) components[1];
        final DataStore dataStore = (DataStore) components[2];

        dataStore.validateLoaded();

        if (!fileContext.initialized())
            ExceptionHandler.throwCrashException(new IllegalStateException("Cannot save " + resourceName + "Resource, the FileContext has not been initialized yet!"));

        final File file = fileContext.getFile();

        final ISerialization iSerialization = serialization.getiSerialization();
        Validator.validateObject(iSerialization, "ISerialization");

        iSerialization.save(file, dataStore.getDataRegistry());
    }

    public static void load(final String resourceName, final boolean loadDefaults) {
        ResourceValidator.validateResourceName(resourceName);
        final Object[] components = getFullResourceComponents(resourceName);
        final Serialization serialization = (Serialization) components[0];
        final FileContext fileContext = (FileContext) components[1];
        final DataStore dataStore = (DataStore) components[2];

        if (!fileContext.initialized())
            ExceptionHandler.throwCrashException(new IllegalStateException("Cannot load " + resourceName + "Resource, the FileContext has not been initialized yet!"));

        final File file = fileContext.getFile();

        final ISerialization iSerialization = serialization.getiSerialization();
        Validator.validateObject(iSerialization, "ISerialization");

        if (loadDefaults) loadDefaults(resourceName);

        iSerialization.load(dataStore.getDataRegistry(), file);
    }

    public static void load(final String resourceName) {
        load(resourceName, true);
    }

    public static void loadDefaults(final String resourceName) {
        ResourceValidator.validateResourceName(resourceName);
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        final DataStore dataStore = DataStoreManager.dataStoreRegistry().retrieveElement(resource.getDataCallKey());

        final IDefaultsSetter iDefaultsSetter = resource.getiDefaultsSetter();
        Validator.validateObject(iDefaultsSetter, "IDefaultsSetter");
        iDefaultsSetter.set(dataStore.getDataRegistry());
    }

    public static void unLoad(final String resourceName) {
        ResourceValidator.validateResourceName(resourceName);
        final Object[] components = getFullResourceComponents(resourceName);
        final DataStore dataStore = (DataStore) components[2];

        dataStore.getDataRegistry().clearRegistry();
    }

    private static Object[] getFullResourceComponents(final String resourceName) {
        ResourceValidator.validateResourceName(resourceName);

        final Object[] components = new Object[3];
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        components[0] = SerializationManager.serializationRegistry().retrieveElement(resource.getSerializationCallKey());
        components[1] = FileContextManager.fileContextRegistry().retrieveElement(resource.getFileContextCallKey());
        components[2] = DataStoreManager.dataStoreRegistry().retrieveElement(resource.getDataCallKey());

        return components;
    }
}
