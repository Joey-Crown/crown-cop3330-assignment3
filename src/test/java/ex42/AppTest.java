package ex42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void getSalaryFromFile() {
        Assertions.assertTrue(App.getSalaryFromFile("src/main/java/ex42/exercise42_input.txt"));
        Assertions.assertFalse(App.getSalaryFromFile("src/main/java/ex42/doesnt_exist.txt"));
    }
}