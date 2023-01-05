import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.꿀따기_21758;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 꿀따기Test {
    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "7\n9 9 4 1 4 9 9",
                "7\n4 4 9 1 9 4 4",
                "3\n2 5 4"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"57", "54", "10"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        꿀따기_21758 test = new 꿀따기_21758();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }

}
