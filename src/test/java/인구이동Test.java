import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.인구이동_16234;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 인구이동Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "2 20 50\n"
                        + "50 30\n"
                        + "20 40",
                "2 40 50\n"
                        + "50 30\n"
                        + "20 40",
                "2 20 50\n"
                        + "50 30\n"
                        + "30 40",
                "3 5 10\n"
                        + "10 15 20\n"
                        + "20 30 25\n"
                        + "40 22 10",
                "4 10 50\n"
                        + "10 100 20 90\n"
                        + "80 100 60 70\n"
                        + "70 20 30 40\n"
                        + "50 20 100 10"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "0", "1", "2", "3"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        인구이동_16234 test = new 인구이동_16234();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
