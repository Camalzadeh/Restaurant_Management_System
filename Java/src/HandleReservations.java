import java.util.Scanner;

public class HandleReservations {
    void start(Scanner scanner, Functions func) {
        System.out.println("""
                Handle reservations menu, Enter the specific number for options:
                Add Reservation (1)
                View Reservations (2)
                Cancel Reservation (3)
                Return main menu (4)""");
        int option = func.getResponse(4,scanner);
        switch (option) {
            case 1:
                addReservation(scanner,func);
                break;
            case 2:
                viewReservation(scanner,func);
                break;
            case 3:
                cancelReservation(scanner,func);
                break;
            case 4:
                Main.mainMenu(scanner,func);
                break;
            default: break;
        }
    }
    void addReservation(Scanner scanner, Functions func) {
        System.out.println("Add reservation menu, Enter the details of the reservation:");
        Main.Reservation addReservation = func.getResponseReservation(scanner);
        Main.reservations.add(addReservation);
        System.out.println("Reservation added successfully.");
        start(scanner,func);
    }
    void viewReservation(Scanner scanner, Functions func) {
        if(Main.reservations.isEmpty()){
            System.out.println("There are no reservations.");
            start(scanner,func);
        }
        for (int i = 0; i < Main.reservations.size(); i++) {
            System.out.printf("Item %d :", i+1);
            Main.reservations.get(i).printReservation();
        }
        start(scanner,func);
    }
    void cancelReservation(Scanner scanner, Functions func) {
        if(Main.reservations.isEmpty()){
            System.out.println("There are no reservations.");
            start(scanner,func);
        }
        System.out.println("Enter the id of the reservation you want to cancel:");
        int id = func.getResponse(Main.reservations.size(),scanner);
        Main.reservations.remove(id-1);
        System.out.println("Reservation cancelled successfully.");
        start(scanner,func);
    }
}
