import java.util.Scanner;
public class ManageMenu {
    void start(Scanner scanner, Functions func){
        System.out.println("""
                Manage Menu, Enter the specific number for options:
                 Add menu item (1)
                 Display (2)
                 Formatting (3)
                 Update menu item (4)
                 Delete menu item (5)
                 Return main menu (6)""");
        int ans = func.getResponse(6,scanner);
        switch (ans){
            case 1:
                addMenuItem(scanner,func);
                break;
            case 2:
                display(scanner,func);
                break;
            case 3:
                formatting(scanner,func);
                break;
            case 4:
                updateMenuItem(scanner,func);
                break;
            case 5:
                deleteMenuItem(scanner,func);
                break;
            case 6:
                Main.mainMenu(scanner,func);
                break;
            default:
                break;
        }
    }
    void addMenuItem(Scanner scanner, Functions func){
        Main.Menu currentItem= func.getResponseMenuItem(scanner);
        Main.menu.add(currentItem);
        System.out.println("Menu item successfully added!");
        start(scanner,func);
    }
    void display(Scanner scanner, Functions func){
        if(Main.menu.isEmpty()){
            System.out.println("Menu is empty");
        }
        if(Main.format){
            for (int i = 0; i < Main.menu.size(); i++) {
                System.out.printf("Item %d: \n",(i+1));
                Main.menu.get(i).printMenu();
            }
        }else{
            System.out.println("Appetizers :");
            for (int i = 0; i < Main.menu.size(); i++) {
                if(Main.menu.get(i).category.equals("appetizer")){
                    System.out.printf("Item %d :", i+1);
                    Main.menu.get(i).printMenu();
                }
            }
            System.out.println("Main courses :");
            for (int i = 0; i < Main.menu.size(); i++) {
                if(Main.menu.get(i).category.equals("main course")){
                    System.out.printf("Item %d :", i+1);
                    Main.menu.get(i).printMenu();
                }
            }
            System.out.println("Desserts :");
            for (int i = 0; i < Main.menu.size(); i++) {
                if(Main.menu.get(i).category.equals("dessert")){
                    System.out.printf("Item %d :", i+1);
                    Main.menu.get(i).printMenu();
                }
            }
        }
        start(scanner,func);
    }
    void formatting(Scanner scanner, Functions func){
        Main.format=!Main.format;
        System.out.println("Menu format was changed.");
        start(scanner,func);
    }
    void updateMenuItem(Scanner scanner, Functions func){
        if(Main.menu.isEmpty()){
            System.out.println("Menu is empty");
            start(scanner,func);
        }
        System.out.println("Please enter the index of the item you would like to update:");
        int ans = func.getResponse(Main.menu.size(),scanner);
        System.out.println("Please update the element of item :");
        Main.menu.set(ans-1, func.getResponseMenuItem(scanner));
        System.out.println("Item updated successfully!");
        start(scanner,func);
    }
    void deleteMenuItem(Scanner scanner, Functions func){
        if(Main.menu.isEmpty()){
            System.out.println("Menu is empty");
            start(scanner,func);
        }
        System.out.printf("Please enter the index of the item you would like to delete:\nIf you want tox exit please enter %d",Main.menu.size());
        int ans = func.getResponse(Main.menu.size()+1,scanner);
        Main.menu.remove(ans-1);
        System.out.println("Item deleted successfully!");
        start(scanner,func);
    }
}
