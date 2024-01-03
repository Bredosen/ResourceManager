package bredo.cmd.mc.resourcemanager.filecontexts.manager;

import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;
import bredo.cmd.mc.unilink.utilities.Registry;

public final class FileContextManager {

    //<editor-fold desc="Singleton & Constructor">
    private final static FileContextManager SINGLETON;

    static {
        SINGLETON = new FileContextManager();
    }

    private FileContextManager() {
        fileContextRegistry = new Registry<>("File Context");
    }

    public static FileContextManager fileContextManager() {
        return SINGLETON;
    }

    //</editor-fold>
    //<editor-fold desc="Resource Registry">
    private final Registry<FileContext> fileContextRegistry;

    public static Registry<FileContext> fileContextRegistry() {
        return fileContextManager().fileContextRegistry;
    }
    //</editor-fold>
}
