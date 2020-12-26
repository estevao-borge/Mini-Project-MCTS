import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

class BoardTests {

	@Test
	void testBoard() {
		Board x = new Board();
		Board y = new Board();
		assertEquals(true , x.equals(y));	
	}

	@Test
	void testToString() {
		Board x = new Board();
		StringWriter writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		pw.print("- - -\n");
		pw.print("- - -\n");
		pw.print("- - -\n");
		assertEquals(x.toString() , writer.toString());	
	}
	@Test
	void testToString1() {
		Board x = new Board();
		x.play(0, 0);
		x.play(1, 1);
		x.play(2, 2);
		StringWriter writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		
		System.out.println(x);
		pw.print("- - -\n");
		pw.print("- - -\n");
		pw.print("- - -\n");
		assertEquals(x.toString() , writer.toString());	
	}
	
	
}
