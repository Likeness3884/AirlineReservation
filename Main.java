import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	/* ================================================================ */
	//public static Admin admin = new Admin("Admin", "Admin");
	public static ArrayList<Passenger> passengers = new ArrayList<Passenger>();

	public static ArrayList<String> userNames = new ArrayList<String>();
	public static ArrayList<String> userPasses = new ArrayList<String>();

	public static ArrayList<String> FlightIds = new ArrayList<String>();
	public static ArrayList<String> Origins= new ArrayList<String>();
	public static ArrayList<String> Destinations = new ArrayList<String>();
	public static ArrayList<String> Dates = new ArrayList<String>();
	public static ArrayList<String> Times = new ArrayList<String>();
	public static ArrayList<Integer> Prices = new ArrayList<Integer>();
	public static ArrayList<Integer> Seats = new ArrayList<Integer>();

	private static Scanner scanner = new Scanner(System.in);
	/* ================================================================ */

	public static void main(String[] args) {
		//Welcome welcome = new Welcome();
		Home home = new Home();

		// set default values
		userNames.add("Admin");
		userPasses.add("Admin");

		FlightIds.add("WX-12");FlightIds.add("WX-15");FlightIds.add("BG-22");
		Origins.add("Yazd");Origins.add("Mashhad");Origins.add("Shiraz");
		Destinations.add("Tehran");Destinations.add("Ahvaz");Destinations.add("Tabriz");
		Dates.add("1401-12-10");Dates.add("1401-12-11");Dates.add("1401-12-12");
		Times.add("12:30");Times.add("08:00");Times.add("22:30");
		Prices.add(700);Prices.add(900);Prices.add(1100);
		Seats.add(51);Seats.add(245);Seats.add(12);
		// ==================

		//Passenger passenger = new Passenger("qw", "12");
		//passengers.add(passenger);

		/*
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
					int index = welcome.signIn();
					if (index >= -1) {
						if (index == -1) admin.ShowMenu();
						else passengers.get(index).ShowMenu();
					}
					break;
				case 2:
					welcome.signUp();
					break;
			}
		}
		*/
		home.ShowMenu();
	}
}

/*
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

	public int signIn() {
		System.out.print("Username: ");
		String userName = scanner.next();

		Boolean bFind = false;

		Boolean bAdmin = false;
		if (userName.equals(Main.admin.name)) {
			bAdmin = true;
			bFind = true;
		}

		int userIndex = 0;
		for (Passenger passenger : Main.passengers) {
			if (userName.equals(passenger.name)) {
				bFind = true;
				break;
			}
			userIndex++;
		}

		if (!bFind) return -2;

		System.out.print("Password: ");
		String userPass = scanner.next();

		if (bAdmin) {
			if (userPass.equals(Main.admin.pass)) return -1;
		}
		else if (bFind)
		{
			if (userPass.equals(Main.passengers.get(userIndex).pass)) {
				return userIndex;
			}
		}
		return -2;
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
		Passenger passenger = new Passenger(userName, userPass);
		Main.passengers.add(passenger);
	}
}
*/
