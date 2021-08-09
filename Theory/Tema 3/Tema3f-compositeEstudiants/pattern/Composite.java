package pattern;

import java.util.ArrayList;


public class Composite extends Component {

    private ArrayList<Component> components;

    public Composite(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void doSomething() {
        System.out.println(getName() + " doing something...");
        for(Component component : components){
            component.doSomething();
        }
    }
}
