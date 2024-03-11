import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {


    @Test
    @DisplayName("Test add and get methods")
    void addTest()
    {
        CustomArrayList<String> testList = new CustomArrayList<>();
        String firstStr = "first string";
        String secondStr = "second string";
        String thirdString = "third string";

        testList.add(firstStr);
        assertEquals(1, testList.size());
        testList.add(secondStr);
        assertEquals(2, testList.size());
        testList.add(thirdString);
        assertEquals(3, testList.size());

        String expected = firstStr;
        String actual = testList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test add by index method")
    void addByIndexTest()
    {
        CustomArrayList<String> testList = new CustomArrayList<>();
        String firstStr = "first string";
        String secondStr = "second string";
        String thirdString = "third string";
        String newStr = "new string";
        testList.add(firstStr);
        testList.add(secondStr);
        testList.add(thirdString);
        testList.add(2, newStr);

        String expected = newStr;
        String actual = testList.get(2);

        assertEquals(4, testList.size());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test add by index method with exception")
    void addWithExTest()
    {
        CustomArrayList<String> testList = new CustomArrayList<>();
        String firstStr = "first string";
        testList.add(firstStr);

        assertThrows(IndexOutOfBoundsException.class, () -> testList.add(2, firstStr));
    }

    @Test
    @DisplayName("Test get method with exception")
    void getWithExTest()
    {
        CustomArrayList<String> testList = new CustomArrayList<>();
        String firstStr = "first string";
        testList.add(firstStr);

        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(1));
    }

    @Test
    @DisplayName("Test remove method")
    void removeTest() {
        CustomArrayList<String> testList = new CustomArrayList<>();
        String firstStr = "first string";
        String secondStr = "second string";
        String thirdString = "third string";

        testList.add(firstStr);
        testList.add(secondStr);
        testList.add(thirdString);
        testList.remove(1);

        String expected = thirdString;
        String actual = testList.get(1);

        assertEquals(2, testList.size());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test remove method with exception")
    public void removeWithExTest()
    {
        CustomArrayList<String> testList = new CustomArrayList<>();
        String firstStr = "first string";
        testList.add(firstStr);

        assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(1));
    }

    @Test
    @DisplayName("Test clear method")
    void clearTest() {
        CustomArrayList<String> testList = new CustomArrayList<>();
        String firstStr = "first string";
        String secondStr = "second string";
        String thirdString = "third string";
        testList.add(firstStr);
        testList.add(secondStr);
        testList.add(thirdString);
        testList.clear();

        int expectedCapacity = 1;
        int actualCapacity = testList.size();
        String expectedValue = testList.get(0);

        assertEquals(expectedCapacity, actualCapacity);
        assertNull(expectedValue);
    }

    @Test
    @DisplayName("Quick sort test")
    void quickSortTest()
    {
        CustomArrayList<Book> testList = new CustomArrayList<>();
        Book java = new Book("Java", "Smith", 500);
        Book python = new Book("Python", "Norman", 200);
        Book sql = new Book("SQL", "Brandon", 400);
        Comparator<Book> byPrice = Comparator.comparing(Book::getPrice);

        testList.add(java);
        testList.add(python);
        testList.add(sql);
        testList.quickSort(byPrice);

        Book actualFirstBook = testList.get(0);
        Book actualSecondBook = testList.get(1);
        Book actualThirdBook = testList.get(2);

        assertEquals(java, actualFirstBook);
        assertEquals(sql, actualSecondBook);
        assertEquals(python, actualThirdBook);
    }
}