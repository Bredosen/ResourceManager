package bredo.cmd.mc.resourcemanager.filecontexts.manipulators;

import bredo.cmd.mc.resourcemanager.filecontexts.manager.FileContextManager;
import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;
import bredo.cmd.mc.resourcemanager.filecontexts.validator.FileContextValidator;
import bredo.cmd.mc.unilink.validators.Validator;

public final class FileContextManipulator {

    //<editor-fold desc="Constructor">
    private FileContextManipulator() {
    }
    //</editor-fold>

    //<editor-fold desc="Current FileContext">
    private static String currentFileContext;

    public static void selectFileContext(final String fileContext) {
        Validator.validateString(fileContext, "FileContext name", true);
        currentFileContext = fileContext;
    }

    public static void deselectFileContext() {
        currentFileContext = null;
    }

    public static String currentFileContext() {
        return currentFileContext;
    }

    private static void validateCurrentFileContext() {
        FileContextValidator.validateFileContextName(currentFileContext());
    }
    //</editor-fold>

    //<editor-fold desc="SetFile">
    public static void setFile(final String fileContextName, final String fileName, final String fileDirectory, final String fileExtension, final boolean usePluginFolder) {
        setFileName(fileContextName, fileName);
        setFileDirectory(fileContextName, fileDirectory);
        setFileExtension(fileContextName, fileExtension);
        setUsePluginFolder(fileContextName, usePluginFolder);
    }

    public static void setFile(final String fileName, final String fileDirectory, final String fileExtension, final boolean usePluginFolder) {
        validateCurrentFileContext();
        setFileName(currentFileContext(), fileName);
        setFileDirectory(currentFileContext(), fileDirectory);
        setFileExtension(currentFileContext(), fileExtension);
        setUsePluginFolder(currentFileContext(), usePluginFolder);
    }
    //</editor-fold>

    //<editor-fold desc="FileName">
    public static void setFileName(final String fileContextName, final String fileName) {
        FileContextValidator.validateFileContextName(fileContextName);
        Validator.validateString(fileName, "File name", true);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        fileContext.setFileName(fileName);
    }

    public static void setFileName(final String fileName) {
        validateCurrentFileContext();
        setFileName(currentFileContext(), fileName);
    }

    public static String getFileName(final String fileContextName) {
        FileContextValidator.validateFileContextName(fileContextName);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        return fileContext.getFileName();
    }

    public static String getFileName() {
        validateCurrentFileContext();
        return getFileName(currentFileContext());
    }
    //</editor-fold>

    //<editor-fold desc="FileDirectory">
    public static void setFileDirectory(final String fileContextName, final String fileDirectory) {
        FileContextValidator.validateFileContextName(fileContextName);
        Validator.validateString(fileDirectory, "File directory", false);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        fileContext.setFileDirectory(fileDirectory);
    }

    public static void setFileDirectory(final String fileDirectory) {
        validateCurrentFileContext();
        setFileDirectory(currentFileContext(), fileDirectory);
    }

    public static String getFileDirectory(final String fileContextName) {
        FileContextValidator.validateFileContextName(fileContextName);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        return fileContext.getFileDirectory();
    }

    public static String getFileDirectory() {
        validateCurrentFileContext();
        return getFileDirectory(currentFileContext());
    }
    //</editor-fold>

    //<editor-fold desc="FileExtension">
    public static void setFileExtension(final String fileContextName, final String fileExtension) {
        FileContextValidator.validateFileContextName(fileContextName);
        Validator.validateString(fileExtension, "File extension", false);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        fileContext.setFileExtension(fileExtension);
    }

    public static void setFileExtension(final String fileExtension) {
        validateCurrentFileContext();
        setFileExtension(currentFileContext(), fileExtension);
    }

    public static String getFileExtension(final String fileContextName) {
        FileContextValidator.validateFileContextName(fileContextName);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        return fileContext.getFileExtension();
    }

    public static String getFileExtension() {
        validateCurrentFileContext();
        return getFileExtension(currentFileContext());
    }
    //</editor-fold>

    //<editor-fold desc="UsePluginFolder">
    public static void setUsePluginFolder(final String fileContextName, final boolean usePluginFolder) {
        FileContextValidator.validateFileContextName(fileContextName);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        fileContext.setUsePluginFolder(usePluginFolder);
    }

    public static void setUsePluginFolder(final boolean usePluginFolder) {
        validateCurrentFileContext();
        setUsePluginFolder(currentFileContext(), usePluginFolder);
    }

    public static boolean usePluginFolder(final String fileContextName) {
        FileContextValidator.validateFileContextName(fileContextName);
        final FileContext fileContext = FileContextManager.fileContextRegistry().retrieveElement(fileContextName);
        return fileContext.isUsePluginFolder();
    }

    public static boolean usePluginFolder() {
        validateCurrentFileContext();
        return usePluginFolder(currentFileContext());
    }
    //</editor-fold>
}
