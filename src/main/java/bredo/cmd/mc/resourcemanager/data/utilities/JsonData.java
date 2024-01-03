package bredo.cmd.mc.resourcemanager.data.utilities;

import java.util.ArrayList;
import java.util.List;

public final class JsonData extends Data {

    public JsonData(final String name) {
        super(name);
        setConfig("Comments", new ArrayList<String>());
    }

    @Override
    public void setValue(final Object value) {
        super.setValue(value);
        setDataType(value.getClass());
    }

    public void addComment(final String comment) {
        getComments().add(comment);
    }

    public String getPath() {
        return getName();
    }

    public void setDataType(final Class<?> classType) {
        setConfig("classType", classType);
    }

    public Class<?> getDataType() {
        return (Class<?>) getConfig("classType");
    }

    public List<String> getComments() {
        return (List<String>) getConfig("Comments");
    }
}
