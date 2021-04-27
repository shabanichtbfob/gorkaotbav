package LN;

public class clsJugador {

	private String fecha_inscripci;
	private String nombre;
	private String sexo;
	private String dni;

	
	public clsJugador(String nombre, String dni, String sexo,String fecha_inscrip) {
			
			this.nombre= nombre;
			this.dni=dni;
			this.sexo=sexo;
			this.fecha_inscripci=fecha_inscrip;
			
		}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getFecha_inscripci() {
		return fecha_inscripci;
	}


	public void setFecha_inscripci(String fecha_inscripci) {
		this.fecha_inscripci = fecha_inscripci;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	
}
