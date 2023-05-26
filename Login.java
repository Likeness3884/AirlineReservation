import java.util.ArrayList;
import java.util.Scanner;

public class Login {
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

    public void ShowMenu() {
        while (true) {
            System.out.println(
                  "\n"
                + ":::::::::::::::::::::::::::::::::::::::::::::::\n"
                + "    WELCOME TO AIRLINE RESERVATION SYSTEM      \n"
                + ":::::::::::::::::::::::::::::::::::::::::::::::\n"
                + " ................MENU OPTIONS................. \n"
                + "\n"
                + "    <1> Sign in\n"
                + "    <2> Sign up\n"
            );

            System.out.print("Enter your choose: ");
            int choose = scanner.nextInt();
            System.out.println();

            switch (choose) {
                case 1:
                    int index = signIn();
                    if (index >= -1) {
                        if (index == -1) admin.ShowMenu(schedule);
                        else passengers.get(index).ShowMenu(schedule);
                    }
                    break;
                case 2:
                    signUp();
                    break;
            }
        }
    }

    private int signIn() {
        System.out.print("Enter Username: ");
        String inName = scanner.next();

        Boolean bFind = false;

        Boolean bAdmin = false;
        if (inName.equals(admin.getName())) {
            bFind = true;
            bAdmin = true;
        }

        int index = 0;
        for (Passenger passenger : passengers) {
            if (inName.equals(passenger.getName())) {
                bFind = true;
                break;
            }
            index++;
        }

        if (!bFind) return -2;

        System.out.print("Enter Password: ");
        String inPass = scanner.next();

        if (bAdmin) {
            if (inPass.equals(admin.getPass())) return -1;
        }
        else if (bFind)
        {
            if (inPass.equals(passengers.get(index).getPass())) {
                return index;
            }
        }

        return -2;
    }

    private void signUp() {
        System.out.print("Enter Username: ");
        String inName = scanner.next();

        if (inName.equals(admin.getName())) return;
        for (Passenger passenger : passengers) {
            if (inName.contentEquals(passenger.getName())) {
                return;
            }
        }

        System.out.print("Enter Password: ");
        String inPass = scanner.next();

        Passenger passenger = new Passenger(inName, inPass);
        passengers.add(passenger);
    }
}
