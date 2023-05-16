public class Flight
{
	private String flightid;
	private String origin;
	private String destination;
	private String date;
	private String time;
	private int price;
	private int seat;

	public Ticket()
	{
		this.flightid = "";
		this.origin = "";
		this.destination = "";
		this.date = "";
		this.time = "";
		this.price = 0;
		this.seat = 0;
	}

    public String getFlightid()
    {
        return flightid;
    }

    public String getOrigin()
    {
        return origin;
    }

    public String getDestination()
    {
        return destination;
    }

    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }

    public int getPrice()
    {
        return price;
    }

    public int getSeat()
    {
        return seat;
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

	public void setPrice(String price)
	{
		this.price = price;
	}

	public void setSeat(String seat)
	{
		this.seat = seat;
	}
}
