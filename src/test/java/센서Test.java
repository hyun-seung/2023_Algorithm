import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.센서_2212;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 센서Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "6\n2\n1 6 9 3 6 7",
                "10\n5\n20 3 14 6 7 8 18 10 12 15"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"5", "7"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        센서_2212 test = new 센서_2212();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
