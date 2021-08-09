package projecteInicial;

public class PizzaStore {
 
	public PizzaStore() { 
		
	}
 
	public Pizza orderPizza(String type) {

		FactoryPizza factoryPizza = new FactoryPizza();
		Pizza pizza = factoryPizza.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
