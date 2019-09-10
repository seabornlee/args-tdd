import exception.FlagNotDefinedException;
import flags.Flag;

public class ArgsParser {
    private String[] argsArray;
    private Schema schema;

    public ArgsParser(String schemaAsString) {
        schema = new Schema(schemaAsString);
    }

    public void parse(String[] args) {
        argsArray = args;
        validate();
    }

    private void validate() {
        for (String s : argsArray) {
            if (s.startsWith("-")) {
                String flagName = s.substring(1);
                Flag flag = schema.getFlag(flagName);
                if (flag == null) {
                    throw new FlagNotDefinedException(flagName);
                }
            }
        }
    }

    public Object getValue(String flagName) {
        Flag flag = schema.getFlag(flagName);
        String valueAsString = flag.getValue(argsArray);
        return schema.convert(valueAsString, flagName);
    }
}
