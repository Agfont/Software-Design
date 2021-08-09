package projecteInicial;

public class MiniDuckSimulator {
 
	public static void main(String[] args) {
 
		MallardDuck	mallard = new MallardDuck();
		RubberDuck	rubberDuckie = new RubberDuck();
		DecoyDuck	decoy = new DecoyDuck();
 
		Duck	 model = new ModelDuck();

		mallard.display();
                mallard.fly();
                mallard.quack();
                
                rubberDuckie.display();
                rubberDuckie.fly();
		rubberDuckie.quack();
                
                decoy.display();
                decoy.fly();
		decoy.quack();
   
                model.display();
		model.fly();	
		model.quack();
	}
}
