package LN;

	public class clsRegistrado extends clsJugador {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String contraseña;
	private String edad;
	public static String[]nombreAtributos = new String[] {"nombre", "dni","sexo", "Fecha", "contrasena", "edad"};

	
	public clsRegistrado(String nombre, String dni, String sexo,String fecha_inscrip, String contraseña, String edad) {
		
		super(nombre, dni, sexo, fecha_inscrip);
		this.contraseña= contraseña;
		this.edad= edad;
		
	}
	
	
	public clsRegistrado(String nombre, String dni, String sexo,String fecha_inscrip) {
		super(nombre, dni, sexo, fecha_inscrip);
		// TODO Auto-generated constructor stub
	}


	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		StringBuffer salida = new StringBuffer();
	
		salida.append("  El jugador se llama:" );
		salida.append(super.getNombre());
		salida.append(" \n" );
		salida.append(" \n" );
		
		salida.append("Tiene el DNI:" );
		salida.append(super.getDni());
		salida.append(" \n" );
		salida.append(" \n" );

		salida.append("Es:" );
		salida.append(super.getSexo());
		salida.append(" \n" );
		salida.append(" \n" );

		salida.append("La fecha en la que se inscribio:" );
		salida.append(super.getFecha_inscripci());
		salida.append(" \n" );
		salida.append(" \n" );

		salida.append("Su contraseña es:" );
		salida.append(this.contraseña);
		salida.append(" \n" );
		salida.append(" \n" );
		
		salida.append("Su edad es de: " );
		salida.append(this.edad);
		salida.append(" \n" );
		salida.append(" \n" );

		return salida.toString();
	}		
	
	
	

	public int getNumColumnas() {
		// TODO Auto-generated method stub
		return 3;
	}


	public Object getValor(int col) {
		// TODO Auto-generated method stub
		switch (col) {
	    	case 0: { return getNombre(); }
	    	case 1: { return this.getDni(); }
	    	case 2: { return this.getContraseña();}
	    	case 3: { return this.getEdad() ;}
	    	case 4: { return this.getFecha_inscripci() ;}
	    	case 5: { return this.getSexo(); }
	    	}
	
		return null;
	}


	public void setValor(Object value, int col) {
		// TODO Auto-generated method stub
		try {
	    	switch (col) {
	    	case 0: { this.setNombre((String) value); break; }
	    	case 1: { this.setContraseña((String) value); break; }
	    	case 2: { this.setDni((String) value); break; }
	    	case 3: { this.setEdad((String) value); break; }
	    	case 4: { this.setFecha_inscripci((String) value); break; }
	    	case 5: { this.setSexo((String) value); break; }
    	}
    	} catch (Exception e) {
    		// Error en conversi�n. Intentando asignar un tipo incorrecto
    		e.printStackTrace();
    	}
	}



		
}
