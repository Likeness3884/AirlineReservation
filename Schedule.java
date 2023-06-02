import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Schedule
{
    private ArrayList<Flight> flights = new ArrayList<>();
    public int size;
    private RandomAccessFile raf;

    public Schedule()
    {
        this.size = 0;
    }

    public ArrayList<Flight> getFlights()
    {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights)
    {
        this.flights = flights;
    }

    public void add(Flight flight) throws IOException
    {
        flights.add(flight);
        this.size++;
        raf = new RandomAccessFile("schedule.dat", "rw");
        raf.writeChars(flight.getFlightid());
        raf.writeChars(fixString(flight.getOrigin(), 9));
        raf.writeChars(fixString(flight.getDestination(), 12));
        raf.writeChars(flight.getDate());
        raf.writeChars(flight.getTime());
        raf.writeInt(flight.getPrice());
        raf.writeInt(flight.getSeats());
        raf.close();
    }

    public void update(int index, Flight flight) throws IOException
    {
        flights.set(index, flight);
        raf = new RandomAccessFile("schedule.dat", "rw");
        raf.seek(index * 49);
        raf.writeChars(flight.getFlightid());
        raf.writeChars(fixString(flight.getOrigin(), 9));
        raf.writeChars(fixString(flight.getDestination(), 12));
        raf.writeChars(flight.getDate());
        raf.writeChars(flight.getTime());
        raf.writeInt(flight.getPrice());
        raf.writeInt(flight.getSeats());
        raf.close();
    }

    public void delete(int index)
    {
        flights.remove(index);
        flights.get(index).deleted = true;
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
                            + "..........................................");
        }
        else
        {
            Flight flight = flights.get(index);
            System.out.format(format, flight.getFlightid(), flight.getOrigin(),
                            flight.getDestination(), flight.getDate(),
                            flight.getTime(), flight.getPrice(), flight.getSeats());
            System.out.println("........................................."
                            + "..........................................");
        }
    }

    public Flight read() throws IOException
    {
        raf = new RandomAccessFile("schedule.dat", "r");
        String flightid = fixRead(5);
        String origin = fixRead(9);
        String destination = fixRead(12);
        String date = fixRead(10);
        String time = fixRead(5);
        int price = raf.readInt();
        int seats = raf.readInt();
        Flight flight = new Flight();
        flight.setFlightid(flightid);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDate(date);
        flight.setTime(time);
        flight.setPrice(price);
        flight.setSeats(seats);
        raf.close();
        return flight;
    }

    private String fixString(String str, int len)
    {
        String tmp = str;
        while (tmp.length() < len)
        {
            tmp += " ";
        }
        return tmp.substring(0, len);
    }

    private String fixRead(int len) throws IOException
    {
        String str = "";
        for (int i = 0; i < len; i++)
        {
            str += raf.readChar();
        }
        return str.trim();
    }
}
