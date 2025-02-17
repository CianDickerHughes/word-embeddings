package ie.atu.sw;

import java.util.*;

public class MainMeunPAGE {
	public static int meun() throws Exception {
		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println("************************************************************");
		System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
		System.out.println("*                                                          *");
		System.out.println("*          Similarity Search with Word Embeddings          *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");
		System.out.println(ConsoleColour.WHITE);
		System.out.println("(1) Specify Embedding File");
		System.out.println("(2) Similarity search & Save to File (default: oneSimilarityOut.txt)");
		System.out.println("(3) Similarity Search & Save to Map");
		System.out.println("(4) Save Similarity Search Map to File (default: multipleSimilarityOut.txt)");
		System.out.println("(5) Search for Word in Embedding File");
		System.out.println("(6) Which Embedding File being Used");
		System.out.println("(-1) Quit");

		Scanner input = new Scanner(System.in);

		// Output a menu of options and solicit text from the user
		int choice = 0;
	    boolean validInput = false;

	    while (!validInput) {
	        try {
	            System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
	            System.out.print("Select Option [1-?]> ");
	            choice = input.nextInt();
	            validInput = true; // Mark the input as valid if no exception occurs
	        } catch (InputMismatchException e) {
	            System.err.println("Invalid input. Please enter a number.");
	            input.next(); // Consume the invalid input to clear the scanner buffer
	        }
	    }

		if (choice != -1) {
			// You may want to include a progress meter in you assignment!
			System.out.print(ConsoleColour.YELLOW); // Change the colour of the console text
			int size = 100; // The size of the meter. 100 equates to 100%
			for (int i = 0; i < size; i++) { // The loop equates to a sequence of processing steps
				printProgress(i + 1, size); // After each (some) steps, update the progress meter
				Thread.sleep(10); // Slows things down so the animation is visible
			}
			System.out.println("\n");
		}
		System.out.println(ConsoleColour.WHITE);
		return choice;
	}

	/*
	 * Terminal Progress Meter ----------------------- You might find the progress
	 * meter below useful. The progress effect works best if you call this method
	 * from inside a loop and do not call System.out.println(....) until the
	 * progress meter is finished.
	 * 
	 * Please note the following carefully:
	 * 
	 * 1) The progress meter will NOT work in the Eclipse console, but will work on
	 * Windows (DOS), Mac and Linux terminals.
	 * 
	 * 2) The meter works by using the line feed character "\r" to return to the
	 * start of the current line and writes out the updated progress over the
	 * existing information. If you output any text between calling this method,
	 * i.e. System.out.println(....), then the next call to the progress meter will
	 * output the status to the next line.
	 * 
	 * 3) If the variable size is greater than the terminal width, a new line escape
	 * character "\n" will be automatically added and the meter won't work properly.
	 * 
	 * 
	 */
	public static void printProgress(int index, int total) {
		if (index > total)
			return; // Out of range
		int size = 50; // Must be less than console width
		char done = '/'; // Change to whatever you like.
		char todo = '-'; // Change to whatever you like.

		// Compute basic metrics for the meter
		int complete = (100 * index) / total;
		int completeLen = size * complete / 100;

		/*
		 * A StringBuilder should be used for string concatenation inside a loop.
		 * However, as the number of loop iterations is small, using the "+" operator
		 * may be more efficient as the instructions can be optimized by the compiler.
		 * Either way, the performance overhead will be marginal.
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append((i < completeLen) ? done : todo);
		}

		/*
		 * The line feed escape character "\r" returns the cursor to the start of the
		 * current line. Calling print(...) overwrites the existing line and creates the
		 * illusion of an animation.
		 */
		System.out.print("\r" + sb + "] " + complete + "%");

		// Once the meter reaches its max, move to a new line.
		if (done == total)
			System.out.println("\n");
	}

}
