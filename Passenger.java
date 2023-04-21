import java.util.Scanner;

public class Passenger {
	private Scanner scanner = new Scanner(System.in);
	String name;
	String pass;

	Passenger(String name, String pass) {
		this.name = name;
		this.pass = pass;
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

	private void ChangePassword() {};
	private void SearchFlightTickets() {};
	private void BookingTicket() {};
	private void TicketCancellation() {};
	private void BookedTickets() {};
	private void AddCharge() {};
}
