import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	private PImage interfaz;
	private ArrayList<Imagen> imagenes;
	private PApplet app;
	private String[] nombreImagenes;
	int imgact = 0;
	boolean RotacionesA = false, RotacionesB = false, pantacom;

	public Logica(PApplet app) {
		imagenes = new ArrayList<Imagen>();
		this.app = app;
		cargarLista();
		interfaz = app.loadImage("interfaz.png");
	}

	public void pintar() {
		app.image(interfaz, 0, 0); // interfaz
		
		
		if (pantacom) {
			app.image(imagenes.get(imgact).getImagen(), 0, 0, app.displayWidth, app.displayHeight);
		} else if (RotacionesA) { // condicional para la rotacion A

			app.rotate((float) (Math.PI / 2));

			app.image(imagenes.get(imgact).getImagen(), 23, -870, 458, 280);
			app.rotate((float) (3 * Math.PI / 2));

		} else if (RotacionesB) { // condicional para la rotacion B
			app.rotate((float) (3 * Math.PI / 2));
			app.image(imagenes.get(imgact).getImagen(), -481, 590, 458, 280);
			app.rotate((float) (Math.PI / 2));
		} else {

			app.image(imagenes.get(imgact).getImagen(), 360, 21);
		}
		app.image(interfaz, 0, 0); // interfaz
	}

	public void aumentarAct() {
		imgact++;
	}

	private void cargarLista() { // cargamos la lista
		// despues de crear un arreglo de string que es uncontenedor de muchos
		// string o sea palabras cargo el txt
		nombreImagenes = app.loadStrings("../data/nombres.txt");
		// creo un for para leer el arreglo de string
		for (int i = 0; i < nombreImagenes.length; i++) {
			// creo un arreglo de string para separar el nombre de la imagen del
			// tipo de la imagen que esta en e txt
			String[] nImagen = nombreImagenes[i].split(" ");
			// creo todas las imagenes ,,,,,, 0 es el nombre como en pocision y
			// 1 es el tipo
			Imagen ima = new Imagen(app, nImagen[0], nImagen[1]);
			imagenes.add(ima);
		}
	}

	private void ordenarNombreAscendente() { // metodo para ordenar los nombres
		Collections.sort(imagenes);// para utilizar este ordenamiento debo
									// implementar en la clase Comparable

		// Ordenamiento con Comparator
		Comparator<Imagen> c = new Comparator<Imagen>() {

			public int compare(Imagen o1, Imagen o2) {
				int compara = o1.getNombre().compareTo(o2.getNombre());
				return compara;
			}
		};

		Collections.sort(imagenes, c);
	}

	private void ordenarAltoAscendente() { //ordenar el alto de manera ascendente
		Comparator<Imagen> c = new Comparator<Imagen>() {
			@Override
			public int compare(Imagen o1, Imagen o2) {
				int compara = 0;
				if (o1.getAlto() > o2.getAlto()) {
					compara = 1;
				} else if (o1.getAlto() < o2.getAlto()) {
					compara = -1;
				}
				return compara;
			}
		};

		Collections.sort(imagenes, c);
	}

}
