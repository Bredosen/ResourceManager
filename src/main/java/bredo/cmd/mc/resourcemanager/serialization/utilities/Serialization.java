package bredo.cmd.mc.resourcemanager.serialization.utilities;

import bredo.cmd.mc.resourcemanager.serialization.interfaces.ISerialization;
import bredo.cmd.mc.resourcemanager.serialization.validator.SerializationValidator;
import bredo.cmd.mc.unilink.utilities.RegistryElement;

public final class Serialization extends RegistryElement {

    private ISerialization iSerialization;

    private Serialization(final String name) {
        super(name);
    }

    public static Serialization createInstance(final String name) {
        SerializationValidator.validateSerializationName(name);
        final Serialization serialization = new Serialization(name);
        //TODO: Add stuff I guess?
        return serialization;
    }

    public ISerialization getiSerialization() {
        return iSerialization;
    }

    public void setISerialization(final ISerialization iSerialization) {
        this.iSerialization = iSerialization;
    }
}
