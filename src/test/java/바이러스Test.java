import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.graph.바이러스_2606;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 바이러스Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "7\n"
                        + "6\n"
                        + "1 2\n"
                        + "2 3\n"
                        + "1 5\n"
                        + "5 2\n"
                        + "5 6\n"
                        + "4 7"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"4"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        바이러스_2606 test = new 바이러스_2606();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

//        String[] resultArray = result.split(" ");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(resultArray[0], resultArray[1], resultArray[2]);
        Assertions.assertEquals(result, output);
    }
}
