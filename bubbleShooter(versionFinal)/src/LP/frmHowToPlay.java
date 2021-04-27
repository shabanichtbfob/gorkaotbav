package LP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class frmHowToPlay extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton button;

	
	/**
	 * Create the frame.
	 */
	public frmHowToPlay() {
		setTitle("How To Play");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 200);
		contentPane.add(scrollPane);
		
		JTextArea txtrEtc = new JTextArea();
		txtrEtc.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtrEtc.append("El objetivo de este juego es conseguir alcanzar los puntos\n necesarios para pasar de un nivel a otro."); 
		txtrEtc.append(System.getProperty("line.separator")); // Esto para el salto de línea 
		txtrEtc.append("Para ello, tenemos que conseguir que la carita que aparece\nabajo en el centro se coloque alrededor de otro de su mismo estilo,\nnasi conseguiremos que esas caritas se eliminen consiguiendo 10 puntos\npor cada carita eliminada. Aparte de comprobar si la carita\nque lanzamos choca con alguna de su estilo,\nen caso de que lo haga, a su vez comprobamos si alrededor de esta\nsegunda carita existealguna del mismo estilo, para eliminarla.\nEste proceso se repetiria por cada carita igual que encontremos." ); 
		txtrEtc.append(System.getProperty("line.separator")); // Esto para el salto de línea 
		txtrEtc.append("Para lanzar la bola del medio, tenemos que click-ar en la\nposicion en la cual queremos colocar la carita.\nLa carita no se movera en caso deque click-emos en una posicion donde arriba de esta no exista ninguna carita, o encima de una carita ya colocada."); 
		txtrEtc.append(System.getProperty("line.separator")); // Esto para el salto de línea 
		txtrEtc.append("Puntos necesarios para pasar de nivel"); 
		txtrEtc.append(System.getProperty("line.separator")); // Esto para el salto de línea 
		txtrEtc.append("Nivel 1 : 100 puntos"); 
		txtrEtc.append(System.getProperty("line.separator")); // Esto para el salto de línea 
		txtrEtc.append("Nivel 2: 200 puntos"); 
		txtrEtc.append(System.getProperty("line.separator")); // Esto para el salto de línea 
		txtrEtc.append("Nivel 3: 300 puntos"); 

		
		//Para que el usuario simplemente lea la información que le hemos puesto, ponemos el editable a false
		txtrEtc.setEditable(false);
		scrollPane.setViewportView(txtrEtc);
		contentPane.add(scrollPane);
		
		button = new JButton("Volver");
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(335, 228, 89, 23);
		button.addActionListener(this);
		button.setActionCommand("Volver");
		contentPane.add(button);
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
		
		}
	}
}
