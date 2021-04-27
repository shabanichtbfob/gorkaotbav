package LD;
 
import java.sql.*;
import javax.swing.JOptionPane;

import LN.clsMiExcepcionDni;


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;


public class BD {

	private static Connection connection=null;
	private static Statement statement=null;

	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */


	public Connection initBD(  ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:datubasea.db" );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	
	/** Cierra la conexión con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	

	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexion si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}
	
	/** Tablak sortu.*/
	
	//Creamos la tabla de jugadores que se registren
	public static void crearTablaJugador_R()
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Jugador_R(nom_JR string,dni_JR string,sexo string,fecha string,contrasena_JR string,  edad_JR string)");
			
	        JOptionPane.showMessageDialog(null, "Tabla de usuarios creada de forma exitosa");

		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
			
			if(!e.getMessage().equals(" table Jugador_R already exists"))
				 e.printStackTrace();
		}
	}
	
	//Modificar datos de usuario
	public static void modificarJugador_R (String nombre, String dni, String sexo,String fecha, String contraseña, String edad, Statement st) throws clsMiExcepcionDni
	{
		
		if(statement!=null){
			
			String sentencia = "UPDATE Jugador_R SET nom_JR='" + nombre+"', dni_JR='"+ dni+"', sexo='"+sexo+"', fecha='"+fecha+"', contrasena_JR='"+contraseña+"', edad_JR ='"+edad +"' WHERE dni_JR='"+ dni+"'";
			
			try {
				ResultSet sentencia1= st.executeQuery("SELECT * FROM Jugador_R");

				while(sentencia1.next()){		
					statement.executeUpdate(sentencia);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en la sentencia SQL" + sentencia);
	
				e.printStackTrace();
			}
		} 


	}

	//Partidak gordetzeko tabla bat sortuko digu
	public static void crearTablaPartida()
	{
		if (statement==null) return;
		try {
			//clsPartidan dauzkeun atributoakin tabla bat sortzen deu
			statement.executeUpdate("create table Partida(DNI_JR string, num_nivel String, num_Puntos integer)");
	        JOptionPane.showMessageDialog(null, "Tabla de partidos creada de forma exitosa");
	
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
			
			if(!e.getMessage().equals(" table Partida already exists"))
				 e.printStackTrace();
		}
	}
		
	/**Insert-ak in. 
	 * @throws SQLException */
	public static void insertInfor()
	{
		
		if(statement==null)
			System.out.println("Inicializa la base de datos");
		
		else{
			try {
				statement.executeUpdate("insert into Informacion values ('Las bases del juego " + " \n\nEl objetivo de este juego es conseguir alcanzar los puntos necesarios para pasar de un nivel a otro."
																+ " \n\nPara ello, tenemos que conseguir que la carita que aparece abajo en el centro se coloque alrededor de otro de su mismo estilo,"
																+ "\n\nasi conseguiremos que esas caritas se eliminen, consiguiendo 10 puntos por cada carita eliminada. Aparte de comprobar si la "
																+ "\n\ncarita que lanzamos choca con alguna de su estilo, en caso de que lo haga, a su vez comprobamos si alrededor de esta segunda carita existe"
																+"\n\nalguna del mismo estilo, para eliminarla. Este proceso se repetiria por cada carita igual que encontremos."
																+ "\n\nPara lanzar la bola del medio, tenemos que click-ar en la posicion en la cual queremos colocar la carita. La carita no se movera en caso de"
																+ "\n\nque click-emos en una posicion donde arriba de esta no exista ninguna carita, o encima de una carita ya colocada."
																+ "\n\nPuntos necesarios para pasar de nivel"
																+"\n\n Nivel 1 : 100 puntos"
																+"\n\n Nivel 2: 200 puntos"
																+"\n\n Nivel 3: 300 puntos"
																+ "\n\n\n MUCHA SUERTE! ')");
																
														
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Añadir jugador registrado
	public static void insertJugador_R (String nombre, String dni, String sexo,String fecha_inscrip, String contraseña, String edad,Statement st) throws clsMiExcepcionDni
	{
		//Hacemos trhows la excepcion que hemos creado, pero no hemos programado lo suficiente para que llegue a denegar el registro de una persona si ya existe un dni igual
		if(statement==null){
			System.out.println("gaizki!");
		}else{
			String sentencia = "INSERT INTO Jugador_R VALUES ( '" + nombre+"','"+ dni+"','"+sexo+"','"+fecha_inscrip+"','"+contraseña+"','"+edad +"')";
			try {
				statement.executeUpdate(sentencia);
		        JOptionPane.showMessageDialog(null, "Jugador insertado de forma exitosa");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
		        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	
				e.printStackTrace();
			}
		}
	}
	
	
	
	//Añadir partida jugada
	public static void insertPartida(String DNI_JR, String num_nivel, int num_Puntos, Statement st ) throws SQLException 
	{
		if(statement==null){
			System.out.println("No se ha podido realizar operacion SQL");
		}else{
			String sentencia1 = "INSERT INTO Partida VALUES ('"+ DNI_JR+ "','"+num_nivel+"', "+num_Puntos+")";		
				statement.executeUpdate(sentencia1);
			}	
	}
	
	//Metodo para cargar los jugadores de la base de datos
	public static ResultSet verJugadores(Statement st) {
			
		ResultSet rs=null ;
		try {
			//Statement stms = this.getStatement();
			rs = st.executeQuery("SELECT * FROM Jugador_R");		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"No se ha podido realizar operacion SQL");
			e.printStackTrace();
		}		
		return rs;
	}

	//Para coger los datos del usuario que coincida con el dni
	public static ResultSet verdniUsuario(String dni, Statement statement) 
	{
		ResultSet bueno=null;
		String sentencia1 = "SELECT * FROM Jugador_R WHERE dni_JR = '" + dni+ "'";
		try{
			ResultSet rs= statement.executeQuery(sentencia1);

				while(rs.next()){			
					if (rs.getString("dni_JR").equals(dni)) {
						
					
						bueno=rs;
						} else bueno=null;		
				}
		}catch (SQLException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(null, "No se ha podido realizar operacion SQL");				
			}
	
		return bueno;

	}
	
	//Para ver los datos de la partida que coincida con el dni de un usuario
	public static ResultSet verdniPartida(String dni, Statement statement) {
		String sentencia1 = "SELECT * FROM Partida WHERE DNI_JR ='" + dni+ "'";
		ResultSet bueno=null;
		
		try{		
			ResultSet rs= statement.executeQuery(sentencia1);
				while(rs.next()){			
					if (rs.getString("DNI_JR").equals(dni)) {
							bueno=rs;
							JOptionPane.showMessageDialog(null, bueno);
						} 	
				}
		}catch (SQLException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(null, "No se ha podido realizar operacion SQL");				
			}
	
		return bueno;
	}
	public static boolean verLogIn(String nombre, String contraseña, Statement sts) {
		boolean comprobacion=false;
	
		try{	
			ResultSet rs = sts.executeQuery ("SELECT nom_JR, contrasena_JR FROM Jugador_R");		
			while(rs.next()){			
				if (rs.getString("nom_JR").equals(nombre)) {
					if (rs.getString("contrasena_JR").equals(contraseña)) {
						comprobacion=true;
					} 
				}					

			}
			System.out.println(comprobacion);
		}catch (SQLException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(null, "No se ha podido realizar operacion SQL");				
			}
		return comprobacion;
	}					
}
	


