package examples.menu;

import java.util.ArrayList;

public class MenuComposite extends MenuComponent {

   // TO DO: a implementar els mètodes que calguin


    @Override
    public void print() {

        System.out.print(identado.toString() + "* " + getName() + "\n");
        //System.out.println(identado.toString() + "---------------------");
        identado.append("     ");
        for(MenuComponent menuComponent : menuComponents){
            menuComponent.print();
        }
        identado.setLength(identado.length() - 5);
    }
}
