import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] userNames = new String[10];
    private static String[] userPasses = new String[10];
    private static int userCount = 1;

    public static void main(String[] args) {
        userNames[0] = "Admin";
        userPasses[0] = "Admin";

        while (true) {
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
                            +"           WELCOME TO AIRELINE RESERVATION SYSTEM             \n"
                            +"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
                            +"..........................MENU OPTIONS........................\n"
                            +"\n"
                            +"    <1> Sign in\n"
                            +"    <2> Sign up\n");
            System.out.print("Enter your choose: ");

            int choose = scanner.nextInt();
            System.out.println();

            switch (choose) {
                case 1:
                    if (!DoSignIn()) continue;
                    break;
                case 2:
                    if (!DoSignUp()) continue;
                    break;
            }
            break;
        }
    }

    private static boolean DoSignIn() {
        System.out.print("Username: ");
        String userName = scanner.next();

        int userIndex = 0;
        Boolean bExist = false;
        for (int i = 0; i < userCount; i++) {
            if (userName.contentEquals(userNames[i])) {
                bExist = true;
                break;
            }
            userIndex++;
        }
        if (!bExist) return false;

        System.out.print("Password: ");
        String userPass = scanner.next();

        if (userPass.contentEquals(userPasses[userIndex]))
        {
            return true;
        }
        return false;
    }

    private static boolean DoSignUp() {
        System.out.print("New Username: ");
        String userName = scanner.next();

        for (int i = 0; i < userCount; i++) {
            if (userName.contentEquals(userNames[i])) {
                return false;
            }
        }
        userNames[userCount] = userName;

        System.out.print("Password: ");
        String userPass = scanner.next();

        userPasses[userCount] = userPass;

        userCount++;
        return true;
    }
}
