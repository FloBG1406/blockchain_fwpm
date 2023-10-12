import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    void test(){

         //given
        String input = "{\"name\": \"Florian\"}";

        //when
        String output = Main.getNameFromJson(input);

        //then
        Assertions.assertEquals("Florian", output);
    }

    @Test
    void testNullInput() {
         //given
        String input = null;

        //then
        final NullPointerException nullException = Assertions.assertThrows(NullPointerException.class, () -> Main.getNameFromJson(input));
        Assertions.assertEquals("Json ist null", nullException.getMessage());
    }

    @Test
    void testBadInput() {
        //given
        String input = "BAD";

        //then
        final IllegalStateException illStateEx = Assertions.assertThrows(IllegalStateException.class, () -> Main.getNameFromJson(input));
        Assertions.assertEquals("Not a JSON Object: \"BAD\"", illStateEx.getMessage());
    }
}
