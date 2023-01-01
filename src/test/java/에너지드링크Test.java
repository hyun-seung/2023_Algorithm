import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.greedy.에너지드링크_20115;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 에너지드링크Test {

    TestSetting testSetting = new TestSetting();

    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }

    public InputStream settingInputs() {
        List<String> inputs = List.of(
                "5\n3 2 10 9 6",
                "10\n100 9 77 65 39 27 45 1 80 495"
        );

        return testSetting.createInputStream(inputs);
    }

    // 1번 답 - 사이트 표기 : 20 / 테스트 코드 일치를 위해 20.0으로 변경
    @ParameterizedTest
    @CsvSource(value = {"20.0", "716.5"})
    void test(String result) throws IOException {
        System.setIn(settingInputs());

        에너지드링크_20115 test = new 에너지드링크_20115();
        test.main(new String[]{});

        Assertions.assertEquals(result, testSetting.getOutput());
    }
}
