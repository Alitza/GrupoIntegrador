import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	PApplet app;
	Logica log;
	int w = 1200, h = 700;
	boolean fullscreen = false;
	boolean zoomIn= false;
	boolean zoomOut= false;

	public void setup() {
		size(w, h);
		frame.setResizable(true);
		app = this;
		log = new Logica(app);

	}

	public void draw() {
		log.pintar();
	}

	public void mouseClicked() {
		//Zoom in 

			
			
		//Zoom Out 

		
		
		
			
		// full screen

		if (fullscreen) {
			frame.setSize(w, h);
			fullscreen = false;
			log.pantacom = false;

		} else if (mouseX >= 650 && mouseX <= 750 && mouseY >= 540 && mouseY <= 640) {
			frame.setSize(displayWidth, displayHeight);
			fullscreen = true;
			log.pantacom = true;

		}

		// boton_rotar Izq
		if (mouseX >= 840 && mouseX <= 940 && mouseY >= 540 && mouseY <= 640) {
			log.RotacionesA = false;
			log.RotacionesB = true;

		}
		// boton_rotar Der
		else if (mouseX >= 1020 && mouseX <= 1120 && mouseY >= 540 && mouseY <= 640) {
			log.RotacionesB = false;
			log.RotacionesA = true;

		} else {

			log.RotacionesB = false;
			log.RotacionesA = false;
			log.aumentarAct();

		}
			
	
		
System.out.println(mouseX); System.out.println(mouseY);

	}

	public void mouseWheel() {// scroll

	}

	public static void main(String[] args) {
		PApplet.main("Main");
	}

}