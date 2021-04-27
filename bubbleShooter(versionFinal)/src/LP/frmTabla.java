package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import LD.BD;
import LN.clsRegistrado;

public class frmTabla extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MiTablaModelo modelo;
	private String nombre;

	/**
	 * Create the frame.
	 */
	public frmTabla() {
		
		modelo = new MiTablaModelo(clsRegistrado.nombreAtributos);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 
		// Crear la tabla y el scrollpane
    	Tabla tabla = new Tabla( modelo );
        JScrollPane scrollPane = new JScrollPane( tabla );
        
		contentPane.add( scrollPane, "Center" );
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		this.RellenarTabla();
		
		this.pack();
	}


	public void RellenarTabla(){
		
//		try {
//			ResultSet rs = st.executeQuery("select * from PARTIDA where (nombreUsuario = '" + nombre + "')");
			clsRegistrado[] datuak = new clsRegistrado[100] ;
		
		BD gr = new BD();
		ResultSet rs = gr.verJugadores(BD.getStatement());
			try {
				while(rs.next()){


					 for(int i=0; i<100; i++){
				    		
				    		datuak[i] = (clsRegistrado) rs.getObject(i+1);
						
					    	//modelo.insertar( gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).get(i));
				    	}
					 
//				 for(int i=0; i<k; i++){
//			    		
//			    		//datuak[i] = rs.getObject(i+1);
//					
//				    	modelo.insertar( gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).get(i));
//			    	}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}


}
