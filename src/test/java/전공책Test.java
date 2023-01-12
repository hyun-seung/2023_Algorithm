import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.전공책_16508;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 전공책Test {
    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "ANT\n4\n35000 COMPUTERARCHITECTURE\n47000 ALGORITHM\n43000 NETWORK\n40000 OPERATINGSYSTEM",
                "ALMIGHTY\n4\n35000 COMPUTERARCHITECTURE\n47000 ALGORITHM\n43000 NETWORK\n40000 OPERATONGSYSTEM",
                "BAKEJOON\n"
                        + "3\n"
                        + "25000 JAVA\n"
                        + "10000 OOP\n"
                        + "30000 BINARYCHECK",
                "JAVA\n"
                        + "2\n"
                        + "30000 CPLUSPLUS\n"
                        + "25000 PYTHON"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"40000", "87000", "65000", "-1"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        전공책_16508 test = new 전공책_16508();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        output = output.replaceAll(System.getProperty("line.separator"), "");
//        String[] outputArray = output.split("\n");

//        org.assertj.core.api.Assertions.assertThat(output)
//                .contains(outputArray[0], outputArray[1]);
        Assertions.assertEquals(result, output);
    }
}
