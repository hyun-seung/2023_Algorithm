import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.치킨배달_15686;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 치킨배달Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5 3\n"
                        + "0 0 1 0 0\n"
                        + "0 0 2 0 1\n"
                        + "0 1 2 0 0\n"
                        + "0 0 1 0 0\n"
                        + "0 0 0 0 2",
                "5 2\n"
                        + "0 2 0 1 0\n"
                        + "1 0 1 0 0\n"
                        + "0 0 0 0 0\n"
                        + "2 0 0 1 1\n"
                        + "2 2 0 1 2",
                "5 1\n"
                        + "1 2 0 0 0\n"
                        + "1 2 0 0 0\n"
                        + "1 2 0 0 0\n"
                        + "1 2 0 0 0\n"
                        + "1 2 0 0 0",
                "5 1\n"
                        + "1 2 0 2 1\n"
                        + "1 2 0 2 1\n"
                        + "1 2 0 2 1\n"
                        + "1 2 0 2 1\n"
                        + "1 2 0 2 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"5", "10", "11", "32"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        치킨배달_15686 test = new 치킨배달_15686();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output);
    }
}
