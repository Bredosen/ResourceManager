package bredo.cmd.mc.resourcemanager.manipulators;

import bredo.cmd.mc.resourcemanager.managers.ResourceManager;
import bredo.cmd.mc.resourcemanager.utilities.Resource;
import bredo.cmd.mc.unilink.handlers.ExceptionHandler;
import bredo.cmd.mc.unilink.validators.Validator;

public final class ResourceManipulator {

    //<editor-fold desc="Constructor">
    private ResourceManipulator() {
    }

    public static ResourceManipulator createInstance() {
        return new ResourceManipulator();
    }
    //</editor-fold>

    //<editor-fold desc="Current Resource">
    private String currentResource;

    public void selectResource(final String resource) {
        Validator.validateString(resource, "Resource name", true);
        this.currentResource = resource;
    }

    public void deselectResource() {
        currentResource = null;
    }

    public String currentResource() {
        return currentResource;
    }
    //</editor-fold>

    //<editor-fold desc="File Manager">
    //<editor-fold desc="FileName">
    public void setFileName(final String resourceName, final String fileName) {
        Validator.validateString(resourceName, "Resource name", true);
        Validator.validateString(fileName, "File name", true);

        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        resource.getFileManager().setFileName(fileName);
    }

    public void setFileName(final String fileName) {
        if (currentResource() == null) ExceptionHandler.throwLogException(new NullPointerException("There is no active resource!"));
        setFileName(currentResource(), fileName);
    }

    public String getFileName(final String resourceName) {
        Validator.validateString(resourceName, "Resource name", true);
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        return resource.getFileManager().getFileName();
    }

    public String getFileName() {
        if (currentResource() == null) ExceptionHandler.throwLogException(new NullPointerException("There is no active resource!"));
        return getFileName(currentResource());
    }

    //</editor-fold>
    //<editor-fold desc="FileDirectory">
    public void setFileDirectory(final String resourceName, final String fileDirectory) {
        Validator.validateString(resourceName, "Resource name", true);
        Validator.validateString(fileDirectory, "File directory", true);

        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        resource.getFileManager().setFileDirectory(fileDirectory);
    }

    public void setFileDirectory(final String fileDirectory) {
        if (currentResource() == null) ExceptionHandler.throwLogException(new NullPointerException("There is no active resource!"));
        setFileDirectory(currentResource(), fileDirectory);
    }

    public String getFileDirectory(final String resourceName) {
        Validator.validateString(resourceName, "Resource name", true);
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        return resource.getFileManager().getFileDirectory();
    }

    public String getFileDirectory() {
        if (currentResource() == null) ExceptionHandler.throwLogException(new NullPointerException("There is no active resource!"));
        return getFileDirectory(currentResource());
    }

    //</editor-fold>
    //<editor-fold desc="FileExtension">
    public void setFileExtension(final String resourceName, final String fileExtension) {
        Validator.validateString(resourceName, "Resource name", true);
        Validator.validateString(fileExtension, "File extension", true);

        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        resource.getFileManager().setFileExtension(fileExtension);
    }

    public void setFileExtension(final String fileExtension) {
        if (currentResource() == null) ExceptionHandler.throwLogException(new NullPointerException("There is no active resource!"));
        setFileExtension(currentResource(), fileExtension);
    }

    public String getFileExtension(final String resourceName) {
        Validator.validateString(resourceName, "Resource name", true);
        final Resource resource = ResourceManager.resourceRegistry().retrieveElement(resourceName);
        return resource.getFileManager().getFileExtension();
    }

    public String getFileExtension() {
        if (currentResource() == null) ExceptionHandler.throwLogException(new NullPointerException("There is no active resource!"));
        return getFileExtension(currentResource());
    }
    //</editor-fold>
    //</editor-fold>
}
