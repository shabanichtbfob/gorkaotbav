package LP;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import javax.swing.JButton;

public class frmDemo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelInfo;
	private JPanel panelJuego;
	private JLabel lblCaritaDisp;
	private static JLabel bola;
	private int bolaNumero;
	
	private int[][] tablero;
	private JLabel[][] tableroLabel;
	private Icon[] iconos;
	private int tamano;
	
	private int puntos;
	
	private String[] dibujoBolas = {"C:\\emoticonos\\carita2.png","C:\\emoticonos\\carita3.png","C:\\emoticonos\\carita5.png","C:\\emoticonos\\carita6.png","C:\\emoticonos\\carita7.png","C:\\emoticonos\\carita8.png", "C:\\emoticonos\\carita9.png", "C:\\emoticonos\\carita10.png", "C:\\emoticonos\\carita11.png", "C:\\emoticonos\\carita12.png"};
	private JTextField txtPuntuacion;
	private JRadioButton rdNivel1;
	private String valor;
	private JButton btnSalir;
	
	public frmDemo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\emoticonos\\carita2.png"));
		setTitle("FaceShooter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		panelJuego = new JPanel();
		panelJuego.setPreferredSize(new Dimension(300, 600));
		contentPane.add(panelJuego, BorderLayout.CENTER);
		
		panelJuego.setLayout(null);
		panelJuego.setBackground(new Color(30, 144, 255));
		
		panelInfo = new JPanel();
		panelInfo.setBackground(new Color(102, 205, 170));
		panelInfo.setPreferredSize(new Dimension(150, 600));
		contentPane.add(panelInfo, BorderLayout.EAST);
		
		this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				autoajustar();
				pintarTablero();
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//Ponemos lo referente al juego
		
		lblCaritaDisp = new JLabel("");
		lblCaritaDisp.setBackground(new Color(102, 205, 170));
		lblCaritaDisp.setBounds(269, 489, 60, 60);
		panelJuego.add(lblCaritaDisp);
		panelJuego.setBackground(new Color(100, 0, 0));
		
		
		
		panelJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				moverBola(arg0.getX(), arg0.getY());	
				
			}
		});
		
		
		panelInfo.setLayout(null);

		rdNivel1 = new JRadioButton("Nivel 1");
		rdNivel1.setBackground(new Color(102, 205, 170));
		rdNivel1.setBounds(20, 250, 109, 100);
		rdNivel1.setActionCommand("Nivel1");
		rdNivel1.addActionListener(this);
		//nivelGroup.add(rdNivel1);
		rdNivel1.setSelected(true);
		panelInfo.add(rdNivel1);
		
		
		
		JTextArea explicacion = new JTextArea("Estas jugando en modo demo,\nsolamente puedes jugar en\n el primer nivel.\nSi quieres jugar mas,\n¡Registrate!");
		explicacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		explicacion.setBackground(new Color(102, 205, 170));
		//explicacion.setBounds(20, 20, 100, 100);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 125, 150);
				
		explicacion.setEditable(false);
		scrollPane.setViewportView(explicacion);
		panelInfo.add(scrollPane);
		
		JLabel lblPuntuacin = new JLabel("Puntuaci\u00F3n:");
		lblPuntuacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuntuacin.setBackground(new Color(102, 205, 170));
		lblPuntuacin.setBounds(10, 350, 112, 27);
		panelInfo.add(lblPuntuacin);
		
		txtPuntuacion = new JTextField();
		txtPuntuacion.setColumns(10);
		txtPuntuacion.setBounds(20, 400, 102, 20);
		panelInfo.add(txtPuntuacion);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(65, 105, 225));
		btnSalir.setBounds(40, 485, 89, 23);
		btnSalir.setActionCommand("Salir");
		btnSalir.addActionListener(this);

		panelInfo.add(btnSalir);

		this.pack();
		//crearBola();
			
		tablero = new int[8][10];
		tableroLabel = new JLabel[8][10];
		autoajustar();
		generarLabels();
		
		
	}
	
	
	/**Elegir el numero con random mediante el cual conseguiremos la imagen cada vez
	 * @return nos devuelve un numero random, del 1-10 porque tenemos 10 caritas
	 */
	public String elegirIndice(){
		
		Random indImagen = new Random();
		int y = indImagen.nextInt(dibujoBolas.length);
		
		String imagen = dibujoBolas[y];
	return imagen;
	}
	
	
	private String cogerPuntos(){
		valor = Integer.toString(puntos);
		return valor;
	}
	
	private void moverBola (int x, int y ){
		boolean beteta = true;
		int zabalera = panelJuego.getWidth();
		zabalera = zabalera / tablero.length;
		x = x / zabalera;
		y = y / zabalera;
		if (tablero[x][y] == -1){
			if (y==0 || tablero[x][y-1] != -1){
				tablero[x][y] = bolaNumero;
				tableroLabel[x][y] = bola;
				bola.setBounds(zabalera*x, zabalera*y, zabalera, zabalera);
				crearBola();
				eliminarBolas(x, y);
				
				// begiratu azken fila beteta dagoen
				
				int i = 0;
				while(beteta && i < tablero.length){
					if (tablero[i][tablero[0].length-1] == -1){
						beteta = false;
					}else{
						i++;
					}
				}
				if (beteta){
					JOptionPane.showMessageDialog(this, "Game over");
					System.out.println("Galdu duzu");
					this.dispose();
					frmJugar objfrmJugar = new frmJugar();
					objfrmJugar.setVisible(true);
				}
				this.repaint();

			}
		}
	}
	
	private void eliminarBolas(int x, int y){
		int tipo = tablero[x][y];
		ArrayList<Integer> borrar = new ArrayList<>();
		if (eliminarBolas(x, y, borrar, tipo)){
			if (tableroLabel[x][y] != null && tablero[x][y] != -1){
				sumarPuntos();
				tablero[x][y] = -1;
				panelJuego.remove(tableroLabel[x][y]);
				tableroLabel[x][y] = null;
			}
		}

	}
	
	private boolean eliminarBolas(int x, int y, ArrayList<Integer> borrar, int tipo){
		boolean encontrado = false;
		for (int i=-1; i<2; i++){
			for (int j=-1; j<2; j++){
				if (i!=0 || j!=0){
					int posX = x+i;
					int posY = y+j;
					if (posX >= 0 && posX < tablero.length && posY >= 0 && posY < tablero[posX].length){
						if (tablero[x+i][y+j] == tipo){
							// Eliminar esta posicion
							tablero[posX][posY] = -1;
							panelJuego.remove(tableroLabel[posX][posY]);
							tableroLabel[posX][posY] = null;
							encontrado = true;
							sumarPuntos();
							txtPuntuacion.setText(cogerPuntos()); 
							// Mirar los de al lado
							eliminarBolas(posX, posY, borrar, tipo);
						}
					}
				}
			}
		}
		return encontrado;
	}
	
	private void sumarPuntos(){

		if (puntos >= 200){
			
			JOptionPane.showMessageDialog(this, "Juego superado, felicidades!");
			this.dispose();			
			frmJugar objfrmJugar = new frmJugar();
			objfrmJugar.setVisible(true);
			
		}	
		puntos += 10;
	}

		public void generarLabels ()	{
			
			int ultimaFila = 5;
	
			Random indImagen = new Random();
			for (int i=0; i<tablero.length; i++){
				for (int j=0; j<ultimaFila; j++){
					tablero[i][j] = indImagen.nextInt(dibujoBolas.length);
					tableroLabel[i][j] = new JLabel();
					tableroLabel[i][j].setIcon(new ImageIcon(dibujoBolas[tablero[i][j]].toString()));
					panelJuego.add(tableroLabel[i][j]);
				}
				for (int z=ultimaFila; z<tablero[i].length; z++){
					tablero[i][z] = -1;
					tableroLabel[i][z] = new JLabel();
				}
			}
			crearBola();
			pintarTablero();
						
		}
		
	private void pintarTablero(){
		for (int i=0; i<tablero.length; i++){
			for (int j=0; j<tablero[i].length; j++){
				if (tablero[i][j] != -1){

					JLabel label2 = tableroLabel[i][j];
					label2.setIcon(iconos[tablero[i][j]]);
					label2.setBounds(tamano*i, tamano*j, tamano, tamano);

				}
				
			}
		}
		pintarBola();
	}

	private void crearBola (){
		Random indImagen = new Random();
		bola = new JLabel("");
		bolaNumero = indImagen.nextInt(dibujoBolas.length);
		panelJuego.add(bola);
		pintarBola();
	}
	
	private void pintarBola(){
		bola.setIcon(iconos[bolaNumero]);
		int zabalera = panelJuego.getWidth();
		zabalera = zabalera / tablero.length;
		bola.setBounds(panelJuego.getWidth()/2, panelJuego.getHeight()-zabalera, zabalera, zabalera);

	}
	
	public void autoajustar (){
		tamano = panelJuego.getWidth() / tablero.length;
		iconos = new Icon[dibujoBolas.length];
		for (int x=0; x<dibujoBolas.length; x++){
			ImageIcon imagen = new ImageIcon(dibujoBolas[x]); 
			Icon icono  = new ImageIcon(imagen.getImage().getScaledInstance(tamano, tamano, Image.SCALE_DEFAULT));
			iconos[x] = icono;
		}
		
		this.repaint();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Salir":
			this.dispose();
			frmJugar objfrmJugar = new frmJugar();
			objfrmJugar.setVisible(true);	
			break;
		}	
	}

}
