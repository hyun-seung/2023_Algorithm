import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.동전게임_9079;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 동전게임Test {
    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "3\n"
                        + "H T T\n"
                        + "H T T\n"
                        + "T H H\n"
                        + "T H H\n"
                        + "H H H\n"
                        + "H H H\n"
                        + "H H H\n"
                        + "H T H\n"
                        + "H H H"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"2\n"
            + "-1\n"
            + "4"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        동전게임_9079 test = new 동전게임_9079();
        test.main(new String[]{});

        String output = testSetting.getOutput();
//        output = output.replaceAll(System.getProperty("line.separator"), "");
        String[] outputArray = output.split("\n");

        org.assertj.core.api.Assertions.assertThat(output)
                .contains(outputArray[0], outputArray[1], outputArray[2]);
//        Assertions.assertEquals(result, output);
    }
}
