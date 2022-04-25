import java.util.Scanner;

//Social media application

public class SocialMediaApp extends PostItems{
	static Scanner scnr = new Scanner(System.in);
	static int userMember = 0;
	static String[] posts = new String[20];
	static String[] userNames = new String[20];
	static String[] passWords = new String[20];
	static int i;
	static int numPost = 0;
	static int userId = -1;

	public static void displayMenu() {
		
		int numFeature = 0;
			
		System.out.println("      _____       ");
		System.out.println("     /  _  |      ");
		System.out.println(" ___/  |_| |____  ");
		System.out.println("|               | ");
		System.out.println("|    OKADA      | ");
		System.out.println(" -----0----0----  ");
		System.out.println("                  ");
		System.out.println("WELCOME TO OKADA MEDIA PLATFORM");

		while (numFeature < 11) {
			System.out.print(
					"Enter menu option(1-10):\n (1)create account\n (2)Print user name and password\n (3)Add new Post\n (4)Print post\n (5)Print Ascii art\n (6)Login ID\n (7)Who is logged in\n (8)Search post\n (9)Delete post\n (10)Edit post\n (11)Exit app\n ");
			numFeature = scnr.nextInt();
			switch (numFeature) {
			case 1:
				createAccount();
				break;
			case 2:
				printUsernamesPassword();
				break;
			case 3:
				addPost();
				break;
			case 4:
				printPost();
				break;
			case 5:
				asciiArt();
				break;
			case 6:
				loginId();
				break;
			case 7:
				whoIsLogIn();
				break;
			case 8:
				searchPost();
				break;
			case 9:
				deletePost();
				break;
			case 10:
				editPost();
				break;
			default:
				unknown();
				break;
			}
		}
		System.out.println("Thank you and godbye.");
	}

	public static void main(String[] args) {
		displayMenu();
	}

	public static void unknown() {
		System.err.println("Unrecognized option");
	}

	public static void createAccount() {
		String userName;
		String passWord;
		int i;
		boolean isDigit = false; // password contains a digit
		boolean isCapital = false; // password contains a capital letter
		boolean isSmall = false; // password contains a small letter
		boolean isSymbol = false; // password contains a symbol from this group ('*','$','_')

		System.out.println("Enter userName: ");
		userName = scnr.next();
		System.out.println("password must be at least 8 characters long");
		System.out.println(
				"password must contain a small letter, capital letter, a digit, and a symbol from this group ('*','$','_')");

		while (!(isDigit && isCapital && isSmall && isSymbol)) {
			System.out.print("Enter password: ");
			passWord = scnr.next();

			if (passWord.length() < 8) {
				System.out.println("password is less than 8 characters long");
			}

			for (i = 0; i < passWord.length(); ++i) {
				if (passWord.length() >= 8) {
					if (Character.isDigit(passWord.charAt(i))) {
						isDigit = true;
					} else if (Character.isUpperCase(passWord.charAt(i))) {
						isCapital = true;
					} else if (Character.isLowerCase(passWord.charAt(i))) {
						isSmall = true;
					} else if (passWord.charAt(i) == '*') {
						isSymbol = true;
					} else if (passWord.charAt(i) == '$') {
						isSymbol = true;
					} else if (passWord.charAt(i) == '_') {
						isSymbol = true;
					}
				}
			}

			if (isDigit && isCapital && isSmall && isSymbol) {
				System.out.println("password is valid, because it conforms with the requirements stated above");
				System.out.println("You're good to go");
			} else
				System.out.println("password is invalid, please try another password.");
			userNames[userMember] = userName;
			passWords[userMember] = passWord;
			++userMember;
		}
	}

	public static void printUsernamesPassword() {
		for (i = 0; i < userMember; ++i) {
			System.out.println("username: " + userNames[i] + "  " + "password: " + passWords[i]);
		}
	}

	public static void asciiArt() {
		System.out.println("      _____       ");
		System.out.println("     /  _  |      ");
		System.out.println(" ___/  |_| |____  ");
		System.out.println("|               | ");
		System.out.println("|    OKADA      | ");
		System.out.println(" -----0----0----  ");
		System.out.println("                  ");
	}

	public static void loginId() {
		String inputUser;
		String inputPassWord;
		int locator = -1;
		System.out.print("Enter user ID: ");
		inputUser = scnr.next();
		for (i = 0; i < userMember; ++i) {
			if (userNames[i].equals(inputUser)) {
				locator = i;
				System.out.println("found locator");
			}
		}
		if (locator == -1) {
			System.out.print("user input is wrong,locator not found");
		} else {
			System.out.print("Enter password: ");
			inputPassWord = scnr.next();
			if (passWords[locator].equals(inputPassWord)) {
				System.out.println("Thank you, someone is logged in");
				userId = locator;
			} else {
				System.out.print("not logged in");
			}
		}

	}

	public static void whoIsLogIn() {
		System.out.println("The logged in user is; " + userNames[userId]);
	}


}
