package bredo.cmd.mc.resourcemanager.data.utilities;

import bredo.cmd.mc.unilink.utilities.RegistryElement;
import bredo.cmd.mc.unilink.validators.Validator;

import java.util.HashMap;

public class Data extends RegistryElement {

    private Object value;
    private final HashMap<String, Object> configurations;

    public Data(final String name) {
        super(name);
        this.configurations = new HashMap<>();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public void setConfig(final String call, final Object config) {
        Validator.validateString(call, "Config Call Key", true);
        Validator.validateObject(config, "Config value");
        getConfigurations().put(call, config);
    }

    public Object getConfig(final String call) {
        Validator.validateString(call, "Config Call Key", true);
        return getConfigurations().get(call);
    }

    public HashMap<String, Object> getConfigurations() {
        return configurations;
    }
}
