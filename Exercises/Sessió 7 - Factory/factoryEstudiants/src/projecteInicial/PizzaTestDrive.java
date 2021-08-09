package projecteInicial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PizzaTestDrive {
 
	public static void main(String[] args) {

		Map<String, ArrayList<Usuari>> listUsuaris = new HashMap<>();
		ArrayList<Usuari> usus = new ArrayList<>();
		usus.add(new Usuari("jaleillo"));
		usus.add(new Usuari("tor"));
		listUsuaris.put("Armando Jaleo", usus);
		ArrayList<Usuari> list = listUsuaris.get("Armando Jaleo");
		for(Usuari c : list){
			System.out.println(c.getName());
		}
		//System.out.println(listUsuaris.get("Armando Jaleo"));


		/*PizzaStore store = new PizzaStore();

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);*/
	}
}
