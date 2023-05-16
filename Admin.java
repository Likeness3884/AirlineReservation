public class Admin {
    private static String[] parts = { "Flightid", "Origin", "Destination",
                                      "Date", "Time", "Price", "Seats" };
    private String name;
    private String pass;
    private Schedule schedule;

    public Admin(String name, String pass, Schedule schedule) {
        this.name = name;
        this.pass = pass;
        this.schedule = schedule;
    }

    public void ShowMenu(Schedule schedule, Scanner scanner) {
        Boolean flag = true;
        while (flag) {
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

            System.out.print("Enter your choose: ");
            int choose = scanner.nextInt();
            System.out.println();

            switch (choose) {
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
            }
        }
    }

    private void add() {
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
        flight.setSeat(scanner.nextInt());
        schedule.add(flight);
    };

    private void update() {
        System.out.print("Enter Flightid: ");
        String inFlightid = scanner.next();

        int index = -1, i = 0;
        for (Flight flight : schedule.getFlights()) {
            if (inFlightid.equals(flight.getFlightid())) {
                index = i;
                break;
            }
            i++;
        }

        if (id >= 0) {
            Flight flight = new Flight();
            flight.setFlightid(inFlight);
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
            flight.setSeat(scanner.nextInt());
            schedule.update(id, flight);
        }
    }

    private void remove() {
        System.out.print("Enter Flightid: ");
        String inFlightid = scanner.next();

        int index = -1, i = 0;
        for (String flight : schedule.getFlights()) {
            if (inFlightid.equals(flight.getFlightid())) {
                index = i;
                break;
            }
            i++;
        }

        if (index >= 0) {
            schedule.delete(index);
        }
    }

    private void flightSchedules() {
        for (int i = -1; i < schedule.size; i++)
        {
            schedule.print(i);
        }
    }
}
