package LP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmInfo extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVolver ;
	private JButton button;
	private JButton btnUsuario;

	/**
	 * Create the frame.
	 */
	public frmInfo() {
		setTitle("Informaci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita12.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(65, 105, 225));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(335, 228, 89, 23);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("Volver");
		contentPane.add(btnVolver);
		
		button = new JButton("How to play");
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(65, 105, 225));
		button.setActionCommand("How to Play");
		button.addActionListener(this);
		button.setBounds(236, 90, 149, 50);
		contentPane.add(button);
		
		btnUsuario = new JButton("Usuario");
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUsuario.setBackground(new Color(65, 105, 225));
		btnUsuario.setActionCommand("Usuario");
		btnUsuario.addActionListener(this);
		btnUsuario.setBounds(55, 90, 149, 50);
		contentPane.add(btnUsuario);
	}

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
		case "Usuario":
			frmUsuarioo objfrmUsuario = new frmUsuarioo();
			objfrmUsuario.setVisible(true);
			this.dispose();		
			break;
		case "How to Play":
			frmHowToPlay objfrmHowToPlay = new frmHowToPlay();
			objfrmHowToPlay.setVisible(true);
			this.dispose();
			break;
	
		}
	}
}
