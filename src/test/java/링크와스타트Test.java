import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.링크와스타트_15661;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 링크와스타트Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4\n"
                        + "0 1 2 3\n"
                        + "4 0 5 6\n"
                        + "7 1 0 2\n"
                        + "3 4 5 0",
                "6\n"
                        + "0 1 2 3 4 5\n"
                        + "1 0 2 3 4 5\n"
                        + "1 2 0 3 4 5\n"
                        + "1 2 3 0 4 5\n"
                        + "1 2 3 4 0 5\n"
                        + "1 2 3 4 5 0",
                "8\n"
                        + "0 5 4 5 4 5 4 5\n"
                        + "4 0 5 1 2 3 4 5\n"
                        + "9 8 0 1 2 3 1 2\n"
                        + "9 9 9 0 9 9 9 9\n"
                        + "1 1 1 1 0 1 1 1\n"
                        + "8 7 6 5 4 0 3 2\n"
                        + "9 1 9 1 9 1 0 9\n"
                        + "6 5 4 3 2 1 9 0",
                "5\n"
                        + "0 3 1 1 1\n"
                        + "3 0 1 1 1\n"
                        + "1 1 0 1 1\n"
                        + "1 1 1 0 1\n"
                        + "1 1 1 1 0"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "2", "1", "0"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        링크와스타트_15661 test = new 링크와스타트_15661();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output);
    }
}
