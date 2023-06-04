public class Flight
{
    private String flightid;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private int price;
    private int seats;
    public Boolean deleted;

    public Flight()
    {
        this.flightid = "";
        this.origin = "";
        this.destination = "";
        this.date = "";
        this.time = "";
        this.price = 0;
        this.seats = 0;
        this.deleted = false;
    }

    public String toString()
    {
        return String.format("|%-9s|%-9s|%-12s|%-11s|%-6s|%-,10d|%-5d|",
                                flightid, origin, destination, date,
                                time, price * 1000, seats);
    }

    public String getFlightid()
    {
        return this.flightid;
    }

    public String getOrigin()
    {
        return this.origin;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getTime()
    {
        return this.time;
    }

    public int getPrice()
    {
        return this.price;
    }

    public int getSeats()
    {
        return this.seats;
    }

    public void setFlightid(String flightid)
    {
        this.flightid = flightid;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setSeats(int seats)
    {
        this.seats = seats;
    }
}
