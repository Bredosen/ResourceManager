package bredo.cmd.mc.resourcemanager.filecontexts.manager;

import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class FileManager {

    //<editor-fold desc="Singleton & Constructor">
    private final static FileManager SINGLETON;

    static {
        SINGLETON = new FileManager();
    }

    private FileManager() {
        fileContextRegistry = new Registry<>("File Context");
    }

    public static FileManager fileManager() {
        return SINGLETON;
    }
    //</editor-fold>

    public void initialize() {
        //TODO: Something
    }

    //<editor-fold desc="Resource Registry">
    private final Registry<FileContext> fileContextRegistry;

    public static Registry<FileContext> fileContextRegistry() {
        return fileManager().fileContextRegistry;
    }
    //</editor-fold>
}
