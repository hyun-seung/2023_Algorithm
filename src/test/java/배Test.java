import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.배_1092;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 배Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "3\n6 8 9\n5\n2 5 2 4 7",
                "2\n19 20\n7\n14 12 16 19 16 1 5",
                "4\n23 32 25 28\n10\n5 27 10 16 24 20 2 32 18 7",
                "10\n11 17 5 2 20 7 5 5 20 7\n5\n18 18 15 15 17"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"2", "4", "3", "2"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        배_1092 test = new 배_1092();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
