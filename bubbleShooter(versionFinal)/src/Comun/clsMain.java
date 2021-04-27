package Comun;

import javax.swing.JOptionPane;

import LD.BD;
import LP.frmPrincipal;





public class clsMain {
	private static BD objBD= new BD();
	
	@SuppressWarnings("static-access")
	public static void main( String[] args){

		JOptionPane.showMessageDialog(null, "¡¡Bienvenido a FaceShooter 2.0!!");
		objBD.initBD();
		//Creamos primero las tablas
		objBD.crearTablaJugador_R();
		objBD.crearTablaPartida();
				
		frmPrincipal objprinci= new frmPrincipal();
		objprinci.setVisible(true);


	}
}
