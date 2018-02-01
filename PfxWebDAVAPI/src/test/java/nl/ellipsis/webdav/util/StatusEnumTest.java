package nl.ellipsis.webdav.util;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.ellipsis.webdav.util.StatusEnum;
import nl.ellipsis.webdav.v1.DAVHeader;
import nl.ellipsis.webdav.v1.DAVStatus;

public class StatusEnumTest {
	
	private enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}

	@Test
	public void testString() {
		String s = "some-string";
		StatusEnum<String> e = StatusEnum.set(s);
		assertEquals(s,e.message);
		assertEquals(-1,e.code);
	}
	
	@Test
	public void testInt() {
		int i = 10;
		StatusEnum e = StatusEnum.set(i);
		assertEquals(Integer.toString(i),e.message);
		assertEquals(-1,e.code);
	}

	@Test
	public void testEnum() {
		StatusEnum<Day> e = StatusEnum.set(Day.MONDAY);
		assertEquals(Day.MONDAY.toString(),e.message);
		assertEquals(-1,e.code);
	}

	@Test
	public void testDAVHeader() {
		StatusEnum<DAVHeader> e = StatusEnum.set(DAVHeader.IF);
		assertEquals("If",e.message);
		assertEquals(-1,e.code);
	}

	@Test
	public void testDAVStatus() {
		StatusEnum<DAVStatus> e = StatusEnum.set(DAVStatus.LOCKED_423);
		assertEquals("Locked",e.message);
		assertEquals(423,e.code);
	}

}
