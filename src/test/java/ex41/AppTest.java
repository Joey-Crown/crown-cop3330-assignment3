/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Joseph Crown
 */
package ex41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AppTest {

    @Test
    void shouldPopulateListFromFile() {
        Assertions.assertTrue(App.populateListFromFile("src/main/java/ex41/exercise41_output.txt"));
        Assertions.assertFalse(App.populateListFromFile("src/test/java/ex41/fake_file.txt"));
    }

    @Test
    void shouldSortList() {
        List<Name> names = new ArrayList<Name>();
        names.add(new Name("Joseph", "Crown"));
        names.add(new Name("Doug", "Dimmadome"));
        names.add(new Name("Charlie", "Brown"));
        names.add(new Name("John", "Jacob"));

        Assertions.assertEquals("Brown", App.sortList(names).get(0).lastName);
        Assertions.assertEquals("Jacob", App.sortList(names).get(3).lastName);
    }
}