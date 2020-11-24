import java.io.IOException;
import java.util.Scanner;

public class stackTest {

	public static void main(String[] args) throws IOException {
		arrayStack stacky = new arrayStack(1);

		/*
		 * stackRecord first = new stackRecord("Adam", 29); stackRecord second = new
		 * stackRecord("Roberto", 51); stackRecord third = new stackRecord("Hadi", 20);
		 * stackRecord fourth = getRecordIn();
		 */

		try {

			boolean looper = true;
			boolean goodName = false;
			boolean goodAge = false;
			boolean moreInput = true;
			// inserting into the stack
			/*
			 * stacky.put(first); stacky.put(second); stacky.put(third); stacky.remove();
			 * stacky.first(); // should print second, roberto stacky.put(fourth);
			 */
			// Scanner scanner = new Scanner(System.in);
			String action;
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (moreInput) {
				// Scanner scanner = new Scanner(System.in);

				System.out.println("Enter an action from the following list of actions : ");
				System.out.println("put | remove | first | size | toString | exit");
				String input = scanner.nextLine(); // reading input
				// String input = br.readLine();
				System.out.println("The input entered is : '" + input + "'");

				/*-----------------***PUT***------------------*/
				if (input.equals("put") || input.equals("Put") || input.equals("PUT")) {
					System.out.println("Enter an the name and age to put into the stack ");
					// stackRecord newRecord = getRecordIn();

					while (!(looper == true && goodName == true && goodAge == true)) { // one false loops

						/*-----------GETTING name----------*/
						// while (!goodName) {
						System.out.print("Enter a Name: ");
						String inputName = scanner.nextLine();
						if (!containsDigit(inputName)) {
							goodName = true;
						} else {
							goodName = false;
						}

						/*----------GETTING age----------*/
						// while (!goodAge) {
						System.out.print("Enter an age: ");
						String inputAge = scanner.nextLine(); // Scans the next token of the input as an int.
						if (!isInteger(inputAge)) {
							goodAge = true;
						} else {
							goodAge = false;
						}

						/*-------Checking if input is what I'm looking for, (String, Int)------*/
						if ((looper == true && goodName == true && goodAge == true)) {
							System.out.println("Good input... ");
							int intAge = Integer.parseInt(inputAge);
							stackRecord record = new stackRecord(inputName, intAge);
							stacky.put(record);

						} else {
							System.out.println("Bad input...Try again ");

						}
						/*--------User input is...--------*/
						System.out.println("Name is : " + inputName + " & Age is : " + inputAge);

					} // end of big while
						// reseting vars for next usage
					goodName = false;
					goodAge = false;
					System.out.println("-----------------------------------");

					/*-----------------***REMOVE***------------------*/
				} else if (input.equals("remove") || input.equals("Remove") || input.equals("REMOVE")) {
					System.out.println("Removing top");

					try {
						stacky.remove();
						System.out.println("-----------------------------------");
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Error : array out of bounds " + e.getMessage());
					}

					/*----------------***first***-----------------*/
				} else if (input.equals("first")) {
					try {
						stacky.first();
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Error : array out of bounds " + e.getMessage());
					}
					System.out.println("-----------------------------------");

					/*---------------***toString***----------------*/
				} else if (input.equals("toString") || input.equals("tostring")) {
					System.out.println("----------Stack contents-----------");
					stacky.toStringStack();
					System.out.println("|-----------------------------------|");

					/*-----------------***SIZE***------------------*/
				} else if (input.equals("size")) {
					System.out.println("The size of the stack is : " + stacky.getSize());
					System.out.println("-----------------------------------");

				}
				/*-----------------***EXIT***------------------*/
				else if (input.equals("exit")) {
					System.out.println("------------Exiting.....---------------");
					// br.close();
					break;
				}

				else { // cant find given command
					System.out.println("Error! '" + input + "' is not a valid command");
					System.out.println("-----------------------------------");
				}

			} // end of while

			System.out.println("\nThe contents of the stack are :");
			stacky.toStringStack();

			System.out.println("\nThe SIZE of the stack is :" + stacky.getSize());
		} // end of big try

		catch (stackException e) {
			System.out.println("Error : bad stack manipulation " + e.getMessage());
		}

	}

//shitty method
	private static stackRecord getRecordIn() {

		Scanner scan = new Scanner(System.in); // Reading from System.in

		boolean goodAge = false;
		boolean looper = false;
		boolean goodName = false;
		while (!(looper == true && goodName == true && goodAge == true)) { // one false loops

			/*--------------------GETTING name-----------------*/
			// while (!goodName) {
			System.out.print("Enter a Name: ");
			String inputName = scan.nextLine();
			if (!containsDigit(inputName)) {
				goodName = true;
			} else {
				goodName = false;
			}

			/*--------------------GETTING age------------------*/
			// while (!goodAge) {
			System.out.print("Enter an age: ");
			String inputAge = scan.nextLine(); // Scans the next token of the input as an int.
			if (!isInteger(inputAge)) {
				goodAge = true;
			} else {
				goodAge = false;
			}

			/*-------Checking if input is what I'm looking for, (String, Int)------*/
			if ((looper == true && goodName == true && goodAge == true)) {
				System.out.println("Good input... ");
				int intAge = Integer.parseInt(inputAge);
				stackRecord record = new stackRecord(inputName, intAge);
				return record;
			} else {
				System.out.println("Bad input...Try again ");

			}
			/*----------User input is...-----------*/
			System.out.println("Name is : " + inputName + " & Age is : " + inputAge);

		} // end of big while

		/*---------------END OF READING----------------*/
		return null;

	} // end of main

	/*---------------------HELPERS------------------------*/

	static boolean containsDigit(String inputString) {
		boolean containsDigit = false;

		if (inputString != null && !inputString.isEmpty()) {
			for (char c : inputString.toCharArray()) {
				if (containsDigit = Character.isDigit(c)) {
					break; // if counter a digit in arr of chars
				}
			} // end of for-loop
		}

		return containsDigit;
	} // end of method

	private static boolean isInteger(String inputString) {
		boolean isInteger = false;

		if (inputString != null && !inputString.isEmpty()) {
			for (char c : inputString.toCharArray()) {
				if (isInteger = !Character.isDigit(c)) {
					break; // if counter a non digit in arr of chars
				}
			} // end of for-loop
		}

		return isInteger;
	} // end of method

}// end of calss