import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.피로도_22864;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 피로도Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5 3 2 10",
                "10 5 1 10",
                "11 5 1 10"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"24", "15", "0"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        피로도_22864 test = new 피로도_22864();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

        Assertions.assertEquals(result, output);
    }
}
