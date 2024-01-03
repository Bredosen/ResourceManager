package bredo.cmd.mc.resourcemanager.filecontexts.validator;

import bredo.cmd.mc.resourcemanager.filecontexts.utilities.FileContext;
import bredo.cmd.mc.unilink.validators.Validator;

public final class FileContextValidator {

    public static void validateFileContext(final FileContext fileContext) {
        Validator.validateObject(fileContext, "FileContext");
    }

    public static void validateFileContextName(final String fileContextName) {
        Validator.validateString(fileContextName, true, "FileContext name");
    }
}
