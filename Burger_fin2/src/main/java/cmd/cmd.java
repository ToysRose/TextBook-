package cmd;

import java.io.IOException;

public class cmd {
	
	public static void cmdSkip() {	
	try {
		new ProcessBuilder(
				"cmd", "/c", "cls").inheritIO().start().waitFor();
	} catch (InterruptedException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
