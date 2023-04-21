import java.util.Scanner;

public class Admin {
	String name;
	String pass;
	private Scanner scanner = new Scanner(System.in);
	private static String[] parts = { "FlightId", "Origin", "Destination", 
									  "Date", "Time", "Price", "Seats" };

	Admin(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public void ShowMenu() {
		Boolean flag = true;
		while (flag) {
			System.out.println(
					  "\n"
					+ "::::::::::::::::::::::::::::::::::::::::\n"
					+ "          Admin MENUE OPTIONS           \n"
					+ "::::::::::::::::::::::::::::::::::::::::\n"
					+ " ...................................... \n"
					+ "    <1> Add\n"
					+ "    <2> Update\n"
					+ "    <3> Remove\n"
					+ "    <4> Flight schedules\n"
					+ "    <0> Sign out\n"
			);

			System.out.print("Enter your choose: ");
			int choose = scanner.nextInt();
			System.out.println();

			switch (choose) {
				case 1:
					Add();
					break;
				case 2:
					Update();
					break;
				case 3:
					Remove();
					break;
				case 4:
					FlightSchedules();
					break;
				case 0:
					flag = false;
					break;
			}
		}
	}

	private void Add() {
		System.out.print("Enter " + parts[0] + ": ");
		Main.FlightIds.add(scanner.next());
		System.out.print("Enter " + parts[1] + ": ");
		Main.Origins.add(scanner.next());
		System.out.print("Enter " + parts[2] + ": ");
		Main.Destinations.add(scanner.next());
		System.out.print("Enter " + parts[3] + ": ");
		Main.Dates.add(scanner.next());
		System.out.print("Enter " + parts[4] + ": ");
		Main.Times.add(scanner.next());
		System.out.print("Enter " + parts[5] + ": ");
		Main.Prices.add(scanner.next());
		System.out.print("Enter " + parts[6] + ": ");
		Main.Seats.add(scanner.nextInt());
	};

	private void Update() {
        System.out.print("Enter FlightId: ");
        String userInput = scanner.next();

        int id = -1, i = 0;
        for (String flightId : Main.FlightIds) {
            if (userInput.contentEquals(flightId)) {
                id = i;
                break;
            }
			i++;
        }

        if (id >= 0) {
            System.out.print("Enter " + parts[1] + ": ");
            Main.Origins.set(id, scanner.next());
            System.out.print("Enter " + parts[2] + ": ");
            Main.Destinations.set(id, scanner.next());
            System.out.print("Enter " + parts[3] + ": ");
            Main.Dates.set(id, scanner.next());
            System.out.print("Enter " + parts[4] + ": ");
            Main.Times.set(id, scanner.next());
            System.out.print("Enter " + parts[5] + ": ");
            Main.Prices.set(id, scanner.next());
            System.out.print("Enter " + parts[6] + ": ");
            Main.Seats.set(id, scanner.nextInt());
        }
	}
	private void Remove() {
        System.out.print("Enter FlightId: ");
        String userInput = scanner.next();

        int id = -1, i = 0;
        for (String flightId : Main.FlightIds) {
            if (userInput.contentEquals(flightId)) {
                id = i;
                break;
            }
			i++;
        }

		if (id >= 0) {
			Main.FlightIds.remove(id);
			Main.Origins.remove(id);
			Main.Destinations.remove(id);
			Main.Dates.remove(id);
			Main.Times.remove(id);
			Main.Prices.remove(id);
			Main.Seats.remove(id);
        }
	}

	private void FlightSchedules() {
        String format = "|%-11s|%-11s|%-13s|%-12s|%-11s|%-11s|%-6s|\n";
        System.out.format(format, parts[0], parts[1], parts[2], parts[3], 
								parts[4], parts[5], parts[6]);
        System.out.println("......................................"
							+ ".............................................");
        for (int i = 0; i < Main.FlightIds.size(); i++) {
            System.out.format(format, Main.FlightIds.get(i), Main.Origins.get(i), 
								Main.Destinations.get(i), Main.Dates.get(i), 
								Main.Times.get(i), Main.Prices.get(i), Main.Seats.get(i)
			);
            System.out.println("............................................"
							+ ".......................................");
        }
	}
}
