package LN;

import java.util.Random;

public class BubbleShooter 
{
	//protected ArrayList<clscarita>[][] bolas;
	private int objposX;
	private int objposY;
	protected int[][] indBolas;
	private String[] dibujoBolas = {"C:\\emoticonos\\carita2.png","C:\\emoticonos\\carita3.png","C:\\emoticonos\\carita5.png","C:\\emoticonos\\carita6.png","C:\\emoticonos\\carita7.png","C:\\emoticonos\\carita8.png", "C:\\emoticonos\\carita9.png", "C:\\emoticonos\\carita10.png", "C:\\emoticonos\\carita11.png", "C:\\emoticonos\\carita12.png"};

	public BubbleShooter()
	{
		
		 this.objposX=0;
		 this.objposY=0;
		 indBolas = new int [10][5];
		 
	}
	
	public int rellenarMatrizIndices(int i, int j){
		int y=0;;
		  for (i = 0; i < 7; i++) {
			  for (j = 0; j < 11; j++) {
				  Random ind = new Random();
				   y = ind.nextInt(dibujoBolas.length);
	               indBolas[i][j]=y;
	          }
	      }
	  return y;
	}
	
	public int getObjposX() {
		return objposX;
	}



	public void setObjposX(int objposX) {
		this.objposX = objposX;
	}



	public int getObjposY() {
		return objposY;
	}



	public void setObjposY(int objposY) {
		this.objposY = objposY;
	}
	
	
}