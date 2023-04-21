import java.util.Scanner;

public class Admin {
	private Scanner scanner = new Scanner(System.in);

	public void ShowMenu() {
		System.out.println(
				  "::::::::::::::::::::::::::::::::::::::::\n"
				+ "          Admin MENUE OPTIONS           \n"
				+ "::::::::::::::::::::::::::::::::::::::::\n"
				+ " ......................................\n"
				+ "    <1> Add\n"
				+ "    <2> Update\n"
				+ "    <3> Remove\n"
				+ "    <4> Flight schedules\n"
				+ "    <0> Sign out\n"
		);
		System.out.println();

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
				break;
		}
	}

	private void Add() {};
	private void Update() {};
	private void Remove() {};
	private void FlightSchedules() {};
}
