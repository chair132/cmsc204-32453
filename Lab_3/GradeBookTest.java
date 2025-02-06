import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook firstBook ,secondBook;
	@BeforeEach
	void setUp() throws Exception {
		firstBook = new GradeBook(5);
		firstBook.addScore(79);
		firstBook.addScore(92);
		firstBook.addScore(80);
		
		
		secondBook = new GradeBook(5);
		secondBook.addScore(50);
		secondBook.addScore(78);
		secondBook.addScore(97);
		secondBook.addScore(48);
	}

	@AfterEach
	void tearDown() throws Exception {
		firstBook = secondBook = null;
	}

	@Test
	void testAddScore() {
		
		assertTrue(firstBook.toString().equals("79.0 92.0 80.0 "));
		
		assertTrue(secondBook.toString().equals("50.0 78.0 97.0 48.0 "));
	}

	@Test
	void testSum() {
		assertEquals(firstBook.sum(), 251);
		assertEquals(secondBook.sum(), 273);
	}

	@Test
	void testMinimum() {
		assertEquals(firstBook.minimum(), 79);
		assertEquals(secondBook.minimum(), 48);
	}

	@Test
	void testFinalScore() {
		assertEquals(firstBook.finalScore(), 172);
		assertEquals(secondBook.finalScore(), 225);
		
	}

	@Test
	void testGetScoreSize() {
		assertEquals(firstBook.getScoreSize(), 3);
		assertEquals(secondBook.getScoreSize(), 4);
	}

	@Test
	void testToString() {
		assertTrue(firstBook.toString().equals("79.0 92.0 80.0 "));
		assertTrue(secondBook.toString().equals("50.0 78.0 97.0 48.0 "));
	}

}
