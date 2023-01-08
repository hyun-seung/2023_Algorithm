import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.수학_19532;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 수학Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "1 3 -1 4 1 7",
                "2 5 8 3 -4 -11"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 -1", "-1 2"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        수학_19532 test = new 수학_19532();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

        Assertions.assertEquals(result, output);
    }
}
