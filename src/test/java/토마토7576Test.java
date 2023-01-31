import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.토마토_7576;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 토마토7576Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "6 4\n"
                        + "0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0\n"
                        + "0 0 0 0 0 1",
                "6 4\n"
                        + "0 -1 0 0 0 0\n"
                        + "-1 0 0 0 0 0\n"
                        + "0 0 0 0 0 0\n"
                        + "0 0 0 0 0 1",
                "6 4\n"
                        + "1 -1 0 0 0 0\n"
                        + "0 -1 0 0 0 0\n"
                        + "0 0 0 0 -1 0\n"
                        + "0 0 0 0 -1 1",
                "5 5\n"
                        + "-1 1 0 0 0\n"
                        + "0 -1 -1 -1 0\n"
                        + "0 -1 -1 -1 0\n"
                        + "0 -1 -1 -1 0\n"
                        + "0 0 0 0 0",
                "2 2\n"
                        + "1 -1\n"
                        + "-1 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"8", "-1", "6", "14", "0"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        토마토_7576 test = new 토마토_7576();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
