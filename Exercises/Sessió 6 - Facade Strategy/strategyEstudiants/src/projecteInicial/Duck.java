package projecteInicial;

public abstract class Duck {
        public Duck() {
        }
	abstract void fly();
        abstract void quack();
        abstract void display();

        public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
