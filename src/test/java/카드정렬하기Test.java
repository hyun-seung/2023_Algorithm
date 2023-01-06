import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.카드정렬하기_1715;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 카드정렬하기Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "3\n10\n20\n40"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"100"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        카드정렬하기_1715 test = new 카드정렬하기_1715();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");

        Assertions.assertEquals(result, output);
    }
}
