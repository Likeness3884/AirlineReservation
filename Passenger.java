import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Passenger
{
    private String name;
    private String pass;
    private int charge;
    private Schedule schedule = null;
    private ArrayList<String> tickets = new ArrayList<String>();
    private ArrayList<Integer> ticketIds = new ArrayList<Integer>();
    private String[] parts = { "FlightId", "Origin", "Destination",
                        "Date", "Time", "Price", "Seats" };
    private Random rand = new Random();
    private Scanner scanner = new Scanner(System.in);

    public Passenger(String name, String pass, Schedule schedule)
    {
        this.name = name;
        this.pass = pass;
        this.charge = 0;
        this.schedule = schedule;
    }

    public void init()
    {
        Boolean flag = true;
        while (flag)
        {
            System.out.println(
                  "\n"
                + "::::::::::::::::::::::::::::::\n"
                + "    PASSENGER MENU OPTIONS    \n"
                + "::::::::::::::::::::::::::::::\n"
                + " ............................ \n"
                + "\n"
                + "    <1> Change password\n"
                + "    <2> Search flight tickets\n"
                + "    <3> Booking ticket\n"
                + "    <4> Ticket cancellation\n"
                + "    <5> Booked tickets\n"
                + "    <6> Add charge\n"
                + "    <0> Sign out\n"
            );

            int choose = -1;
            Boolean bValid = false;
            while (!bValid)
            {
                try {
                    System.out.print("Enter your choose: ");
                    choose = scanner.nextInt();
                    System.out.println();
                    bValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Not a number!");
                    scanner.next();
                }
            }

            switch (choose)
            {
                case 1:
                    password();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    booking();
                    break;
                case 4:
                    cancel();
                    break;
                case 5:
                    tickets();
                    break;
                case 6:
                    charge();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Not a valid number!");
            }
        }
    }

    private void password()
    {
        System.out.print("Enter new password: ");
        this.pass = scanner.next();
        System.out.println();
    }

    private void search()
    {
        System.out.print("Enter Flightid: ");
        String inFlightid = scanner.next();
        System.out.println();

        int index = -1, i = 0;
        for (Flight flight : schedule.getFlights())
        {
            if (inFlightid.equals(flight.getFlightid()))
            {
                index = i;
                break;
            }
            i++;
        }

        if (index == -1)
        {
            System.out.println("Flightid not found!");
            return;
        }

        schedule.print(index);
    }

    private void booking()
    {
        System.out.print("Enter Flightid: ");
        String inFlightid = scanner.next();
        System.out.println();

        int price = 0;
        int index = -1, i = 0;
        Flight iFlight = null;
        for (Flight flight : schedule.getFlights())
        {
            if (inFlightid.equals(flight.getFlightid()))
            {
                index = i;
                iFlight = flight;
                break;
            }
            i++;
        }

        if (index < 0)
        {
            System.out.println("Flightid not found!");
            return;
        }

        price = iFlight.getPrice();
        int seats = iFlight.getSeats();
        if (seats <= 0)
        {
            System.out.println("Not enough seats!");
        }
        else if (charge < price)
        {
            System.out.println("Not enough money :/");
        }
        else
        {
            tickets.add(inFlightid);
            ticketIds.add(rand.nextInt(10000));
            charge -= price;
            iFlight.setSeats(--seats);
        }
    }

    private void cancel()
    {
        System.out.print("Enter Ticketid: ");
        int inTicketid= scanner.nextInt();
        System.out.println();

        int ticketIndex = ticketIds.indexOf(inTicketid);
        String inFlightid = tickets.get(ticketIndex);

        int price = 0;
        int index = -1, i = 0;
        for (Flight flight : schedule.getFlights())
        {
            if (inFlightid.equals(flight.getFlightid()))
            {
                index = i;
                price = flight.getPrice();
                break;
            }
            i++;
        }

        if (index == -1)
        {
            System.out.println("Ticketid not found!");
            return;
        }

        tickets.remove(index);
        ticketIds.remove(index);
        charge += price;
    }

    private void tickets()
    {
        for (int i = 0; i < tickets.size(); i++)
        {
            System.out.println("| " + tickets.get(i) + " | "
                            + ticketIds.get(i) + " |");
            System.out.println("........................................."
                            + "..........................................");
        }
    }

    private void charge()
    {
        Boolean bValid = false;
        while (!bValid)
        {
            try {
                System.out.print("Enter the amount: ");
                charge += scanner.nextInt();
                System.out.println();
                bValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Not a number!");
                scanner.next();
            }
        }
    }

    public String getName()
    {
        return this.name;
    }

    public String getPass()
    {
        return this.pass;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
