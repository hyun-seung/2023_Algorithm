import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.숫자야구_2503;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 숫자야구Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4\n123 1 1\n356 1 0\n327 2 0\n489 0 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"2"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        숫자야구_2503 test = new 숫자야구_2503();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");
//        String[] outputArray = output.split("\n");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(outputArray[0], outputArray[1]);
        Assertions.assertEquals(result, output);
    }
}
