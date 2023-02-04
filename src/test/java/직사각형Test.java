import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.직사각형_16973;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 직사각형Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4 5\n"
                        + "0 0 0 0 0\n"
                        + "0 0 1 0 0\n"
                        + "0 0 0 0 0\n"
                        + "0 0 0 0 0\n"
                        + "2 2 1 1 1 4",
                "6 7\n"
                        + "0 0 0 0 0 0 0\n"
                        + "0 0 0 1 0 0 0\n"
                        + "0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 1\n"
                        + "0 0 1 0 0 0 0\n"
                        + "0 0 0 0 0 0 0\n"
                        + "2 3 1 1 5 5"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"7", "8"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        직사각형_16973 test = new 직사각형_16973();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
