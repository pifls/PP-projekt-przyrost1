import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnswerCheckTest {

    private AnswerCheck query_test;

    @Before
    public void setUp() {
        query_test = new AnswerCheck();
    }

    @Test
    public void correctTest1() {
        assertTrue(query_test.checkAnswer("SELECT id FROM Pracownicy WHERE stawka > 3600 ORDER BY id"));
    }
    @Test
    public void correctTest2() {
        assertTrue(query_test.checkAnswer("SELECT stawka FROM Projekty"));
    }
    @Test
    public void correctTest3() {
        assertTrue(query_test.checkAnswer("SELECT idProj FROM Projekty ORDER BY idProj"));
    }


    @Test
    public void incorrectTest1() {
        assertFalse(query_test.checkAnswer("SELECT id WHERE Pracownicy FROM stawka > 3600 ORDER BY id"));
    }
    @Test
    public void incorrectTest2() {
        assertFalse(query_test.checkAnswer("FROM Pracownicy SELECT id WHERE id == 2 ORDER BY id"));
    }
    @Test
    public void incorrectTest3() {
        assertFalse(query_test.checkAnswer("blablalvkdkkskdkod 12o32kok 4o ko4k okgfk orddk okk4of4 k"));
    }

}