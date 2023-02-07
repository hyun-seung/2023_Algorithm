import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.트리의지름_1967;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 트리의지름Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "12\n"
                        + "1 2 3\n"
                        + "1 3 2\n"
                        + "2 4 5\n"
                        + "3 5 11\n"
                        + "3 6 9\n"
                        + "4 7 1\n"
                        + "4 8 7\n"
                        + "5 9 15\n"
                        + "5 10 4\n"
                        + "6 11 6\n"
                        + "6 12 10"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"45"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        트리의지름_1967 test = new 트리의지름_1967();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
