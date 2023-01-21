import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.스티커_18808;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 스티커Test {
    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5 4 4\n"
                        + "3 3\n"
                        + "1 0 1\n"
                        + "1 1 1\n"
                        + "1 0 1\n"
                        + "2 5\n"
                        + "1 1 1 1 1\n"
                        + "0 0 0 1 0\n"
                        + "2 3\n"
                        + "1 1 1\n"
                        + "1 0 1\n"
                        + "3 3\n"
                        + "1 0 0\n"
                        + "1 1 1\n"
                        + "1 0 0",
                "1 3 3\n"
                        + "2 3\n"
                        + "1 0 0\n"
                        + "1 1 1\n"
                        + "1 1\n"
                        + "1\n"
                        + "3 1\n"
                        + "1\n"
                        + "1\n"
                        + "1",
                "2 3 3\n"
                        + "2 3\n"
                        + "1 1 1\n"
                        + "1 0 0\n"
                        + "2 1\n"
                        + "1\n"
                        + "1\n"
                        + "2 2\n"
                        + "1 0\n"
                        + "1 1",
                "4 5 4\n"
                        + "3 3\n"
                        + "1 0 1\n"
                        + "1 1 1\n"
                        + "0 1 0\n"
                        + "2 4\n"
                        + "1 1 1 1\n"
                        + "0 1 0 1\n"
                        + "1 4\n"
                        + "1 1 1 1\n"
                        + "4 2\n"
                        + "1 0\n"
                        + "1 1\n"
                        + "0 1\n"
                        + "0 1",
                "2 2 3\n"
                        + "3 1\n"
                        + "1\n"
                        + "1\n"
                        + "1\n"
                        + "2 3\n"
                        + "1 0 1\n"
                        + "1 1 1\n"
                        + "2 4\n"
                        + "1 0 1 1\n"
                        + "1 1 1 0",
                "6 7 5\n"
                        + "4 6\n"
                        + "1 0 0 1 0 1\n"
                        + "1 1 0 1 0 1\n"
                        + "1 1 1 1 1 1\n"
                        + "0 0 0 1 0 0\n"
                        + "4 3\n"
                        + "0 1 0\n"
                        + "1 1 1\n"
                        + "0 1 1\n"
                        + "1 1 0\n"
                        + "3 6\n"
                        + "1 1 1 1 1 1\n"
                        + "0 0 1 0 0 0\n"
                        + "0 0 1 0 0 0\n"
                        + "6 6\n"
                        + "0 0 1 1 0 0\n"
                        + "1 1 1 1 0 1\n"
                        + "0 0 1 1 1 1\n"
                        + "0 0 1 1 1 1\n"
                        + "1 1 1 0 1 1\n"
                        + "0 1 0 0 1 0\n"
                        + "4 4\n"
                        + "1 1 1 1\n"
                        + "0 0 0 1\n"
                        + "0 0 1 1\n"
                        + "0 0 0 1",
                "6 8 3\n"
                        + "4 5\n"
                        + "0 0 1 1 1\n"
                        + "1 1 1 0 1\n"
                        + "0 0 1 0 1\n"
                        + "0 0 1 0 0\n"
                        + "5 4\n"
                        + "0 0 1 0\n"
                        + "1 1 1 1\n"
                        + "1 1 0 1\n"
                        + "1 1 0 0\n"
                        + "1 1 0 0\n"
                        + "5 6\n"
                        + "0 0 1 1 1 1\n"
                        + "1 1 1 1 0 0\n"
                        + "1 1 1 1 1 0\n"
                        + "0 1 0 1 0 0\n"
                        + "0 1 0 1 0 0",
                "8 6 6\n"
                        + "3 5\n"
                        + "0 1 0 0 0\n"
                        + "1 1 1 1 1\n"
                        + "0 1 0 0 1\n"
                        + "6 3\n"
                        + "0 0 1\n"
                        + "0 0 1\n"
                        + "0 0 1\n"
                        + "1 1 1\n"
                        + "1 0 1\n"
                        + "1 1 1\n"
                        + "6 3\n"
                        + "1 1 0\n"
                        + "1 0 0\n"
                        + "1 1 1\n"
                        + "1 0 1\n"
                        + "1 0 0\n"
                        + "1 0 0\n"
                        + "6 6\n"
                        + "0 0 0 0 1 0\n"
                        + "0 0 1 0 1 0\n"
                        + "0 0 1 0 1 0\n"
                        + "0 1 1 1 1 0\n"
                        + "0 1 1 0 1 1\n"
                        + "1 1 1 0 0 0\n"
                        + "4 5\n"
                        + "0 0 0 0 1\n"
                        + "1 0 0 1 1\n"
                        + "1 1 1 1 0\n"
                        + "1 1 0 1 0\n"
                        + "4 3\n"
                        + "1 1 0\n"
                        + "1 0 0\n"
                        + "1 1 1\n"
                        + "1 1 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"18", "1", "6", "17", "0", "30", "22", "29"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        스티커_18808 test = new 스티커_18808();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output);
    }
}
