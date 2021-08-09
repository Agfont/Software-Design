package projecteInicial;

public class FacadeClass {
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;
    DvdPlayer dvd;
    Amplifier amp;
    public FacadeClass() {
        projector = new Projector("Top-O-Line Projector", dvd);
        lights = new TheaterLights("Theater Ceiling Lights");
        screen = new Screen("Theater Screen");
        popper = new PopcornPopper("Popcorn Popper");
        dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
        amp = new Amplifier("Top-O-Line Amplifier");
    }

    public void posarPelicula() {
        popper.on();
        popper.pop();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);

        dvd.on();
        dvd.play("Star Wars: The Last Jedi");
    }
}
