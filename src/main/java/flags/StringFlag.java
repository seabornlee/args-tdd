package flags;

public class StringFlag extends Flag {

    @Override
    protected Object convertSingleValue(String valueAsString) {
        return valueAsString;
    }

    @Override
    protected String getDefaultValue() {
        return "";
    }

    @Override
    public String getType() {
        return null;
    }
}
