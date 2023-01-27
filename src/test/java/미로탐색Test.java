import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.미로탐색_2178;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 미로탐색Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4 6\n"
                        + "101111\n"
                        + "101010\n"
                        + "101011\n"
                        + "111011",
                "4 6\n"
                        + "110110\n"
                        + "110110\n"
                        + "111111\n"
                        + "111101",
                "2 25\n"
                        + "1011101110111011101110111\n"
                        + "1110111011101110111011101",
                "7 7\n"
                        + "1011111\n"
                        + "1110001\n"
                        + "1000001\n"
                        + "1000001\n"
                        + "1000001\n"
                        + "1000001\n"
                        + "1111111"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"15", "9", "38", "13"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        미로탐색_2178 test = new 미로탐색_2178();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
