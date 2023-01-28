import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.단지_2667;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 단지Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "7\n"
                        + "0110100\n"
                        + "0110101\n"
                        + "1110101\n"
                        + "0000111\n"
                        + "0100000\n"
                        + "0111110\n"
                        + "0111000",
                "5\n"
                        + "11111\n"
                        + "11111\n"
                        + "11111\n"
                        + "11111\n"
                        + "11111",
                "10\n"
                        + "1111111111\n"
                        + "1000000001\n"
                        + "1011111101\n"
                        + "1010000101\n"
                        + "1010110101\n"
                        + "1010110101\n"
                        + "1010000101\n"
                        + "1011111101\n"
                        + "1000000001\n"
                        + "1111111111"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"3789", "125", "342036"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        단지_2667 test = new 단지_2667();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output.trim());
    }
}
