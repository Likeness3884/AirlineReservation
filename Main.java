import java.util.ArrayList;

public class Main {
	/* ================================================================ */
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
	/* ================================================================ */

	public static void main(String[] args) {

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

		Home home = new Home();
		home.ShowMenu();
	}
}
