package LN;

import java.util.ArrayList;


public class clscarita {


	protected String nombre = ""; //El nombre que va a tener cada carita
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	protected int idCarita;
	@SuppressWarnings("rawtypes")
	protected ArrayList [][] estructura;
		
	
	public clscarita( double posX, double posY, double velocidad, String nombre) {
		super();
		//this.estructura=estructura;
		this.posX = posX;
		this.posY = posY;
		this.nombre = nombre;
		//this.idCarita = id;
	}

	// Eztakit nola itten den, baino karita bakoitzai id bat eta izen bat eman behar zaio....
	
	public void desaparecerCarita(){
		
	}
	

	public void disparo(){
		
	}
	
	
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPosX() {
		return posX;
	}



	public void setPosX(double posX) {
		this.posX = posX;
	}



	public double getPosY() {
		return posY;
	}



	public void setPosY(double posY) {
		this.posY = posY;
	}

	
	public double getId() {
		return idCarita;
	}



	public void setId(int id) {
		this.idCarita = id;
	}
	
	
	
}
