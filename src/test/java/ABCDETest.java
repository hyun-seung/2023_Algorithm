import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.ABCDE_13023;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ABCDETest {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5 4\n"
                        + "0 1\n"
                        + "1 2\n"
                        + "2 3\n"
                        + "3 4",
                "5 5\n"
                        + "0 1\n"
                        + "1 2\n"
                        + "2 3\n"
                        + "3 0\n"
                        + "1 4",
                "6 5\n"
                        + "0 1\n"
                        + "0 2\n"
                        + "0 3\n"
                        + "0 4\n"
                        + "0 5",
                "8 8\n"
                        + "1 7\n"
                        + "3 7\n"
                        + "4 7\n"
                        + "3 4\n"
                        + "4 6\n"
                        + "3 5\n"
                        + "0 4\n"
                        + "2 7"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "1", "0", "1"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        ABCDE_13023 test = new ABCDE_13023();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
