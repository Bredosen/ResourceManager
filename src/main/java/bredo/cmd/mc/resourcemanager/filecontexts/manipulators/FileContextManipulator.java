package bredo.cmd.mc.resourcemanager.resources.manipulators;

import bredo.cmd.mc.resourcemanager.data.validator.DataValidator;
import bredo.cmd.mc.resourcemanager.filecontexts.validator.FileContextValidator;
import bredo.cmd.mc.resourcemanager.resources.managers.ResourceManager;
import bredo.cmd.mc.resourcemanager.resources.utilities.Resource;
import bredo.cmd.mc.resourcemanager.resources.validator.ResourceValidator;
import bredo.cmd.mc.resourcemanager.serialization.validator.SerializationValidator;
import bredo.cmd.mc.unilink.validators.Validator;

public final class ResourceManipulator {

    //<editor-fold desc="Constructor">
    private ResourceManipulator() {
    }
    //</editor-fold>

    //<editor-fold desc="Current Resource">
    private static String currentResource;

    public static void selectResource(final String resource) {
        Validator.validateString(resource, "Resource name", true);
        currentResource = resource;
    }

    public static void deselectResource() {
        currentResource = null;
    }

    public static String currentResource() {
        return currentResource;
    }

    private static void validateCurrentResource() {
        ResourceValidator.validateResourceName(currentResource());
    }
    //</editor-fold>

    //<editor-fold desc="FileContextCallKey">

    /**
     * Set the FileContextCallKey from the resource name.
     *
     * @param resourceName
     * @param fileContextCallKey
     */
    public static void setFileContextCallKey(final String resourceName, final String fileContextCallKey) {
        ResourceValidator.validateResourceName(resourceName);
        FileContextValidator.validateFileContextName(fileContextCallKey);

        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        resource.setFileContextCallKey(fileContextCallKey);
    }

    /**
     * Set the FileContextCallKey from the current selected resource name.
     *
     * @param fileContextCallKey
     */
    public static void setFileContextCallKey(final String fileContextCallKey) {
        validateCurrentResource();
        setFileContextCallKey(currentResource(), fileContextCallKey);
    }

    /**
     * Return the FileContextCallKey from the resource name.
     *
     * @param resourceName
     *
     * @return
     */
    public static String getFileContextCallKey(final String resourceName) {
        ResourceValidator.validateResourceName(resourceName);
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        return resource.getFileContextCallKey();
    }

    /**
     * Return the FileContextCall Key from the current selected resource name.
     *
     * @return
     */
    public static String getFileContextCallKey() {
        validateCurrentResource();
        return getFileContextCallKey(currentResource());
    }
    //</editor-fold>

    //<editor-fold desc="SerializationCallKey">

    /**
     * Set the SerializationCallKey from the resource name.
     *
     * @param resourceName
     * @param serializationCallKey
     */
    public static void setSerializationCallKey(final String resourceName, final String serializationCallKey) {
        ResourceValidator.validateResourceName(resourceName);
        SerializationValidator.validateSerializationName(serializationCallKey);

        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        resource.setSerializationCallKey(serializationCallKey);
    }

    /**
     * Set the SerializationCallKey from the current selected resource name.
     *
     * @param serializationCallKey
     */
    public static void setSerializationCallKey(final String serializationCallKey) {
        validateCurrentResource();
        setSerializationCallKey(currentResource(), serializationCallKey);
    }

    /**
     * Return the SerializationCallKey from the resource name.
     *
     * @param resourceName
     *
     * @return
     */
    public static String getSerializationCallKey(final String resourceName) {
        ResourceValidator.validateResourceName(resourceName);
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        return resource.getSerializationCallKey();
    }

    /**
     * Return the SerializationCall Key from the current selected resource name.
     *
     * @return
     */
    public static String getSerializationCallKey() {
        validateCurrentResource();
        return getSerializationCallKey(currentResource());
    }
    //</editor-fold>

    //<editor-fold desc="DataCallKey">

    /**
     * Set the DataCallKey from the resource name.
     *
     * @param resourceName
     * @param dataCallKey
     */
    public static void setDataCallKey(final String resourceName, final String dataCallKey) {
        ResourceValidator.validateResourceName(resourceName);
        DataValidator.validateDataName(dataCallKey);

        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        resource.setDataCallKey(dataCallKey);
    }

    /**
     * Set the DataCallKey from the current selected resource name.
     *
     * @param dataCallKey
     */
    public static void setDataCallKey(final String dataCallKey) {
        validateCurrentResource();
        setDataCallKey(currentResource(), dataCallKey);
    }

    /**
     * Return the DataCallKey from the resource name.
     *
     * @param resourceName
     *
     * @return
     */
    public static String getDataCallKey(final String resourceName) {
        ResourceValidator.validateResourceName(resourceName);
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        return resource.getDataCallKey();
    }

    /**
     * Return the DataCall Key from the current selected resource name.
     *
     * @return
     */
    public static String getDataCallKey() {
        validateCurrentResource();
        return getDataCallKey(currentResource());
    }
    //</editor-fold>
}
