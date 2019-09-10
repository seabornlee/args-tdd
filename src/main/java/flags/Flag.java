package flags;

import exception.TypeNotSupportedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Flag {
    private String name;
    private String defaultValue;

    public static Flag of(String type) {
        Map<String, Class<? extends Flag>> map = new HashMap<>();
        map.put("bool", BoolFlag.class);
        map.put("int", IntFlag.class);
        map.put("string", StringFlag.class);

        Class<? extends Flag> clazz = map.get(type);
        if (clazz == null) {
            throw new TypeNotSupportedException(type);
        }

        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public abstract Object convert(String valueAsString);

    public void setName(String name) {
        this.name = name;
    }

    public String getValue(String[] argsArray) {
        List<String> strings = Arrays.asList(argsArray);
        if (!isValueRequired() && strings.contains("-" + this.name)) {
            return getExistedValue();
        }

        int i = strings.indexOf("-" + this.name);
        if (i == -1) {
            if (this.defaultValue != null) {
                return this.defaultValue;
            }
            return getDefaultValue();

        }
        return strings.get(i + 1);
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    protected String getExistedValue() {
        return "";
    }

    protected boolean isValueRequired() {
        return true;
    }

    protected abstract String getDefaultValue();
}
