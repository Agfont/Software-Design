package examples.menu;

public class MenuTestDrive {


    public static void main(String args[]) {

        MenuComponent meals      = new MenuComposite("Comidas");
        MenuComponent dinners    = new MenuComposite("Cenas");
        MenuComponent desserts   = new MenuComposite("Postres");
        MenuComponent mainCourse = new MenuComposite("Plato Fuerte");

        MenuComponent allMenus = new MenuComposite("Menus");

        allMenus.add(meals);
        allMenus.add(dinners);

        meals.add(mainCourse);
        meals.add(desserts);

        mainCourse.add(new MenuItem(
                        "Crispy Chicken",
                        false,
                        100.89)
        );
        
        desserts.add(new MenuItem(
                        "Apple Pie",
                        false,
                        15.59)
        );
        
        desserts.add(new MenuItem(
                        "Cheesecake",
                        false,
                        19.99)
        );        
        
        dinners.add(new MenuItem(
                        "Hotdogs",
                        false,
                        6.05)
        );
        
        dinners.add(new MenuItem(
                        "Spaghetti ",
                        true,
                        30.89)
        );


        //The client does not distinguish between item and composite
        Client client = new Client(allMenus);
        client.printMenu();

        // Output:
       /* * Menus
                * Comidas
                * Plato Fuerte
                    # Crispy Chicken,100.89
                * Postres
                    # Apple Pie,15.59
                    # Cheesecake,19.99
                * Cenas
                    # Hotdogs,6.05
                    # Spaghetti (v),30.89
       */


    }

}
