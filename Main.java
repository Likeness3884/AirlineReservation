import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	/* ================================================================ */
	private static Scanner scanner = new Scanner(System.in);

	public static ArrayList<String> userNames = new ArrayList<String>();
	public static ArrayList<String> userPasses = new ArrayList<String>();

	public static ArrayList<String> FlightIds = new ArrayList<String>();
	public static ArrayList<String> Origins= new ArrayList<String>();
	public static ArrayList<String> Destinations = new ArrayList<String>();
	public static ArrayList<String> Dates = new ArrayList<String>();
	public static ArrayList<String> Times = new ArrayList<String>();
	public static ArrayList<String> Prices = new ArrayList<String>();
	public static ArrayList<Integer> Seats = new ArrayList<Integer>();
	/* ================================================================ */

	public static void main(String[] args) {
		Welcome welcome = new Welcome();
		Admin admin = new Admin();
		Passenger passenger = new Passenger();

		// set default values
		userNames.add("Admin");
		userPasses.add("Admin");

		FlightIds.add("WX-12");
		FlightIds.add("WX-15");
		FlightIds.add("BG-22");
		
		Origins.add("Yazd");
		Origins.add("Mashhad");
		Origins.add("Shiraz");
		
		Destinations.add("Tehran");
		Destinations.add("Ahvaz");
		Destinations.add("Tabriz");
		
		Dates.add("1401-12-10");
		Dates.add("1401-12-11");
		Dates.add("1401-12-12");
		
		Times.add("12:30");
		Times.add("08:00");
		Times.add("22:30");
		
		Prices.add("700,000");
		Prices.add("900,000");
		Prices.add("1,100,000");
		
		Seats.add(51);
		Seats.add(245);
		Seats.add(12);
		// ==================

		//admin.ShowMenu();
		//welcome.ShowMenu();
		//passenger.ShowMenu();

		while (true) {
			System.out.println(
				  "\n"
				+ ":::::::::::::::::::::::::::::::::::::::::::::::\n"
				+ "    WELCOME TO AIRLINE RESERVATION SYSTEM      \n"
				+ ":::::::::::::::::::::::::::::::::::::::::::::::\n"
				+ " ................MENU OPTIONS................. \n"
				+ "\n"
				+ "    <1> Sign in\n"
				+ "    <2> Sign up\n"
			);

			System.out.print("Enter your choose: ");
			int choose = scanner.nextInt();
			System.out.println();

			switch (choose) {
				case 1:
					String user = welcome.signIn();
					if (!user.equals("")) {
						if (user.equals("Admin")) admin.ShowMenu();
						else passenger.ShowMenu();
					}
					break;
				case 2:
					welcome.signUp();
					break;
			}
		}
    }
}

class Welcome {
	private Scanner scanner = new Scanner(System.in);

	public void ShowMenu() {
		while (true) {
			System.out.println(
				  "\n"
				+ ":::::::::::::::::::::::::::::::::::::::::::::::\n"
				+ "    WELCOME TO AIRLINE RESERVATION SYSTEM      \n"
				+ ":::::::::::::::::::::::::::::::::::::::::::::::\n"
				+ " ................MENU OPTIONS................. \n"
				+ "\n"
				+ "    <1> Sign in\n"
				+ "    <2> Sign up\n"
			);
			System.out.print("Enter your choose: ");

			int choose = scanner.nextInt();
			System.out.println();
			switch (choose) {
				case 1:
					signIn();
					break;
				case 2:
					signUp();
					break;
			}
		}
	}

	public String signIn() {
		System.out.print("Username: ");
		String userName = scanner.next();

		int userIndex = 0;
		Boolean bExist = false;
		for (String name : Main.userNames) {
			if (userName.contentEquals(name)) {
				bExist = true;
				break;
			}
			userIndex++;
		}
		if (!bExist) return "";

		System.out.print("Password: ");
		String userPass = scanner.next();

		if (userPass.contentEquals(Main.userPasses.get(userIndex)))
		{
			return userName;
		}
		return "";
	}

	public void signUp() {
		System.out.print("New Username: ");
		String userName = scanner.next();

		for (String name : Main.userNames) {
			if (userName.contentEquals(name)) {
				return;
			}
		}
		Main.userNames.add(userName);

		System.out.print("Password: ");
		String userPass = scanner.next();

		Main.userPasses.add(userPass);
	}
}
