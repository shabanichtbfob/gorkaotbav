package LN;

public class clsNivel
{
	public clsNivel()
	{
		
	}
	
	public int definirNivel()
	{
		int nivel = 1;
		
		return nivel;
	}
	
	public static int filaNivel(int nivel)
	{
			
		int fila=0;
		
		if(nivel==1)
		{
			 fila = 3;
		}
		
		if(nivel==2)
		{
			fila = 4;
		}
		
		if(nivel ==3)
		{
			fila = 5;
		}
		
		return fila;
	}

}
