package LP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtquDeseaHacer;
	private JButton btnJugar;
	private JButton btnInfo;
	
	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setTitle("P\u00E1gina Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita7.png"));
		setBackground(new Color(119, 136, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBackground(new Color(65, 105, 225));
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJugar.setBounds(68, 120, 120, 50);
		btnJugar.addActionListener(this);
		btnJugar.setActionCommand("Jugar");
		contentPane.add(btnJugar);
		
		btnInfo = new JButton("Info");
		btnInfo.setBackground(new Color(65, 105, 225));
		btnInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInfo.setBounds(249, 120, 120, 50);
		btnInfo.addActionListener(this);
		btnInfo.setActionCommand("Info");
		contentPane.add(btnInfo);
		
		txtquDeseaHacer = new JTextField();
		txtquDeseaHacer.setToolTipText("P\u00E1gina Principal");
		txtquDeseaHacer.setHorizontalAlignment(SwingConstants.CENTER);
		txtquDeseaHacer.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtquDeseaHacer.setBackground(new Color(102, 205, 170));
		txtquDeseaHacer.setText("\u00BFQu\u00E9 desea hacer?");
		txtquDeseaHacer.setBounds(99, 35, 240, 41);
		//Para que el usuario simplemente lea la información que le hemos puesto, ponemos el editable a false
		txtquDeseaHacer.setEditable(false);
		contentPane.add(txtquDeseaHacer);
		txtquDeseaHacer.setColumns(10);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Jugar":
			frmJugar objfrmJugar = new frmJugar();
			objfrmJugar.setVisible(true);
			this.dispose();
			
			break;
		case "Info":
			frmInfo objfrmInfo = new frmInfo();
			objfrmInfo.setVisible(true);
			this.dispose();
		
			break;
	
		}
	}
}
