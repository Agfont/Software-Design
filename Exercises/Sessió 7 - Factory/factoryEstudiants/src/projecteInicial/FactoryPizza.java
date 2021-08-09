package projecteInicial;

public class FactoryPizza {
    public Pizza createPizza(String pizza2) {
        Pizza pizza = null;
        switch (pizza2){
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            case "clam":
                pizza = new ClamPizza();
                break;
            case "veggie" :
                pizza = new VeggiePizza();
                break;
        }
        return pizza;
    }
}
