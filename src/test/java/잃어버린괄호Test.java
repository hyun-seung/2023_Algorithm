import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.잃어버린괄호_1541;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 잃어버린괄호Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "55-50+40",
                "10+20+30+40",
                "00009-00009"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"-35", "100", "0"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        잃어버린괄호_1541 test = new 잃어버린괄호_1541();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
