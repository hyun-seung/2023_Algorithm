import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.주유소_13305;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 주유소Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4\n2 3 1\n5 2 4 1",
                "4\n3 3 4\n1 1 1 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"18", "10"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        주유소_13305 test = new 주유소_13305();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
