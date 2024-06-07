import java.util.Scanner;

public class ProcessOrders {
    void start(Scanner scanner, Functions func){
        System.out.println("""
                Order processing menu, Enter the specific number for options:
                Create Order (1)
                View Orders (2)
                Update Order (3)
                Finalize Order (4)
                Return main menu (5)""");
        int option = func.getResponse(5,scanner);
        switch (option) {
            case 1:
                createOrder(scanner, func);
                break;
            case 2:
                viewOrders(scanner, func);
                break;
            case 3:
                updateOrder(scanner, func);
                break;
            case 4:
                finalizeOrder(scanner, func);
                break;
            case 5:
                Main.mainMenu(scanner,func);
                break;
            default: break;
        }
    }
    void createOrder(Scanner scanner, Functions func){
        if(Main.menu.isEmpty()){
            System.out.println("There are no items in the menu");
            start(scanner, func);
        }
        System.out.println("Please enter the id of item you want in the menu: ");
        int id = func.getResponse(Main.menu.size(),scanner);
        System.out.println("Please enter the quantity of the item you want in the order: ");
        int quantity = func.getResponse(1000,scanner);
        Main.Order order = new Main.Order(Main.menu.get(id-1),quantity);
        while(true){
            System.out.printf("Please enter the id of item you want in the menu, if you want to stop please enter : %d \n",Main.menu.size()+1);
            id = func.getResponse(Main.menu.size()+1,scanner);
            if(id == Main.menu.size()+1){
                break;
            }
            System.out.println("Please enter the quantity of the item you want in the order: ");
            quantity = func.getResponse(1000,scanner);
            order.items.put(Main.menu.get(id-1),quantity);
        }
        Main.orders.add(order);
        System.out.println("Order created successfully");
        start(scanner, func);
    }
    void viewOrders(Scanner scanner, Functions func){
        if(Main.orders.isEmpty()){
            System.out.println("There are no orders");
            start(scanner, func);
        }
        int i=0;
        for(Main.Order order : Main.orders){
            i++;
            System.out.printf("Order ID %d: \n",i);
            order.printOrder();
        }
        start(scanner, func);
    }
    void updateOrder(Scanner scanner, Functions func){
        if(Main.orders.isEmpty()){
            System.out.println("There are no orders");
            start(scanner, func);
        }
        System.out.println("Please enter the id of order you want to update: ");
        int id = func.getResponse(Main.orders.size(),scanner);
        if(Main.orders.get(id-1).items.isEmpty()){
            System.out.println("There are no items in the order");
            start(scanner, func);
        }
        System.out.println("If you want to remove enter 1 to add enter 2");
        int ans = func.getResponse(2,scanner);
        if(ans==1){
            System.out.println("Please enter the id of the item you want to remove: ");
            int rem= func.getResponse(Main.orders.get(id-1).items.size(),scanner);
            Main.orders.get(id-1).items.remove(Main.orders.get(rem-1).items.entrySet().iterator().next().getKey());
        }
        if(ans==2){
            System.out.println("Please enter the id of the item you want to add to order: ");
            int num= func.getResponse(Main.menu.size(),scanner);
            System.out.println("Please enter the quantity of the item you want in the order: ");
            int q= func.getResponse(1000,scanner);
            Main.orders.get(id-1).addItem(Main.menu.get(num-1),q);
        }
        System.out.println("Order updated successfully");
        start(scanner, func);
    }
    void finalizeOrder(Scanner scanner, Functions func){
        if(Main.orders.isEmpty()){
            System.out.println("There are no orders");
            start(scanner, func);
        }
        System.out.println("Please enter the id of order you want to finalize: ");
        int id = func.getResponse(Main.orders.size(),scanner);
        Main.orders.get(id-1).ordered=true;
        System.out.println("Order finalized successfully");
        start(scanner, func);
    }
}
