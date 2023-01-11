import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.치킨_16439;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 치킨Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "3 5\n1 2 3 4 5\n5 4 3 2 1\n1 2 3 2 1",
                "4 6\n1 2 3 4 5 6\n6 5 4 3 2 1\n3 2 7 9 2 5\n4 5 6 3 2 1"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"13", "25"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        치킨_16439 test = new 치킨_16439();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");
//        String[] outputArray = output.split("\n");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(outputArray[0], outputArray[1]);
        Assertions.assertEquals(result, output);
    }
}
