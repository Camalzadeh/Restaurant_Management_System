import java.util.Scanner;
public class Functions {
    int getResponse(int n, Scanner scanner){
        int response;
        do{
            System.out.print("Enter a number: ");
            response = scanner.nextInt();
            if(response>n || response<0){
                System.out.println("Invalid response. Please try again.");
            }
        }while (response>n || response<0);
        return response;
    }
    Main.Menu getResponseMenuItem(Scanner scanner){
        Main.Menu response= new Main.Menu();
        while(true) {
            System.out.print("Enter name of the menu item: ");
            response.name = scanner.nextLine();
            if(response.name.isEmpty()) {
                System.out.println("Invalid input! Name cannot be empty.");
                continue;
            }
            System.out.print("Enter price of the menu item: ");
            response.price = scanner.nextDouble();
            scanner.nextLine();
            if(response.price < 0) {
                System.out.println("Invalid input! Price cannot be negative.");
                continue;
            }
            System.out.print("Enter category of the menu item (appetizer, main course, dessert): ");
            response.category = scanner.nextLine();
            if(!response.category.equals("appetizer") &&
                    !response.category.equals("main course") &&
                    !response.category.equals("dessert")) {
                System.out.println("Invalid input! Category must be 'appetizer', 'main course', or 'dessert'.");
                continue;
            }
            break;
        }
        return response;
    }
    Main.Reservation getResponseReservation(Scanner scanner){
        Main.Reservation response= new Main.Reservation();
        while(true) {
            System.out.print("Enter name of the reservation: ");
            response.name = scanner.nextLine();
            if(response.name.isEmpty()) {
                System.out.println("Invalid input! Name cannot be empty.");
                continue;
            }
            System.out.print("Enter date of the reservation in the format (dd.mm.yyyy): ");
            response.date = scanner.nextLine();
            if(!(response.date.matches("\\d{2}\\.\\d{2}\\.\\d{4}"))){
                System.out.println("Invalid input! Date is not in the correct format.");
                continue;
            }
            System.out.print("Enter time of the reservation in the format (hh:mm-hh:mm): ");
            response.time = scanner.nextLine();
            if(!(response.time.matches("\\d{2}:\\d{2}-\\d{2}:\\d{2}"))){
                System.out.println("Invalid input! Time is not in the correct format.");
                continue;
            }
            break;
        }
        return response;
    }
}

