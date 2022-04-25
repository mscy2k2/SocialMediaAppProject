import java.util.Scanner;

public class PostItems {
	
	static Scanner scnr = new Scanner(System.in);
	static int userMember = 0;
	static String[] posts = new String[20];
	static String[] userNames = new String[20];
	static String[] passWords = new String[20];
	static int i;
	static int numPost = 0;
	static int userId = -1;
	
	public static void addPost() {
		String post = null;
		System.out.print("Enter post: ");
		post = scnr.next();
		posts[numPost] = post;
		++numPost;
	}

	public static void printPost() {
		for (i = 0; i < numPost; ++i) {
			System.out.println(posts[i] + " ");
		}
	}

	public static void searchPost() {
		String search = null;
		int locate = -1;
		System.out.print("Enter post word to search for: ");
		search = scnr.next();
		for (i = 0; i < userMember; ++i) {
			if (posts[i].equals(search)) {
				locate = i;
				System.out.println("found locator");
			}
		}
		if (locate == -1) {
			System.out.println("user input is wrong,locator not found");
		} else {
			userId = locate;
			System.out.println("The requested post is; " + posts[userId]);
		}
	}

	public static void deletePost() {
		String inputUser;
		String inputPassWord;
		int numPostDelete;
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
				System.out.print("Enter post number to be deleted: ");
				numPostDelete = scnr.nextInt();
				System.out.print("The actual post to be deleted: " + posts[numPostDelete]);
				posts[numPostDelete] = null;
				System.out.println("The post number entered is now deleted: " + posts[numPostDelete]);
			} else {
				System.out.print("not logged in");
			}
		}
	}

	public static void editPost() {
		String inputUser;
		String inputPassWord;
		int numPostEdit;
		String editPost;
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
				System.out.print("Enter post number to be edited: ");
				numPostEdit = scnr.nextInt();
				System.out.println(posts[numPostEdit]);
				System.out.print("Please edit the above displayed post: ");
				editPost = scnr.next();
				posts[numPostEdit] = editPost;
				System.out.println("The edited post is now: " + posts[numPostEdit]);
			} else {
				System.out.print("not logged in");
			}
		}

	}
}
