import processing.core.PApplet;
import processing.core.PImage;

public class Imagen implements Comparable<Imagen> {
	private PApplet app;
	private PImage imagen;
	private String nombre;
	private String tipoArchivo;
	private int ancho, alto;

	public Imagen(PApplet app, String nombre, String tipoArchivo) {
		this.app = app;
		this.nombre = nombre;
		this.tipoArchivo = tipoArchivo;
		//cargo una imagen que no se cual es pero que corresponde al nombre y al tipo
		imagen= app.loadImage("../data/"+nombre +"."+ tipoArchivo);
	}

	public int compareTo(Imagen o) {
		int compara = nombre.compareTo(o.nombre);
		return compara;
	}

	public PImage getImagen() {
		return imagen;
	}

	public void setImagen(PImage imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	

}
