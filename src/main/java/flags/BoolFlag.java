package flags;

public class BoolFlag extends Flag {

    protected String getDefaultValue() {
        return "false";
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    protected boolean isValueRequired() {
        return false;
    }

    @Override
    protected Object convertSingleValue(String valueAsString) {
        return Boolean.parseBoolean(valueAsString);
    }

    @Override
    protected String getExistedValue() {
        return "true";
    }
}
