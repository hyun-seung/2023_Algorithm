import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.burte_force.DNA_1969;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DNATest {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5 8\nTATGATAC\nTAAGCTAC\nAAAGATCC\nTGAGATAC\nTAAGATGT",
                "4 10\nACGTACGTAC\nCCGTACGTAG\nGCGTACGTAT\nTCGTACGTAA",
                "6 10\nATGTTACCAT\nAAGTTACGAT\nAACAAAGCAA\nAAGTTACCTT\nAAGTTACCAA\nTACTTACCAA"
        );

        return testSetting.createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"TAAGATAC\n7", "ACGTACGTAA\n6", "AAGTTACCAA\n12"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        DNA_1969 test = new DNA_1969();
        test.main(new String[]{});

        String output = testSetting.getOutput();
        String[] outputArray = output.split("\n");
//        output = output.replaceAll(System.getProperty("line.separator"), "");

        org.assertj.core.api.Assertions.assertThat(output)
                .contains(outputArray[0], outputArray[1]);
    }
}
