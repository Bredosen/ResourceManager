package bredo.cmd.mc.resourcemanager.filecontexts.utilities;

import bredo.cmd.mc.resourcemanager.filecontexts.validator.FileContextValidator;
import bredo.cmd.mc.unilink.utilities.RegistryElement;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class FileContext extends RegistryElement {

    private String fileName;
    private String fileDirectory;
    private String fileExtension;
    private boolean usePluginFolder;

    private JavaPlugin javaPlugin;
    private File file;

    private FileContext(final String name) {
        super(name);
    }

    public static FileContext createInstance(final String name) {
        FileContextValidator.validateFileContextName(name);
        final FileContext fileContext = new FileContext(name);
        return fileContext;
    }

    public void initializeFile(final JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
        final String directory = (isUsePluginFolder() ? javaPlugin.getDataFolder().getPath() : "");
        final String fullDirectory = directory + (getFileDirectory().isEmpty() ? "" : "\\") + getFileDirectory();
        this.file = new File(fullDirectory, getFileName() + '.' + getFileExtension());
    }

    public boolean initialized() {
        return javaPlugin != null && file != null;
    }

    public File getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(final String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(final String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public boolean isUsePluginFolder() {
        return usePluginFolder;
    }

    public void setUsePluginFolder(final boolean usePluginFolder) {
        this.usePluginFolder = usePluginFolder;
    }
}
