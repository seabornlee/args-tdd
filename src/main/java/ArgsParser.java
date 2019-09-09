import flags.Flag;

import java.util.Optional;

public class ArgsParser {

    private final Schema schema = new Schema();

    public ArgsParser(String schemaAsString) {
        schema.parse(schemaAsString);
    }

    public void parse(String[] args) {
        schema.getFlags().forEach(flag -> flag.parseValue(args));
    }

    public Object getValue(String flagName) {
        Optional<Flag> flag = schema.getFlags()
                .stream()
                .filter((f) -> f.getName().equals(flagName))
                .findFirst();
        return flag.get().getValue();
    }
}
