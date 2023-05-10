import java.util.ArrayList;

public class Schedule
{
	ArrayList<String> FlightIds = new ArrayList<String>();
	ArrayList<String> Origins= new ArrayList<String>();
	ArrayList<String> Destinations = new ArrayList<String>();
	ArrayList<String> Dates = new ArrayList<String>();
	ArrayList<String> Times = new ArrayList<String>();
	ArrayList<Integer> Prices = new ArrayList<Integer>();
	ArrayList<Integer> Seats = new ArrayList<Integer>();

	private static String[] parts = { "FlightId", "Origin", "Destination",
		"Date", "Time", "Price", "Seats" };


	public void print()
	{
		String format = "|%-11s|%-11s|%-13s|%-12s|%-11s|%-11s|%-6s|\n";
		System.out.format(format, parts[0], parts[1], parts[2], parts[3],
				parts[4], parts[5], parts[6]);
		System.out.println("........................................."
				+ ".........................................");
		for (int i = 0; i < FlightIds.size(); i++)
		{
			System.out.format(format, FlightIds.get(i), Origins.get(i), 
					Destinations.get(i), Dates.get(i), Times.get(i),
					Prices.get(i), Seats.get(i));
			System.out.println("........................................."
					+ ".........................................");
		}
	}
}

