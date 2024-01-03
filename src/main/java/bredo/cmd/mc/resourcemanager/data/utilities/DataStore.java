package bredo.cmd.mc.resourcemanager.data.utilities;

import bredo.cmd.mc.resourcemanager.data.validator.DataValidator;
import bredo.cmd.mc.unilink.utilities.RegistryElement;

public final class Data extends RegistryElement {

    private Data(final String name) {
        super(name);
    }

    public static Data createInstance(final String name) {
        DataValidator.validateDataName(name);
        final Data data = new Data(name);
        return data;
    }
}
