package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import LD.BD;

public class frmJugar extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEligeUnaOpcin;
	private JButton btnVolver;
	private JButton btnDemo;
	private JButton btnRegistrarse;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextPane txtNombre;
	private JTextPane txtContraseña;
	private JButton btnok;
	private BD bd= new BD();
	//private ResultSet rs;
	private boolean semaforo;


	/**
	 * Create the frame.
	 */
	public frmJugar() {
		setTitle("Jugar");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita10.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEligeUnaOpcin = new JTextField();
		txtEligeUnaOpcin.setToolTipText("P\u00E1gina Principal");
		txtEligeUnaOpcin.setText("Elige una opci\u00F3n:");
		txtEligeUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		txtEligeUnaOpcin.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtEligeUnaOpcin.setColumns(10);
		txtEligeUnaOpcin.setBackground(new Color(102, 205, 170));
		txtEligeUnaOpcin.setBounds(91, 11, 240, 41);
		//Para que el usuario simplemente lea la información que le hemos puesto, ponemos el editable a false
		txtEligeUnaOpcin.setEditable(false);
		contentPane.add(txtEligeUnaOpcin);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBackground(new Color(65, 105, 225));
		btnVolver.setBounds(335, 228, 89, 23);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("Volver");
		contentPane.add(btnVolver);
		
		btnDemo = new JButton("Demo");
		btnDemo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDemo.setBackground(new Color(65, 105, 225));
		btnDemo.setActionCommand("Jugar");
		btnDemo.setBounds(45, 62, 135, 50);
		btnDemo.addActionListener(this);
		btnDemo.setActionCommand("Demo");
		contentPane.add(btnDemo);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrarse.setBackground(new Color(65, 105, 225));
		btnRegistrarse.setActionCommand("Info");
		btnRegistrarse.setBounds(246, 62, 135, 50);
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setActionCommand("Registrarse");
		contentPane.add(btnRegistrarse);
		
		label = new JLabel("\u00BFEst\u00E1s registrado? Comienza a jugar!");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(55, 128, 246, 25);
		contentPane.add(label);
		
		label_1 = new JLabel("Nombre de usuario");
		label_1.setBounds(45, 164, 110, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Contrase\u00F1a");
		label_2.setBounds(45, 189, 110, 14);
		contentPane.add(label_2);
		
		txtNombre = new JTextPane();
		txtNombre.setBounds(181, 164, 100, 20);
		contentPane.add(txtNombre);
		
		txtContraseña = new JTextPane();
		txtContraseña.setBounds(181, 189, 100, 20);
		contentPane.add(txtContraseña);
		
		btnok = new JButton("OK");
		btnok.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnok.setBackground(new Color(65, 105, 225));
		btnok.setBounds(291, 174, 53, 23);
		btnok.addActionListener(this);
		btnok.setActionCommand("ok");
		contentPane.add(btnok);
		
		
		bd.initBD();
	}



	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Volver":
			frmPrincipal objfrmPrincipal = new frmPrincipal();
			objfrmPrincipal.setVisible(true);
			this.dispose();
			break;
		case "Demo":
			frmDemo objDemo = new frmDemo();
			objDemo.setVisible(true);
			this.dispose();

			break;
		case "Registrarse":
			frmRegistrarse objResgistrarse = new frmRegistrarse();
			objResgistrarse.setVisible(true);
			this.dispose();

			break;
		case "ok":
			
			//Cargamos los datos de nombre de usuario y contraseña 
			String nombre = txtNombre.getText();
			String contraseña = txtContraseña.getText();
	
			semaforo=  bd.verLogIn(nombre, contraseña, bd.getStatement());	
			
				if (semaforo==true) {
					frmRegistrado objRegis = new frmRegistrado();
					objRegis.setVisible(true);
				}else{
				
					JOptionPane.showMessageDialog(this, "No existe nadie con estos datos!");
						this.dispose();
						frmPrincipal objprinci= new frmPrincipal();
						objprinci.setVisible(true);
					}
				
				this.dispose();
				break;
			}
				
		}
	}

