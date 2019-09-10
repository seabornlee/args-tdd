import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SchemaTest {

    @Test
    public void should_convert_bool_value() {
        Schema schema = new Schema("l:bool");
        assertThat((boolean) schema.convert("true", "l")).isTrue();
        assertThat((boolean) schema.convert("false", "l")).isFalse();
    }

    @Test
    public void should_convert_int_value() {
        Schema schema = new Schema("p:int");
        assertThat(schema.convert("8080", "p")).isEqualTo(8080);
        assertThat(schema.convert("-1", "p")).isEqualTo(-1);
        assertThat(schema.convert("010", "p")).isEqualTo(10);
    }

    @Test
    public void should_convert_string_value() {
        Schema schema = new Schema("d:string");
        assertThat(schema.convert("/usr/logs", "d")).isEqualTo("/usr/logs");
    }
}