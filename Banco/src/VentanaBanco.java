import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class VentanaBanco extends javax.swing.JInternalFrame {
	protected Connection conexion = null;
	protected JPasswordField password;
	
	private void conectar()
	   {
	      if (this.conexion == null)
	      { 
	         try{ 
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	         }
	         catch (Exception ex)
	         {  
	            System.out.println(ex.getMessage());
	         }
	     
	         try
	         {  //se genera el string que define los datos de la conección 
	            String servidor = "localhost:3306";
	            String baseDatos = "banco";
	            String usuario = "admin";
	            String clave = "pwadmin";
	            String uriConexion = "jdbc:mysql://" + servidor + "/" + baseDatos +"?serverTimezone=UTC";
	            //se intenta establecer la conección
	            this.conexion = DriverManager.getConnection(uriConexion, usuario, clave);
	         }
	         catch (SQLException ex)
	         {
	            JOptionPane.showMessageDialog(this,
	                                          "Se produjo un error al intentar conectarse a la base de datos.\n" + 
	                                           ex.getMessage(),
	                                          "Error",
	                                          JOptionPane.ERROR_MESSAGE);
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	         }
	      }
	   }
}
