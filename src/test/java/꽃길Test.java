import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.꽃길_14620;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 꽃길Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "6\n"
                        + "1 0 2 3 3 4\n"
                        + "1 1 1 1 1 1\n"
                        + "0 0 1 1 1 1\n"
                        + "3 9 9 0 1 99\n"
                        + "9 11 3 1 0 3\n"
                        + "12 3 0 0 0 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"12"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        꽃길_14620 test = new 꽃길_14620();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");
//        String[] outputArray = output.split("\n");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(outputArray[0], outputArray[1], outputArray[2]);
        Assertions.assertEquals(result, output);
    }
}
