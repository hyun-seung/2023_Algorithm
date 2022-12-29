import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greedy.거스름돈_14916;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 거스름돈Test {

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // System에 넣고자 하는 게 하나일 때 사용! 전체 Test가 끝나야 System이 비워짐
    private void setIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private String getOutput() {
        return outputStreamCaptor.toString();
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private InputStream createInputStream(List<String> inputs) {
        List<InputStream> streams = new ArrayList<>();

        for (String input : inputs) {
            streams.add(generateUserInput(input + "\n"));
        }

        return new SequenceInputStream(Collections.enumeration(streams));
    }

    private InputStream settingInputs() {
        List<String> inputs = List.of("13", "14", "-1");

        return createInputStream(inputs);
    }

    @ParameterizedTest
    @CsvSource(value = {"5", "4", "-1"}, delimiter = ':')
    public void test(String result) throws IOException {
        System.setIn(settingInputs());

        거스름돈_14916 test = new 거스름돈_14916();
        test.main(new String[]{});

        Assertions.assertEquals(result, getOutput());
    }
}
