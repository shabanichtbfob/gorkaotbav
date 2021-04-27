package LP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import LD.BD;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class frmVerUsuario extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCargar;
	private JLabel lblIntroduzcaSuDni;
	private JTextField txtDNI;
	private ResultSet resultUsuario = null;
	private ResultSet resultPartida = null;
	private JTable tableUsuarioo;
	private JTable tableJugadas;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	

	/**
	 * Create the frame.
	 */
	public frmVerUsuario() {
		setTitle("Datos del usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\carita1.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelUsuario = new JLabel("Datos de la cuenta del usuario:");
		lblDatosDelUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosDelUsuario.setBounds(10, 48, 210, 25);
		contentPane.add(lblDatosDelUsuario);
		
		JLabel lblDatosDeLas = new JLabel("Datos de las partidas jugadas: ");
		lblDatosDeLas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosDeLas.setBounds(224, 48, 210, 25);
		contentPane.add(lblDatosDeLas);
	
	
		btnCargar = new JButton("OK");
		btnCargar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCargar.setBackground(new Color(65, 105, 225));
		btnCargar.setBounds(351, 14, 61, 23);
		btnCargar.addActionListener(this);
		btnCargar.setActionCommand("Cargar");
		contentPane.add(btnCargar);
		
		lblIntroduzcaSuDni = new JLabel("Introduzca su DNI:");
		lblIntroduzcaSuDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntroduzcaSuDni.setBounds(41, 12, 171, 25);
		contentPane.add(lblIntroduzcaSuDni);
		
		txtDNI = new JTextField();
		txtDNI.setBackground(new Color(255, 255, 224));
		txtDNI.setBounds(236, 17, 86, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 84, 196, 137);
		
		
		tableUsuarioo = new JTable();
		scrollPane.setViewportView(tableUsuarioo);
		tableUsuarioo.setBackground(new Color(102, 205, 170));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(224, 84, 196, 137);
		
	
		
		tableJugadas = new JTable();
		scrollPane_1.setViewportView(tableJugadas);
		tableJugadas.setBackground(new Color(102, 205, 170));
		

		
	}
	
	private void crearTablaUsuario(String dni) {
		
		modelo = new DefaultTableModel();
		
		tableUsuarioo.setModel(modelo);
		
		Object[] object = new Object[] {"nom_JR", "dni_JR", "sexo","fecha","contrasena_JR" ,"edad_JR"};
		modelo.setColumnIdentifiers( object);
		
				
		//Para que ordene segun una columna
		TableRowSorter<TableModel> elqueordena = new TableRowSorter <TableModel>(modelo);
		//bd.getStatement();
		tableUsuarioo.setRowSorter(elqueordena);
		resultUsuario=BD.verdniUsuario(dni, BD.getStatement());
		
		
		
			// Bucle para cada resultado en la consulta
			if(resultUsuario!=null){
				try {
//					try {
//						while(rs.next()){
//							modelo.addRow(new Object[]{ rs.getString("nom_JR") , rs.getString("dni_JR") , rs.getString("sexo") , rs.getString("fecha") , rs.getString("contrasena_JR") , rs.getString("edad_JR") } );
//							
//						}
						while(resultUsuario.next()){
						modelo.addRow(new Object[]{ resultUsuario.getString("nom_JR") , resultUsuario.getString("dni_JR") , resultUsuario.getString("sexo") , resultUsuario.getString("fecha") , resultUsuario.getString("contrasena_JR") , resultUsuario.getString("edad_JR") } );
						}
						//System.out.println ("sartu da");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				contentPane.add(scrollPane);
				this.repaint();
				
			} else{
			
				JOptionPane.showMessageDialog(this, "Error en la carga de datos!");
				
				this.dispose();
			}
			

			

	}
	private void crearTablaPartida(String dni) {
		// TODO Auto-generated method stub
		modelo = new DefaultTableModel();
		
		tableJugadas.setModel(modelo);
		
		Object[] object = new Object[] {"DNI_JR", "num_nivel"," num_Puntos"};
		modelo.setColumnIdentifiers( object);
		
				
		//Para que ordene segun una columna
		TableRowSorter<TableModel> elqueordena = new TableRowSorter <TableModel>(modelo);
		//bd.getStatement();
		tableJugadas.setRowSorter(elqueordena);
		resultPartida=BD.verdniUsuario(dni, BD.getStatement());

			// Bucle para cada resultado en la consulta
			if(resultPartida!=null){
				try {
						modelo.addRow(new Object[]{ resultPartida.getString("DNI_JR") , resultPartida.getString("num_nivel") , resultPartida.getString("num_Puntos") } );

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
				contentPane.add(scrollPane_1);	
				this.repaint();
				
			} else{
			
				JOptionPane.showMessageDialog(this, "Error en la carga de datos!");
				this.dispose();
			}
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Cargar":
			
			
			String dni= txtDNI.getText();
			crearTablaUsuario(dni);
			crearTablaPartida(dni);
			
		}
	}

	
}
