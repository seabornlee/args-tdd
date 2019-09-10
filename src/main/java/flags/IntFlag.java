package flags;

public class IntFlag extends Flag{

    @Override
    public Object convert(String valueAsString) {
        return Integer.parseInt(valueAsString);
    }

    @Override
    protected String getDefaultValue() {
        return "0";
    }
}
