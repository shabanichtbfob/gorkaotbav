package LP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;

import LD.BD;
import LN.clsMiExcepcionDni;

public class frmRegistrarse extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JLabel label_1;
	private JTextPane txtNombre;
	private JLabel label_2;
	private JTextPane txtContraseña;
	private JLabel label_3;
	private JTextPane txtDNI;
	private JLabel label_4;
	private JTextPane txtEdad;
	
	private ButtonGroup sexoGroup;
	private JRadioButton radioHombre ;
	private JRadioButton radioMujer;
	
	private Date fecha_inscrip;

	private BD objBD= new BD();
	private frmJugar objfrmJugar;
	
	
	/**
	 * Create the frame.
	 */
	public frmRegistrarse() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita8.png"));
		setTitle("Resgistrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Cancelar");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBackground(new Color(65, 105, 225));
		btnVolver.setBounds(335, 228, 89, 23);
		btnVolver.setActionCommand("Volver");
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		JLabel label = new JLabel("Por favor, introduzca sus datos");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(47, 13, 226, 25);
		contentPane.add(label);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBackground(new Color(65, 105, 225));
		btnGuardar.setBounds(302, 188, 89, 23);
		btnGuardar.setActionCommand("Guardar");
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		label_1 = new JLabel("Nombre de usuario");
		label_1.setBounds(47, 49, 121, 14);
		contentPane.add(label_1);
		
		txtNombre = new JTextPane();
		txtNombre.setBounds(238, 49, 100, 20);
		contentPane.add(txtNombre);
		
		label_2 = new JLabel("Contrase\u00F1a");
		label_2.setBounds(47, 73, 100, 14);
		contentPane.add(label_2);
		
		txtContraseña = new JTextPane();
		txtContraseña.setBounds(238, 73, 100, 20);
		contentPane.add(txtContraseña);
		
		label_3 = new JLabel("DNI");
		label_3.setBounds(47, 98, 100, 14);
		contentPane.add(label_3);
		
		txtDNI = new JTextPane();
		txtDNI.setBounds(238, 98, 100, 20);
		contentPane.add(txtDNI);
		
		label_4 = new JLabel("Edad");
		label_4.setBounds(47, 123, 100, 14);
		contentPane.add(label_4);
		
		txtEdad = new JTextPane();
		txtEdad.setBounds(238, 123, 100, 20);
		contentPane.add(txtEdad);
		
		
		//Creamos un grupo para que solamente pueda elegir una de esas dos
		sexoGroup = new ButtonGroup( );
		
		
		radioHombre = new JRadioButton("Hombre");
		radioHombre.setBackground(new Color(102, 205, 170));
		radioHombre.setActionCommand("Hombre");
		radioHombre.setBounds(195, 150, 109, 23);
		contentPane.add(radioHombre);
		
		radioMujer = new JRadioButton("Mujer");
		radioMujer.setBackground(new Color(102, 205, 170));
		radioMujer.setActionCommand("Mujer");
		radioMujer.setBounds(84, 150, 109, 23);
		contentPane.add(radioMujer);
		
		sexoGroup.add(radioMujer);
		sexoGroup.add(radioHombre);
		
		
	}
	
	//Método que nos permite coger la fecha en la que el usuario se inscribe para comenzar a jugar
		public String getFecha_inscrip() 
		{
			
			fecha_inscrip =new Date();
			SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
			
			return formatoFecha.format(fecha_inscrip);
		}
		
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Volver":
			objfrmJugar = new frmJugar();
			objfrmJugar.setVisible(true);
			this.dispose();
		
			break;
		case "Guardar":
		
			//Cogemos los valores que el usuario mete en los TextArea
			String nombre = txtNombre.getText();
			String contraseña = txtContraseña.getText();
			String dni = txtDNI.getText();
			String edad = txtEdad.getText();
					
			String sexo = sexoGroup.getSelection().getActionCommand();	
			
			//Guardará la fecha en la que se inscribió el usuario
			String fecha_inscrip = getFecha_inscrip();
			
			
			//	objG.guardarRegistrado(nombre, dni,sexo,fecha_inscrip,contraseña, edad); Hau berez ezteu behar ya....
				
			
			try {
				
				objBD.insertJugador_R(nombre, dni, sexo, fecha_inscrip, contraseña, edad,BD.getStatement());

			} catch (clsMiExcepcionDni e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				//objG.anyadirFilaJugador_R(nombre, dni, sexo, fecha_inscrip, contraseña, edad);
			this.dispose();
		
			break;
		}
	}
	
	
}
