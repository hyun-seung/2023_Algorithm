import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.폴리오미노_1343;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 폴리오미노Test {

    private TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of("XXXXXX", "XX.XX", "XXXX....XXX.....XX", "X", "XX.XXXXXXXXXX..XXXXXXXX...XXXXXX");

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"AAAABB", "BB.BB", "-1", "-1", "BB.AAAAAAAABB..AAAAAAAA...AAAABB"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        폴리오미노_1343 test = new 폴리오미노_1343();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
