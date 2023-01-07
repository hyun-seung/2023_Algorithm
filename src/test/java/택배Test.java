import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.택배_8980;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 택배Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4 40\n6\n3 4 20\n1 2 10\n1 3 20\n1 4 30\n2 3 10\n2 4 20",
                "6 60\n5\n1 2 30\n2 5 70\n5 6 60\n3 4 40\n1 6 40"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"70", "150"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        택배_8980 test = new 택배_8980();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

        Assertions.assertEquals(result, output);
    }
}
