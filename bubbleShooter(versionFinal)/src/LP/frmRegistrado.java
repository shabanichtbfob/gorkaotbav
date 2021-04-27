package LP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class frmRegistrado extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnModif;
	private JButton btnJugar;
	private JButton btnVolver;
	private JButton btnVer;


	/**
	 * Create the frame.
	 */
	public frmRegistrado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita9.png"));
		setTitle("Jugador Registrado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("P\u00E1gina Principal");
		textField.setText("Elige una opci\u00F3n:");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(102, 205, 170));
		textField.setBounds(98, 11, 240, 41);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Ver mis datos de usuario:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(42, 167, 225, 25);
		contentPane.add(label);
		
		btnVer = new JButton("Ver");
		btnVer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVer.setBackground(new Color(65, 105, 225));
		btnVer.setActionCommand("Volver");
		btnVer.setBounds(294, 169, 99, 23);
		btnVer.setActionCommand("Ver");
		btnVer.addActionListener(this);
		contentPane.add(btnVer);
		
		JLabel label_1 = new JLabel("Modificar mis datos de usuario:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(42, 74, 225, 25);
		contentPane.add(label_1);
		
		btnModif = new JButton("Modificar");
		btnModif.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModif.setBackground(new Color(65, 105, 225));
		btnModif.setActionCommand("Volver");
		btnModif.setBounds(294, 74, 99, 23);
		btnModif.setActionCommand("Modificar");
		btnModif.addActionListener(this);
		contentPane.add(btnModif);
		
		JLabel label_2 = new JLabel("Jugar por niveles:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(42, 121, 225, 25);
		contentPane.add(label_2);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnJugar.setBackground(new Color(65, 105, 225));
		btnJugar.setActionCommand("Volver");
		btnJugar.setBounds(294, 123, 99, 23);
		btnJugar.setActionCommand("Jugar");
		btnJugar.addActionListener(this);
		contentPane.add(btnJugar);
		
		btnVolver = new JButton("Salir");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBackground(new Color(65, 105, 225));
		btnVolver.setActionCommand("Volver");
		btnVolver.setBounds(325, 228, 99, 23);
		btnVolver.setActionCommand("Volver");
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Volver":
			frmJugar objfrmJugar = new frmJugar();
			objfrmJugar.setVisible(true);
			this.dispose();
			break;
	
		case "Jugar":			
			frmCaritaShooter objDemo = new frmCaritaShooter();
			objDemo.setVisible(true);			
			break;
	
		case "Modificar":
			frmModificar objModificar = new frmModificar();
			objModificar.setVisible(true);
			this.dispose();
			break;
	
		case "Ver":	
			frmVerUsuario objfrmUsuario = new frmVerUsuario();
			objfrmUsuario.setVisible(true);
			this.dispose();		
			break;
	
		}
	}
}
