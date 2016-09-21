import processing.core.PApplet;

public class Main extends PApplet {
	PApplet app;
	Logica log;

	public void setup() {
		size(1200, 700);
		app = this;
		log = new Logica(app);

	}

	public void draw() {
		log.pintar();
	}

	public void mouseClicked() {

	}

	public void mouseWheel() {// scroll

	}

	public static void main(String[] args) {
		PApplet.main("Main");
	}

}
