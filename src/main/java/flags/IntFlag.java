package flags;

public class IntFlag extends Flag{

    @Override
    protected Object convertSingleValue(String valueAsString) {
        return Integer.parseInt(valueAsString);
    }

    @Override
    protected String getDefaultValue() {
        return "0";
    }

    @Override
    public String getType() {
        return "int";
    }
}
