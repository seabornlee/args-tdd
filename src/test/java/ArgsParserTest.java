import exception.FlagNotDefinedException;
import exception.SchemaCanNotBeBlankException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsParserTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_parse_args() {
        ArgsParser argsParser = new ArgsParser("l:bool p:int d:string");
        String[] args = new String[]{"-l", "-p", "8080", "-d", "/usr/logs"};

        argsParser.parse(args);

        assertThat((boolean) argsParser.getValue("l")).isTrue();
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }

    @Test
    public void should_return_default_value_by_type() {
        ArgsParser argsParser = new ArgsParser("l:bool p:int d:string");
        String[] args = new String[]{};

        argsParser.parse(args);

        assertThat((boolean) argsParser.getValue("l")).isFalse();
        assertThat(argsParser.getValue("p")).isEqualTo(0);
        assertThat(argsParser.getValue("d")).isEqualTo("");
    }

    @Test
    public void should_return_specified_default_value() {
        ArgsParser argsParser = new ArgsParser("l:bool:true p:int:8080 d:string:/usr/logs");
        String[] args = new String[]{};

        argsParser.parse(args);

        assertThat((boolean) argsParser.getValue("l")).isTrue();
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }

    @Test
    public void should_notice_when_schema_is_blank() {
        expectedException.expect(SchemaCanNotBeBlankException.class);
        expectedException.expectMessage("Schema can not be blank.");
        new ArgsParser("");
    }

    @Test
    public void should_notice_when_flag_not_defined() {
        expectedException.expect(FlagNotDefinedException.class);
        expectedException.expectMessage("Flag 'l' not supported.");
        ArgsParser argsParser = new ArgsParser("x:bool");
        String[] args = new String[]{"-l"};
        argsParser.parse(args);
    }
}
