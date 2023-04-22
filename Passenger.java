import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Passenger {
	String name;
	String pass;
	int charge;
	ArrayList<String> tickets = new ArrayList<String>();
	ArrayList<Integer> ticketIds = new ArrayList<Integer>();
	private Scanner scanner = new Scanner(System.in);
	Random rand = new Random();
		String[] parts = { "FlightId", "Origin", "Destination", 
									  "Date", "Time", "Price", "Seats" };

	Passenger(String name, String pass) {
		this.name = name;
		this.pass = pass;
		this.charge = 0;
	}

	public void ShowMenu() {
		Boolean flag = true;
		while (flag) {
			System.out.println(
				  "\n"
				+ "::::::::::::::::::::::::::::::\n"
				+ "    PASSENGER MENU OPTIONS    \n"
				+ "::::::::::::::::::::::::::::::\n"
				+ " ............................ \n"
				+ "\n"
				+ "    <1> Change password\n"
				+ "    <2> Search flight tickets\n"
				+ "    <3> Booking ticket\n"
				+ "    <4> Ticket cancellation\n"
				+ "    <5> Booked tickets\n"
				+ "    <6> Add charge\n"
				+ "    <0> Sign out\n"
			);

			System.out.print("Enter your choose: ");
			int choose = scanner.nextInt();
			System.out.println();

			switch (choose) {
				case 1:
					ChangePassword();
					break;
				case 2:
					SearchFlightTickets();
					break;
				case 3:
					BookingTicket();
					break;
				case 4:
					TicketCancellation();
					break;
				case 5:
					BookedTickets();
					break;
				case 6:
					AddCharge();
					break;
				case 0:
					flag = false;
					break;
			}
		}
	}

	private void ChangePassword() {
		System.out.print("Enter new password: ");
		pass = scanner.next();
		System.out.println();
	}

	private void SearchFlightTickets() {
		System.out.print("Enter flight id: ");
		String id = scanner.next();
		System.out.println();

		int i = Main.FlightIds.indexOf(id);
		if (i >= 0) {
			String format = "|%-11s|%-11s|%-13s|%-12s|%-11s|%-11s|%-6s|\n";
			System.out.format(format, parts[0], parts[1], parts[2], parts[3], 
								parts[4], parts[5], parts[6]);
			System.out.println("......................................"
							+ ".............................................");
			System.out.format(format, Main.FlightIds.get(i), Main.Origins.get(i), 
								Main.Destinations.get(i), Main.Dates.get(i), 
								Main.Times.get(i), Main.Prices.get(i), 
								Main.Seats.get(i)
			);
		}
	}

	private void BookingTicket() {
		System.out.print("Enter flight id: ");
		String userId = scanner.next();
		System.out.println();

		int menuIndex = Main.FlightIds.indexOf(userId);
		if (menuIndex >= 0) {
			tickets.add(userId);
			ticketIds.add(rand.nextInt(10000));
			charge -= Main.Prices.get(menuIndex);
		}
	}

	private void TicketCancellation() {
		System.out.print("Enter the ticket id: ");
		int userId = scanner.nextInt();
		System.out.println();

		int index = ticketIds.indexOf(userId);
		if (index >= 0) {
			tickets.remove(index);
			ticketIds.remove(index);
			int menuIndex = Main.FlightIds.indexOf(tickets.get(index));
			charge += Main.Prices.get(menuIndex);
		}
	}

	private void BookedTickets() {
		String format = "|%-11s|%-11s|%-13s|%-12s|%-11s|%-11s|%-6s|\n";
		System.out.format(format, parts[0], parts[1], parts[2], parts[3], 
								parts[4], parts[5], parts[6]);
		System.out.println("......................................"
							+ ".............................................");
		for (int i = 0; i < tickets.size(); i++) {
			int index = Main.FlightIds.indexOf(tickets.get(i));
			System.out.format(format, Main.FlightIds.get(index), Main.Origins.get(index), 
								Main.Destinations.get(index), Main.Dates.get(index), 
								Main.Times.get(index), Main.Prices.get(index), 
								Main.Seats.get(index)
			);
			System.out.println("............................................"
							+ ".......................................");
        }
	}

	private void AddCharge() {
		System.out.print("Enter the amount: ");
		charge += scanner.nextInt();
		System.out.println();
	}
}
