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

public class Logica {
	private ArrayList<Imagen> imagenes;
	private TreeSet<Imagen> imagenesT;
	private LinkedList<Imagen> linkedList;
	private PApplet app;

	public Logica(PApplet app) {
		imagenes = new ArrayList<Imagen>();
		this.app = app;
	}

	public void pintar() {

	}

	private void cargarLista() {

		try {// intentar
			File file = new File("./nombres.txt");
			FileReader lector = new FileReader(file);// leer archivo
			BufferedReader leer = new BufferedReader(lector);// interpretar
																// archivo
			for (int i = 0; i < 20; i++) {
				String nombre = leer.readLine();
				Imagen ima = new Imagen(app, nombre, "");
				imagenes.add(ima);
			}

		} catch/* capturar */ (IOException e) {

			e.printStackTrace();
		}
	}

	private void ordenarNombreAscendente() {
		Collections.sort(imagenes);// para utilizar este ordenamiento debo
									// implementar en la clase Comparable

		// Ordenamiento con Comparator
		Comparator<Imagen> c = new Comparator<Imagen>() {

			@Override
			public int compare(Imagen o1, Imagen o2) {
				int compara = o1.getNombre().compareTo(o2.getNombre());
				
				return compara;
			}
		};
		
		Collections.sort(imagenes, c);
	}
	
	private void ordenarAltoAscendente(){
		Comparator<Imagen> c = new Comparator<Imagen>() {
			@Override
			public int compare(Imagen o1, Imagen o2) {
				int compara = 0;
				if(o1.getAlto()>o2.getAlto()){
					compara = 1;
				}else if(o1.getAlto()<o2.getAlto()){
					compara = -1;
				}
				return compara;
			}
		};
		
		Collections.sort(imagenes,c);
	}
	
	private void ordenarTreeSet(){
		Comparator<Imagen> c = new Comparator<Imagen>() {

			@Override
			public int compare(Imagen o1, Imagen o2) {
				int compara = o1.getNombre().compareTo(o2.getNombre());
				
				return compara;
			}
		};
		imagenesT = new TreeSet<>(imagenes);
	}
	private void ejemploLinkedList(){
		linkedList = new LinkedList<>();
		
		
	}

}
