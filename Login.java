import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Login
{
    private Scanner scanner = new Scanner(System.in);
    private Schedule schedule = new Schedule();
    private Admin admin = new Admin("Admin", "Admin", schedule);
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public Schedule getSchedule()
    {
        return schedule;
    }

    public void setSchedule(Schedule schedule)
    {
        this.schedule = schedule;
    }

    public void init()
    {
        Boolean flag = true;
        while (flag) {
            System.out.println(
                  "\n"
                + ":::::::::::::::::::::::::::::::::::::::::::::::\n"
                + "    WELCOME TO AIRLINE RESERVATION SYSTEM      \n"
                + ":::::::::::::::::::::::::::::::::::::::::::::::\n"
                + " ................MENU OPTIONS................. \n"
                + "\n"
                + "    <1> Sign in\n"
                + "    <2> Sign up\n"
                + "    <0> Exit\n"
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
                    signIn();
                    break;
                case 2:
                    signUp();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Not a valid number!");
            }
        }
    }

    private void signIn()
    {
        System.out.print("Enter Username: ");
        String inName = scanner.next();

        Boolean bFind = false;

        Boolean bAdmin = false;
        if (inName.equals(admin.getName()))
        {
            bFind = true;
            bAdmin = true;
        }

        int index = 0;
        for (Passenger passenger : passengers)
        {
            if (inName.equals(passenger.getName()))
            {
                bFind = true;
                break;
            }
            index++;
        }

        if (!bFind)
        {
            System.out.println("Username not found!");
            return;
        }

        System.out.print("Enter Password: ");
        String inPass = scanner.next();

        if (bAdmin)
        {
            if (inPass.equals(admin.getPass())) admin.init();
            else System.out.println("Password is wrong!");
            return;
        }
        else
        {
            if (inPass.equals(passengers.get(index).getPass()))
            {
                passengers.get(index).init();
            }
            else System.out.println("Password is wrong!");
        }
    }

    private void signUp()
    {
        System.out.print("Enter Username: ");
        String inName = scanner.next();

        if (inName.equals(admin.getName())) return;
        for (Passenger passenger : passengers)
        {
            if (inName.contentEquals(passenger.getName()))
            {
                System.out.println("Username already exist!");
                return;
            }
        }

        System.out.print("Enter Password: ");
        String inPass = scanner.next();

        Passenger passenger = new Passenger(inName, inPass, schedule);
        passengers.add(passenger);
    }
}
