import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.오목_2615;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 오목Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
                "1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 3 2", "1 1 1"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        오목_2615 test = new 오목_2615();
        test.main(new String[]{});

        String output = testSetting.getOutput();
//        output = output.replaceAll(System.getProperty("line.separator"), "");

        String[] resultArray = result.split(" ");

        org.assertj.core.api.Assertions.assertThat(output)
                .contains(resultArray[0], resultArray[1], resultArray[2]);
//        Assertions.assertEquals(result, output);
    }
}
