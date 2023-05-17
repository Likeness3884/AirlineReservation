import java.util.ArrayList;
import java.util.Random;

public class Passenger {
    private String name;
    private String pass;
    private int charge;
    private ArrayList<String> tickets = new ArrayList<String>();
    private ArrayList<Integer> ticketIds = new ArrayList<Integer>();
    private String[] parts = { "FlightId", "Origin", "Destination",
                        "Date", "Time", "Price", "Seats" };
    private Random rand = new Random();

    public Passenger(String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.charge = 0;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void ShowMenu(Schedule schedule, Scanner scanner) {
        Boolean flag = true;
        while (flag) {
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

            System.out.print("Enter number: ");
            int choose = scanner.nextInt();
            System.out.println();

            switch (choose) {
                case 1:
                    changePassword();
                    break;
                case 2:
                    searchFlightTickets();
                    break;
                case 3:
                    bookingTicket();
                    break;
                case 4:
                    ticketCancellation();
                    break;
                case 5:
                    bookedTickets();
                    break;
                case 6:
                    addCharge();
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }

    private void changePassword() {
        System.out.print("Enter new password: ");
        this.pass = scanner.next();
        System.out.println();
    }

    private void searchFlightTickets(Schedule schedule) {
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

        if (index >= 0) {
            schedule.print(index);
        }
    }

    private void bookingTicket(ArrayList<Flight> flights) {
        System.out.print("Enter Flightid: ");
        String inFlightid = scanner.next();
        System.out.println();

        int price = 0;
        int index = -1, i = 0;
        for (Flight flight : flights)
        {
            if (inFlightid.equals(flight.getFlightid()))
            {
                index = i;
                price = flight.getPrice();
                break;
            }
            i++;
        }

        if (index >= 0) {
            tickets.add(inFlightid);
            ticketIds.add(rand.nextInt(10000));
            charge -= price;
        }
    }

    private void ticketCancellation(ArrayList<Flight> flights) {
        System.out.print("Enter Ticketid: ");
        int inTicketid= scanner.nextInt();
        System.out.println();

        int index = ticketIds.indexOf(inTicketid);
        String inFlightid = tickets.get(index);

        int price = 0;
        int index = -1, i = 0;
        for (Flight flight : flights)
        {
            if (inFlightid.equals(flight.getFlightid()))
            {
                index = i;
                price = flight.getPrice();
                break;
            }
            i++;
        }

        if (index >= 0) {
            tickets.remove(index);
            ticketIds.remove(index);
            charge += price;
        }
    }

    private void bookedTickets()
    {
        for (int i = 0, i < tickets.size(), i++)
        {
            System.out.println("| " + tickets.get(i) + " | "
                            + ticketIds.get(i) + " |");
            System.out.println("........................................."
                            + ".........................................");
        }
    }

    private void addCharge() {
        System.out.print("Enter the amount: ");
        charge += scanner.nextInt();
        System.out.println();
    }
}
