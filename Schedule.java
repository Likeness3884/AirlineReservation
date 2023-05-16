import java.util.ArrayList;

public class Schedule
{
	private ArrayList<Flight> flights = new ArrayList<>();
    public int size;

    public ArrayList<Flight> getFlights()
    {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights)
    {
        this.flights = flights;
    }

    public Schedule()
    {
        this.size = 0;
    }

    public void add(Schedule schedule)
    {
        flights.add(schedule);
        this.size++;
    }

    public void update(int index, Flight flight)
    {
        flights.set(index, flight);
    }

    public void delete(int index)
    {
        flights.remove(index);
        this.size--;
    }

    public void print(int index)
    {
        String format = "|%-11s|%-11s|%-13s|%-12s|%-11s|%-11s|%-6s|\n";
        if (index == -1)
        {
            String[] parts = { "Flightid", "Origin", "Destination",
                            "Date", "Time", "Price", "Seats" };
            System.out.format(format, parts[0], parts[1], parts[2],
                            parts[3], parts[4], parts[5], parts[6]);
            System.out.println("........................................."
                            + ".........................................");
        }
        else
        {
            Flight flight = flights.get(index);
            System.out.format(format, flight.getFlightids(), flight.getOrigins(),
                            flight.getDestinations(), flight.getDates(),
                            flight.getTimes(), flight.getPrices(), flight.getSeats());
            System.out.println("........................................."
                            + ".........................................");
        }
    }
}
