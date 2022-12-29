import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSetting {

    public static ByteArrayOutputStream outputStream;

    /*
    // 사용하고자 하는 테스트 코드에 추가하여야 함!
    @BeforeEach
    void setUp() {
        testSetting.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSetting.outputStream));
    }
     */

    public String getOutput() {
        return outputStream.toString();
    }

    public InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public InputStream createInputStream(List<String> inputs) {
        List<InputStream> streams = new ArrayList<>();

        for (String input : inputs) {
            streams.add(generateUserInput(input + "\n"));
        }

        return new SequenceInputStream(Collections.enumeration(streams));
    }
}
