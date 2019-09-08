import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsParserTest {
    @Test
    public void should_parse_args_with_schema() {
        ArgsParser argsParser = new ArgsParser("l:bool p:int d:string");
        String[] args = new String[]{"-l", "-p", "8080", "-d", "/usr/logs"};
        argsParser.parse(args);

        assertThat((boolean) argsParser.getValue("l")).isTrue();
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }
}
