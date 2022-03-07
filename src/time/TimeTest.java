package time;

import static org.junit.Assert.assertTrue; 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalMillisecondsGood() {
		int milliseconds = Time.getTotalMilliseconds("05:05:05:009");
		assertTrue("The milliseconds were not calculated properly",
				milliseconds==18305009);
	}
	@Test
	void testGetTotalMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				() -> {Time.getTotalMilliseconds("10:00");});
	}
	@Test
	void testGetTotalMillisecondsBoundary() {
		int milliseconds = Time.getTotalMilliseconds("23:59:59:999");
		assertTrue("The milliseconds were not calculated properly",
				milliseconds==86399999);
	}
	
	/////////////////MILLISECOND/////////////
	@Test
	void testGetMillisecondsGood() {
		int milliseconds = Time.getMilliseconds("10:05:05:007");
		assertTrue("The milliseconds were not calculated properly",
				milliseconds==7);
	}
	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				() -> {Time.getTotalMilliseconds("05:007");});
	}
	@Test
	void testGetMillisecondsBoundary() {
		int milliseconds = Time.getMilliseconds("10:05:05:999");
		assertTrue("The milliseconds were not calculated properly",
				milliseconds==999);
	}

	/////////////////SECOND/////////////
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05:000");
		assertTrue("The seconds were not calculated properly",
				seconds==05);
	}
	@Test
	void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				() -> {Time.getSeconds("05");});
	}
	@Test
	void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("00:00:59:999");
		assertTrue("The seconds were not calculated properly",
				seconds==59);
	}

	///////////////MINUTE///////////////
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("08:25:05:000");
		assertTrue("The minutes were not calculated properly",
				minutes==25);
	}
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				() -> {Time.getTotalMinutes("25");});
	}
	@Test
	void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("00:59:59:999");
		assertTrue("The minutes were not calculated properly",
				minutes==59);
	}

	//////////////HOUR//////////////////
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:000", "05:15:15:000", "05:59:59:999" })
	void testGetTotalHoursGoodAndBoundary(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly",
				hours==5);
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				() -> {Time.getTotalHours("3");});
	}

}
