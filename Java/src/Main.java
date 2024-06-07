import java.util.*;

public class Main
{
    static List<Menu> menu = new ArrayList<>();
    static boolean format=true;
    static List<Reservation> reservations = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    public static class Reservation{
        String name;
        String date;
        String time;
        void printReservation(){
            System.out.println("Name: "+name + " Date: " + date + " Time: " + time);
        }
    }
    public static class Menu{
        String name;
        double price;
        String category;
        void printMenu(){
            System.out.println("Name: " + name + " Price: " + price + " Category: " + category);
        }
    }
    public static class Order{
        Map<Menu,Integer> items;
        boolean ordered=false;
        public Order(Menu item, int quantity){
            items= new HashMap<>();
            items.put(item,quantity);
        }
        public void addItem(Menu item, int quantity){
            items.put(item,quantity);
        }
        public double totalPrice() {
            double total = 0.0;
            for (Map.Entry<Menu, Integer> entry : items.entrySet()) {
                Menu menu = entry.getKey();
                int quantity = entry.getValue();
                total += menu.price * quantity;
            }
            return total;
        }
        public void printOrder(){
            int i=0;
            for (Map.Entry<Menu, Integer> entry : items.entrySet()) {
                i++;
                Menu menu = entry.getKey();
                System.out.println(i+") Name: "+menu.name+" Price: "+menu.price+" Category: "+menu.category );
            }
            System.out.println(" Total price: "+totalPrice()+ " Ordered: " + ordered);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Functions func = new Functions();
        mainMenu(scanner,func);
    }
    static void mainMenu(Scanner scanner, Functions func) {
        System.out.println("""
                Main menu, Enter the specific number for options:
                 Manage Menu (1)
                 Handle Reservations (2)
                 Process Orders (3)
                 Exit (4)""");
        int ans = func.getResponse(5,scanner);
        switch (ans) {
            case 1:
                ManageMenu menu = new ManageMenu();
                menu.start(scanner,func);
                break;
            case 2:
                HandleReservations handleReservations = new HandleReservations();
                handleReservations.start(scanner,func);
                break;
            case 3:
                ProcessOrders processOrders = new ProcessOrders();
                processOrders.start(scanner,func);
                break;
            case 4:
                scanner.close();
                System.exit(0);
                break;
            default:
                break;
        }
    }
}