import exception.TypeNotSupportedException;
import flags.BoolFlag;
import flags.Flag;
import flags.IntFlag;
import flags.StringFlag;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class FlagTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_create_instance_by_type() {
        assertThat(Flag.of("bool") instanceof BoolFlag).isTrue();
        assertThat(Flag.of("int") instanceof IntFlag).isTrue();
        assertThat(Flag.of("string") instanceof StringFlag).isTrue();
    }

    @Test
    public void should_throw_exception_when_type_not_supported() {
        expectedException.expect(TypeNotSupportedException.class);
        expectedException.expectMessage("Type 'char' not supported.");
        Flag.of("char");
    }
}