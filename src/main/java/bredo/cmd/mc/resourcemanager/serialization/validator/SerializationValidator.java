package bredo.cmd.mc.resourcemanager.serialization.validator;

import bredo.cmd.mc.resourcemanager.serialization.utilities.Serialization;
import bredo.cmd.mc.unilink.validators.Validator;

public final class SerializationValidator {

    public static void validateSerialization(final Serialization serialization) {
        Validator.validateObject(serialization, "Serialization");
    }

    public static void validateSerializationName(final String serializationName) {
        Validator.validateString(serializationName, true, "Serialization name");
    }
}
