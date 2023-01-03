import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.행복유치원_13164;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 행복유치원Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5 3\n1 3 5 6 10"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"3"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        행복유치원_13164 test = new 행복유치원_13164();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
