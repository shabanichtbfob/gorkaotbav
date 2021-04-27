package LN;

import java.util.Random;

import LP.frmCaritaShooter;



public class clsMatriz {

	private String[] dibujoBolas = {"C:\\emoticonos\\carita2.png","C:\\emoticonos\\carita3.png","C:\\emoticonos\\carita5.png","C:\\emoticonos\\carita6.png","C:\\emoticonos\\carita7.png","C:\\emoticonos\\carita8.png", "C:\\emoticonos\\carita9.png", "C:\\emoticonos\\carita10.png", "C:\\emoticonos\\carita11.png", "C:\\emoticonos\\carita12.png"};
	private frmCaritaShooter caritaShooter= new frmCaritaShooter();
	
	
	
	public int generarRandom(){
		
		Random indImagen = new Random();
		int y = indImagen.nextInt(dibujoBolas.length+1);
		
		return y;
	}
	
	public String[][] rellenarMatriz(){
	
	int filaNivel = caritaShooter.cogerUltimaFila();
	int y=7; //filas
	int x=9; //columnas
	int random =generarRandom();
	
		String [][]indiceCarita= new String [y][x]; //matriz de datos
	
				for (int i=1; i< x;i++){
					for (int j=0; j< y;j++){
						if(i< filaNivel +1)
						{	
							String direccion = dibujoBolas[random];
							indiceCarita[i][j]=direccion;
						}
						else{
							indiceCarita[i][j]= "" ;
						}
							
						}
					}
				return indiceCarita;
		}
	public void cargarImagen(){
		int y=7; //filas
		int x=9; //columnas
		
		for (int i=1; i< x;i++){
			for (int j=0; j< y;j++){
	
			}
		}
	}
				
				
}
	
