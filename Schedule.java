import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Schedule
{
    private ArrayList<Flight> flights = new ArrayList<>();
    public int size = 0;
    private RandomAccessFile raf;

    public void add(Flight flight) throws IOException
    {
        flights.add(flight);
        size++;
        raf = new RandomAccessFile("schedule.dat", "rw");
        raf.seek(raf.length());
        raf.writeChars(flight.getFlightid());
        raf.writeChars(fixString(flight.getOrigin(), 9));
        raf.writeChars(fixString(flight.getDestination(), 12));
        raf.writeChars(flight.getDate());
        raf.writeChars(flight.getTime());
        raf.writeInt(flight.getPrice());
        raf.writeInt(flight.getSeats());
        raf.writeBoolean(flight.deleted);
        raf.close();
    }

    public void update(int index, Flight flight) throws IOException
    {
        flights.set(index, flight);
        raf = new RandomAccessFile("schedule.dat", "rw");
        raf.seek(index * 50);
        raf.writeChars(flight.getFlightid());
        raf.writeChars(fixString(flight.getOrigin(), 9));
        raf.writeChars(fixString(flight.getDestination(), 12));
        raf.writeChars(flight.getDate());
        raf.writeChars(flight.getTime());
        raf.writeInt(flight.getPrice());
        raf.writeInt(flight.getSeats());
        raf.writeBoolean(flight.deleted);
        raf.close();
    }

    public void delete(int index) throws IOException
    {
        flights.get(index).deleted = true;
        update(index, flights.get(index));
        flights.remove(index);
        size--;
    }

    public void print(int index)
    {
        if (index == -1) {
            System.out.format("|%-9s|%-9s|%-12s|%-11s|%-6s|%-10s|%-5s|\n",
                            "Flightid", "Origin", "Destination",
                            "Date", "Time", "Price", "Seats");
        } else {
            System.out.println(flights.get(index).toString());
        }
        System.out.println("..................................."
                            + "...................................");
    }

    public Flight read(int index) throws IOException
    {
        raf = new RandomAccessFile("schedule.dat", "r");
        raf.seek(index * 50);
        String flightid = fixRead(5);
        String origin = fixRead(9);
        String destination = fixRead(12);
        String date = fixRead(10);
        String time = fixRead(5);
        int price = raf.readInt();
        int seats = raf.readInt();
        Boolean deleted = raf.readBoolean();
        Flight flight = new Flight();
        flight.setFlightid(flightid);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDate(date);
        flight.setTime(time);
        flight.setPrice(price);
        flight.setSeats(seats);
        flight.deleted = deleted;
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

    public ArrayList<Flight> getFlights()
    {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights)
    {
        this.flights = flights;
    }
}
