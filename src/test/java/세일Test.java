import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.ATM_11399;
import org.greedy.세일_11508;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 세일Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4\n3\n2\n3\n2",
                "6\n6\n4\n5\n5\n5\n5"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"8", "21"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        세일_11508 test = new 세일_11508();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
