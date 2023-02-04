import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.연구소_14502;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 연구소Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "7 7\n"
                        + "2 0 0 0 1 1 0\n"
                        + "0 0 1 0 1 2 0\n"
                        + "0 1 1 0 1 0 0\n"
                        + "0 1 0 0 0 0 0\n"
                        + "0 0 0 0 0 1 1\n"
                        + "0 1 0 0 0 0 0\n"
                        + "0 1 0 0 0 0 0",
                "4 6\n"
                        + "0 0 0 0 0 0\n"
                        + "1 0 0 0 0 2\n"
                        + "1 1 1 0 0 2\n"
                        + "0 0 0 0 0 2",
                "8 8\n"
                        + "2 0 0 0 0 0 0 2\n"
                        + "2 0 0 0 0 0 0 2\n"
                        + "2 0 0 0 0 0 0 2\n"
                        + "2 0 0 0 0 0 0 2\n"
                        + "2 0 0 0 0 0 0 2\n"
                        + "0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"27", "9", "3"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        연구소_14502 test = new 연구소_14502();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
