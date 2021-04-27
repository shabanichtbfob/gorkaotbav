package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import LD.BD;

public class frmUsuarioo extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private ResultSet rs=null;
	private JTable tabla;
	private DefaultTableModel modelo;
	/**
	 * Create the frame.
	 */
	public frmUsuarioo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita1.png"));
		setTitle("Informaci\u00F3n de los usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBackground(new Color(65, 105, 225));
		btnVolver.setBounds(233, 228, 122, 23);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("Volver");
		contentPane.add(btnVolver);
		
			
		
		
//		btnCargar = new JButton("Cargar Datos");
//		btnCargar.setFont(new Font("Tahoma", Font.BOLD, 11));
//		btnCargar.setBackground(new Color(65, 105, 225));
//		btnCargar.setActionCommand("Volver");
//		btnCargar.setBounds(87, 228, 122, 23);
//		btnCargar.addActionListener(this);
//		btnCargar.setActionCommand("Cargar");
//		contentPane.add(btnCargar);
		
		tabla = new JTable();
		tabla.setBounds(10, 11, 414, 191);
		
		crearTabla();
	
	}
	

	private void crearTabla() {
		
		modelo = new DefaultTableModel();
		
		tabla.setModel(modelo);
		
		Object[] object = new Object[] {"nom_JR", "dni_JR", "sexo","fecha","contrasena_JR" ,"edad_JR"};
		modelo.setColumnIdentifiers( object);
		
				
		//Para que ordene segun una columna
		TableRowSorter<TableModel> elqueordena = new TableRowSorter <TableModel>(modelo);
		//bd.getStatement();
		tabla.setRowSorter(elqueordena);
		rs=BD.verJugadores(BD.getStatement());
		
			// Bucle para cada resultado en la consulta
			if(rs!=null){
				try {
					while(rs.next()){
				
						modelo.addRow(new Object[]{ rs.getString("nom_JR") , rs.getString("dni_JR") , rs.getString("sexo") , rs.getString("fecha") , rs.getString("contrasena_JR") , rs.getString("edad_JR") } );
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JScrollPane sc= new JScrollPane(tabla);
				sc.setBounds(10, 11, 414, 191);
				contentPane.add(sc);
				this.repaint();
				
			} else{
			
				JOptionPane.showMessageDialog(this, "Error en la carga de datos!");
			}
			

			

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Volver":
			frmInfo objfrmInfo = new frmInfo();
			objfrmInfo.setVisible(true);
			this.dispose();
		
			break;
		case "Cargar":
		
	
				crearTabla();
			
			
			break;
			}
			
		
	}
}
