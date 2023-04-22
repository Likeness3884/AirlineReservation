import java.util.Scanner;

public class Home {
	private Scanner scanner = new Scanner(System.in);
	Admin admin = new Admin("Admin", "Admin");

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
					int index = signIn();
					if (index >= -1) {
						if (index == -1) admin.ShowMenu();
						else Main.passengers.get(index).ShowMenu();
					}
					break;
				case 2:
					signUp();
					break;
			}
		}
	}

	private int signIn() {
		System.out.print("Username: ");
		String userName = scanner.next();

		Boolean bFind = false;

		Boolean bAdmin = false;
		if (userName.equals(admin.name)) {
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
			if (userPass.equals(admin.pass)) return -1;
		}
		else if (bFind)
		{
			if (userPass.equals(Main.passengers.get(userIndex).pass)) {
				return userIndex;
			}
		}
		return -2;
	}

	private void signUp() {
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
