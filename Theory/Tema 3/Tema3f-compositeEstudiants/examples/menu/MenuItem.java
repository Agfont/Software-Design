/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.menu;

/**
 *
 * @author luisburgos
 */
public class MenuItem extends MenuComponent {

    private boolean vegetarian;
    private double price;

    public MenuItem(String name, boolean vegetarian, double price) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }


    // TO DO: a implementar els mètodes que calguin

    @Override
    public void print() {
        System.out.print(identado.toString() + "# " +  getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println("," + getPrice());
    }

}
