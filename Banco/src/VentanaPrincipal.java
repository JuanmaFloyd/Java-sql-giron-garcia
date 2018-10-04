import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class VentanaPrincipal extends javax.swing.JFrame{

	private JDesktopPane panelPrincipal;
	
	private VentanaBanco ventanaBanco;
	private VentanaATM ventanaATM;
	private VentanaPrestamos ventanaPrestamos;
	
	private JMenu menuPrincipal;
	private JMenuItem itemATM;
	private JMenuItem itemBanco;
	private JMenuItem itemPrestamos;
	private JMenuBar menuBar;
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				VentanaPrincipal inst = new VentanaPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VentanaPrincipal(){
		super();
		
		init();
	}
	
	private void init(){
		try{
		
			this.setTitle("Java - MySQL - GarcíaGirón");
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			panelPrincipal = new JDesktopPane();
			
			getContentPane().add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));
			
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			menuPrincipal = new JMenu();
			menuBar.add(menuPrincipal);
			menuPrincipal.setText("Opciones");
			
			itemBanco = new JMenuItem();
			menuPrincipal.add(itemBanco);
			itemBanco.setText("Realizar consultas a la BD");
			itemBanco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					itemBancoAction(e);
				}
			});
			
			itemATM = new JMenuItem();
			menuPrincipal.add(itemATM);
			itemATM.setText("Ingrese a su ATM");
			itemATM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					itemATMAction(e);
				}
			});
			
			itemPrestamos = new JMenuItem();
			menuPrincipal.add(itemPrestamos);
			itemPrestamos.setText("Administre sus prestamos");
			itemPrestamos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					itemPrestamosAction(e);
				}});
			
			this.setSize(800, 600);
			pack();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void itemBancoAction(ActionEvent e){
		try{
			this.ventanaBanco.setMaximum(true);
		} catch(Exception ex){ex.printStackTrace();}
		this.ventanaBanco.setVisible(true);
	}
	private void itemATMAction(ActionEvent e){
		try{
			this.ventanaATM.setMaximum(true);
		} catch(Exception ex){ex.printStackTrace();}
		this.ventanaATM.setVisible(true);
	}
	private void itemPrestamosAction(ActionEvent e){
		try{
			this.ventanaPrestamos.setMaximum(true);
		} catch(Exception ex){ex.printStackTrace();}
		this.ventanaPrestamos.setVisible(true);
}
	
}
