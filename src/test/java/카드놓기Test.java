import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.카드놓기_5568;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 카드놓기Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "4\n2\n1\n2\n12\n1",
                "6\n3\n72\n2\n12\n7\n2\n1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"7", "68"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        카드놓기_5568 test = new 카드놓기_5568();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");
//        String[] outputArray = output.split("\n");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(outputArray[0], outputArray[1]);
        Assertions.assertEquals(result, output);
    }
}
