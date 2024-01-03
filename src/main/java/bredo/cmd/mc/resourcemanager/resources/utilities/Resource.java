package bredo.cmd.mc.resourcemanager.resources.utilities;

import bredo.cmd.mc.resourcemanager.interfaces.IDefaultsSetter;
import bredo.cmd.mc.resourcemanager.resources.validator.ResourceValidator;
import bredo.cmd.mc.unilink.utilities.RegistryElement;

public final class Resource extends RegistryElement {

    private String fileContextCallKey; // The file itself.
    private String serializationCallKey; // How the file is saved and loaded.
    private String dataCallKey; // The data to save and load to and from the file.
    private IDefaultsSetter iDefaultsSetter; // The default data to be loaded into the dataRegistry.

    private Resource(final String name) {
        super(name);
    }

    public static Resource createInstance(final String name) {
        ResourceValidator.validateResourceName(name);
        final Resource resource = new Resource(name);
        return resource;
    }

    public String getFileContextCallKey() {
        return fileContextCallKey;
    }

    public void setFileContextCallKey(final String fileContextCallKey) {
        this.fileContextCallKey = fileContextCallKey;
    }

    public String getSerializationCallKey() {
        return serializationCallKey;
    }

    public void setSerializationCallKey(final String serializationCallKey) {
        this.serializationCallKey = serializationCallKey;
    }

    public String getDataCallKey() {
        return dataCallKey;
    }

    public void setDataCallKey(final String dataCallKey) {
        this.dataCallKey = dataCallKey;
    }

    public IDefaultsSetter getiDefaultsSetter() {
        return iDefaultsSetter;
    }

    public void setIDefaultsSetter(final IDefaultsSetter iDefaultsSetter) {
        this.iDefaultsSetter = iDefaultsSetter;
    }
}
