package LP;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import LN.clsRegistrado;


public class MiTablaModelo extends AbstractTableModel {

	
	   // Lista principal de datos del modelo:

    private ArrayList<LN.clsRegistrado> datos = new ArrayList<LN.clsRegistrado>();
    private String[] nombresColumnas;  // Nombres de columnas
	private static final long serialVersionUID = 7026825539532562011L;
	private boolean DEBUG = true;
	
    /** Constructor de modelo de tabla
     * @param nombresColumnas	Nombres de las columnas
     * @param colsEditables	Array de valores lógicos si las columnas son editables (true) o no (false)
     */
    public MiTablaModelo( String[] nombresColumnas ) {
    	this.nombresColumnas = nombresColumnas;
    }
    
    /** Añade un dato al final del modelo
     * @param dato	Dato a añadir
     */
    public void insertar(clsRegistrado  dato) {
    	datos.add( dato );
    }


    /* [01] MODELO: Devuelve el numero de columnas
     */
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    /* [01] MODELO: Devuelve el numero de filas
     */
    public int getRowCount() {
        return datos.size();
    }

    /* [01] MODELO: Devuelve el nombre de la columna
     */
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    /* [01] MODELO: Devuelve el valor de la celda indicada
     */
    public Object getValueAt(int row, int col) {
        return datos.get(row).getValor(col);
    }

    /* [01] MODELO: Este metodo devuelve el renderer/editor por defecto
     * para cada celda, identificado por la columna. 
     */
    public Class<?> getColumnClass(int c) {
    	if (datos.size()==0) return String.class;  // por defecto String
        return datos.get(0).getValor(c).getClass();  // Si hay datos, la clase correspondiente
    }

//    /* [01] MODELO: Si la tabla es editable, este método identifica
//     * qué celdas pueden editarse
//     */
//    public boolean isCellEditable(int row, int col) {
//    	if (col >= 0 && col < columnasEditables.length)
//    		return columnasEditables[col];
//    	else return false;
//    }

    /* [01] MODELO: Método que sólo hay que implementar si la tabla
     * puede cambiar (editar) valores de sus celdas
     */
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Poniendo valor en (" + row + "," + col
                               + ") = " + value + " (instancia de "
                               + value.getClass() + ")");
        }
        datos.get(row).setValor( value, col );
        fireTableCellUpdated(row, col);  // Notifica a escuchadores de cambio de celda
    }
    
    
    

//	/**
//	 * Create the frame.
//	 */
//	public MiTablaModelo() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//	}

}
