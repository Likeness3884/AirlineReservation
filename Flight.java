public class Flight
{
	private String flightid;
	private String origin;
	private String destination;
	private String date;
	private String time;
	private int price;
	private int seat;

	public Flight()
	{
		this.flightid = "";
		this.origin = "";
		this.destination = "";
		this.date = "";
		this.time = "";
		this.price = 0;
		this.seat = 0;
	}

    public String toString()
    {
        String strInfo = "";
        strInfo += flightid;
        strInfo += origin;
        strInfo += destination;
        strInfo += date;
        strInfo += time;
        strinfo += price.toString();
        strInfo += seat.toString();
        return strInfo;
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

    public int getSeat()
    {
        return this.seat;
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

	public void setSeat(int seat)
	{
		this.seat = seat;
	}
}
