package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.JTable;

import LN.clsRegistrado;


public class Tabla extends JTable implements ActionListener{
	
	private JTable table;
	private JButton botonSalir;
	private JFrame frame;

	// Modelo de datos propio
		private  MiTablaModelo datos;
		

		// [02] Renderers para alinear distinto que a la izquierda
		private static DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
		static{
			rendererCentrado.setHorizontalAlignment( JLabel.CENTER );
		}
		
		public Tabla( MiTablaModelo modelo ) {
			super(modelo);
			
			
			
	    	// Fijar tama�o preferido de la tabla
	        setPreferredScrollableViewportSize(new Dimension(500, 200));
	        // [02] Asignar renderers de alineación horizontal
	        getColumn("nombre").setCellRenderer( rendererCentrado );
	        getColumn("dni").setCellRenderer( rendererCentrado );
	        getColumn("sexo").setCellRenderer( rendererCentrado );
	        getColumn("Fecha").setCellRenderer( rendererCentrado );
	        getColumn("contrasena").setCellRenderer( rendererCentrado );
	        getColumn("edad").setCellRenderer( rendererCentrado );
	        
	        datos = new MiTablaModelo( clsRegistrado.nombreAtributos);
	        
//	    	try {
//				ResultSet rs = st.executeQuery("select * from PARTIDA where (nombreUsuario = '" + nombre + "')");
//				Object datuak [] = new Object[3];
//				
//				while(rs.next()){
//			    	for(int i=0; i<10; i++){
//			    		
//			    		//datuak[i] = rs.getObject(i+1);
//				    	datos.insertar( new Usuario( "ainhoa", null, 15, "2015/01/08") );
//			    	}
//		    	}
//				
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			    	
			    	
//			    	// Crear la tabla y el scrollpane
//			    	Ranking tabla = new Ranking(  );
//			        JScrollPane scrollPane = new JScrollPane( tabla );
//
//			        //Crear e inicializar la ventana con la tabla central
//			        frame = new JFrame("Demo de JTable");
//			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			        frame.add( scrollPane, "Center" );
			        
			        // Crear e inicializar la botonera
//			        JPanel botonera = new JPanel();
//			        botonSalir = new JButton( "Salir" );
//			        botonera.add( botonSalir );
//			        frame.add(botonera, "South");

			        
			        
//			        // Ajusta el tama�o de la ventana y la muestra
//			        frame.pack();
//			        frame.setVisible(true);
		}
		
		public void setModel( TableModel t ) {
			if (t instanceof MiTablaModelo)
				super.setModel( t );
			else
				throw new IncompatibleClassChangeError( "No se puede asignar cualquier modelo de datos a una JTable" );
		}
		
		public MiTablaModelo getMiTableModel() {
			return (MiTablaModelo) getModel();
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == botonSalir)
				frame.dispose();
				
		}
	

}
