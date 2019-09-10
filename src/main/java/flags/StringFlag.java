package flags;

public class StringFlag extends Flag {

    @Override
    public Object convert(String valueAsString) {
        return valueAsString;
    }

    @Override
    protected String getDefaultValue() {
        return "";
    }
}
