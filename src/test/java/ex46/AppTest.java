package ex46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readFile() {
        String path = "src/main/java/ex46/exercise46_input.txt";
        Assertions.assertTrue(!App.readFile(path).isEmpty());
        Assertions.assertEquals(null, App.readFile("/test.txt"));
    }

    @Test
    void wordCounter() {
        String testString = "test test test test test test";
        Assertions.assertEquals(6, App.wordCounter(testString).get("test"));
    }
}