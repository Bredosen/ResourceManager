package bredo.cmd.mc.resourcemanager.resources.validator;

import bredo.cmd.mc.resourcemanager.resources.utilities.Resource;
import bredo.cmd.mc.resourcemanager.resources.utilities.Resource;
import bredo.cmd.mc.unilink.validators.Validator;

public final class ResourceValidator {

    public static void validateResource(final Resource resource) {
        Validator.validateObject(resource, "Resource");
    }

    public static void validateResourceName(final String resourceName) {
        Validator.validateString(resourceName, true, "Resource name");
    }
}
