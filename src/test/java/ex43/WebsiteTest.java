package ex43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteTest {

    // Delete website files in directory before testing
    // only need one test function to do all tests
    @Test
    void createWebsiteAllTest() {
        File file = new File("src/test/java/ex43" + "/website/testdir");
        Assertions.assertTrue(Website.createWebsiteDirectory(file));
        File file2 = new File("src/test/java/ex43" + "/website/testdir");
        Assertions.assertFalse(Website.createWebsiteDirectory(file2));

        Assertions.assertTrue(Website.createWebsiteJS("src/test/java/ex43/website/testdir"));
        Assertions.assertFalse(Website.createWebsiteJS("src/test/java/ex43/website/awesomeco"));

        Assertions.assertTrue(Website.createWebsiteCSS("src/test/java/ex43/website/testdir"));
        Assertions.assertFalse(Website.createWebsiteCSS("src/test/java/ex43/website/awesomeco"));
    }

}