import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.회의실배정_1931;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 회의실배정Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "11\n1 4\n3 5\n0 6\n5 7\n3 8\n5 9\n6 10\n8 11\n8 12\n2 13\n12 14"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"4"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        회의실배정_1931 test = new 회의실배정_1931();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
