import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class ArgsParser {

    private Map<String, Object> values;
    private Map<String, String> schemaMap;

    public ArgsParser(String schema) {
        schemaMap = parseSchema(schema);
    }

    public void parse(String[] args) {
        values = new HashMap<>();

        for (Map.Entry<String, String> entry : schemaMap.entrySet()) {
            String flagName = entry.getKey();
            String flagType = entry.getValue();

            if (flagType.equals("bool")) {
                values.put(flagName, asList(args).contains("-" + flagName));
            } else {
                String value = args[asList(args).indexOf("-" + flagName) + 1];
                if (flagType.equals("int")) {
                    values.put(flagName, parseInt(value));
                } else {
                    values.put(flagName, value);
                }
            }
        }
    }

    private Map<String, String> parseSchema(String schema) {
        Map<String, String> schemaMap = new HashMap<>();
        String[] array = schema.split(" ");
        for (String pair : array) {
            String[] flagDefinition = pair.split(":");
            schemaMap.put(flagDefinition[0], flagDefinition[1]);
        }
        return schemaMap;
    }

    public Object getValue(String flag) {
        return values.get(flag);
    }
}
