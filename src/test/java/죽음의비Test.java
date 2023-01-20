import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.죽음의비_22944;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 죽음의비Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4 10 4\n"
                        + "S..U\n"
                        + "....\n"
                        + "....\n"
                        + "...E",
                "4 2 6\n"
                        + "S..U\n"
                        + "....\n"
                        + "....\n"
                        + "...E",
                "4 3 3\n"
                        + "S..U\n"
                        + "....\n"
                        + "....\n"
                        + "...E"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"6", "-1", "6"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        죽음의비_22944 test = new 죽음의비_22944();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output);
    }
}
