package bredo.cmd.mc.resourcemanager.serialization.manipulators;

import bredo.cmd.mc.resourcemanager.serialization.interfaces.ISerialization;
import bredo.cmd.mc.resourcemanager.serialization.manager.SerializationManager;
import bredo.cmd.mc.resourcemanager.serialization.utilities.Serialization;
import bredo.cmd.mc.resourcemanager.serialization.validator.SerializationValidator;
import bredo.cmd.mc.unilink.validators.Validator;

public final class SerializationManipulator {

    //<editor-fold desc="Constructor">
    private SerializationManipulator() {
    }
    //</editor-fold>

    //<editor-fold desc="Current Serialization">
    private static String currentSerialization;

    public static void selectSerialization(final String serialization) {
        Validator.validateString(serialization, "Serialization name", true);
        currentSerialization = serialization;
    }

    public static void deselectSerialization() {
        currentSerialization = null;
    }

    public static String currentSerialization() {
        return currentSerialization;
    }

    private static void validateCurrentSerialization() {
        SerializationValidator.validateSerializationName(currentSerialization());
    }
    //</editor-fold>

    //<editor-fold desc="ISerialization">
    public static void setISerialization(final String serializationName, final ISerialization iSerialization) {
        SerializationValidator.validateSerializationName(serializationName);
        Validator.validateObject(iSerialization, "ISerialization");
        final Serialization serialization = SerializationManager.serializationRegistry().retrieveElement(serializationName);
        serialization.setISerialization(iSerialization);
    }

    public static void setISerialization(final ISerialization iSerialization) {
        validateCurrentSerialization();
        setISerialization(currentSerialization(), iSerialization);
    }

    public static ISerialization getISerialization(final String serializationName) {
        SerializationValidator.validateSerializationName(serializationName);
        final Serialization serialization = SerializationManager.serializationRegistry().retrieveElement(serializationName);
        return serialization.getiSerialization();
    }

    public static ISerialization getISerialization() {
        validateCurrentSerialization();
        return getISerialization(currentSerialization());
    }
    //</editor-fold>
}
