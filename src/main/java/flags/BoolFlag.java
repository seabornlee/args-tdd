package flags;

public class BoolFlag extends Flag {

    @Override
    public Object convert(String valueAsString) {
        return Boolean.parseBoolean(valueAsString);
    }

    @Override
    protected String getDefaultValue() {
        return "false";
    }

    @Override
    protected boolean isValueRequired() {
        return false;
    }

    @Override
    protected String getExistedValue() {
        return "true";
    }
}
