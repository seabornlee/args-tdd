import com.google.common.base.Strings;
import exception.SchemaCanNotBeBlankException;
import flags.Flag;

import java.util.ArrayList;
import java.util.List;

public class Schema {

    private final List<Flag> flags;

    public Schema(String schemaAsString) {
        if (Strings.isNullOrEmpty(schemaAsString)) {
            throw new SchemaCanNotBeBlankException();
        }

        flags = new ArrayList<>();
        String[] arrays = schemaAsString.split(" ");
        for (String flagDefinitionString : arrays) {
            String[] strings = flagDefinitionString.split(":");

            Flag flag = Flag.of(strings[1]);
            flag.setName(strings[0]);

            if (strings.length == 3) {
                flag.setDefaultValue(strings[2]);
            }

            flags.add(flag);
        }
    }

    public Object convert(String valueAsString, String flagName) {
        return getFlag(flagName).convert(valueAsString);
    }

    public Flag getFlag(String flagName) {
        return flags.stream().filter((f) -> f.getName().equals(flagName)).findFirst().orElse(null);
    }
}
