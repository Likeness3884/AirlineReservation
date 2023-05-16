import java.util.ArrayList;

public class Schedule
{
	private ArrayList<Flight> flights = new ArrayList<>();

    public ArrayList<Flight> getFlights()
    {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights)
    {
        this.flights = flights;
    }

    public void add();
    public void update(int index);
    public void delete(int index);
    public void print(int index);
}
