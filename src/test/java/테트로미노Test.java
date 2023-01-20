import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.테트로미노_14500;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 테트로미노Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5 5\n"
                        + "1 2 3 4 5\n"
                        + "5 4 3 2 1\n"
                        + "2 3 4 5 6\n"
                        + "6 5 4 3 2\n"
                        + "1 2 1 2 1",
                "4 5\n"
                        + "1 2 3 4 5\n"
                        + "1 2 3 4 5\n"
                        + "1 2 3 4 5\n"
                        + "1 2 3 4 5",
                "4 10\n"
                        + "1 2 1 2 1 2 1 2 1 2\n"
                        + "2 1 2 1 2 1 2 1 2 1\n"
                        + "1 2 1 2 1 2 1 2 1 2\n"
                        + "2 1 2 1 2 1 2 1 2 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"19", "20", "7"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        테트로미노_14500 test = new 테트로미노_14500();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output);
    }
}
