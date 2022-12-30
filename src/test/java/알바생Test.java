import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.알바생_강호_1758;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 알바생Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4\n3\n3\n3\n3",
                "3\n3\n2\n3",
                "5\n7\n8\n6\n9\n10",
                "5\n1\n1\n1\n1\n2",
                "3\n1\n2\n3"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"6", "5", "30", "2", "4"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        알바생_강호_1758 test = new 알바생_강호_1758();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
