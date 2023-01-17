import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.제곱수찾기_1025;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 제곱수찾기Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "2 3\n"
                        + "123\n"
                        + "456",
                "5 5\n"
                        + "00000\n"
                        + "00000\n"
                        + "00200\n"
                        + "00000\n"
                        + "00000",
                "6 7\n"
                        + "3791178\n"
                        + "1283252\n"
                        + "4103617\n"
                        + "8233494\n"
                        + "8725572\n"
                        + "2937261",
                "5 9\n"
                        + "135791357\n"
                        + "357913579\n"
                        + "579135791\n"
                        + "791357913\n"
                        + "913579135",
                "9 9\n"
                        + "553333733\n"
                        + "775337775\n"
                        + "777537775\n"
                        + "777357333\n"
                        + "755553557\n"
                        + "355533335\n"
                        + "373773573\n"
                        + "337373777\n"
                        + "775557777"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"64", "0", "320356", "9", "-1"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        제곱수찾기_1025 test = new 제곱수찾기_1025();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output);
    }
}
