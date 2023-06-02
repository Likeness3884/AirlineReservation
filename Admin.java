import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

public class Admin
{
    private String name;
    private String pass;
    private Schedule schedule = null;
    private static String[] parts = { "Flightid", "Origin", "Destination",
                                      "Date", "Time", "Price", "Seats" };
    private Scanner scanner = new Scanner(System.in);

    public Admin(String name, String pass, Schedule schedule)
    {
        this.name = name;
        this.pass = pass;
        this.schedule = schedule;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPass()
    {
        return this.pass;
    }

    public void ShowMenu()
    {
        Boolean flag = true;
        while (flag)
        {
            System.out.println(
                      "\n"
                    + "::::::::::::::::::::::::::::::::::::::::\n"
                    + "          Admin MENUE OPTIONS           \n"
                    + "::::::::::::::::::::::::::::::::::::::::\n"
                    + " ...................................... \n"
                    + "    <1> Add\n"
                    + "    <2> Update\n"
                    + "    <3> Remove\n"
                    + "    <4> Flight schedules\n"
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
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    flightSchedules();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Not a valid number!");
            }
        }
    }

    private void add()
    {
        Boolean bValid = false;
        while (!bValid)
        {
            try {
                Flight flight = new Flight();
                System.out.print("Enter " + parts[0] + ": ");
                flight.setFlightid(scanner.next());
                System.out.print("Enter " + parts[1] + ": ");
                flight.setOrigin(scanner.next());
                System.out.print("Enter " + parts[2] + ": ");
                flight.setDestination(scanner.next());
                System.out.print("Enter " + parts[3] + ": ");
                flight.setDate(scanner.next());
                System.out.print("Enter " + parts[4] + ": ");
                flight.setTime(scanner.next());
                System.out.print("Enter " + parts[5] + ": ");
                flight.setPrice(scanner.nextInt());
                System.out.print("Enter " + parts[6] + ": ");
                flight.setSeats(scanner.nextInt());
                schedule.add(flight);
                bValid = true;
            } catch (InputMismatchException | IOException e) {
                System.out.println("Not a number!");
                scanner.next();
            }
        }
    }

    private void update()
    {
        System.out.print("Enter Flightid: ");
        String inFlightid = scanner.next();

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

        Boolean bValid = false;
        while (!bValid)
        {
            try {
                Flight flight = new Flight();
                flight.setFlightid(inFlightid);
                System.out.print("Enter " + parts[1] + ": ");
                flight.setOrigin(scanner.next());
                System.out.print("Enter " + parts[2] + ": ");
                flight.setDestination(scanner.next());
                System.out.print("Enter " + parts[3] + ": ");
                flight.setDate(scanner.next());
                System.out.print("Enter " + parts[4] + ": ");
                flight.setTime(scanner.next());
                System.out.print("Enter " + parts[5] + ": ");
                flight.setPrice(scanner.nextInt());
                System.out.print("Enter " + parts[6] + ": ");
                flight.setSeats(scanner.nextInt());
                schedule.update(index, flight);
                bValid = true;
            } catch (InputMismatchException | IOException e) {
                System.out.println("Not a number!");
                scanner.next();
            }
        }
    }

    private void remove()
    {
        System.out.print("Enter Flightid: ");
        String inFlightid = scanner.next();

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

        schedule.delete(index);
    }

    private void flightSchedules()
    {
        for (int i = -1; i < schedule.size; i++)
        {
            schedule.print(i);
        }
    }
}
