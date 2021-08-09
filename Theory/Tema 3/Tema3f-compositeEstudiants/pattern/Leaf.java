package pattern;


public class Leaf extends Component {

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void doSomething() {
        System.out.println("    " + getName() + " doing something...");
    }
}
