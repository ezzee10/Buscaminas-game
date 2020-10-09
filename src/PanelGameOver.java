import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelGameOver extends JPanel {
	
	private JButton boton;
	private Panel panel1;
	private VentanaGameOver ventanita;
	private JButton boton1;
	private JButton boton2;
	private JLabel labelFondoPrincipal;
	private JLabel label;
	private Matriz matriz;
	private JLabel labelTiempo;
	
	public PanelGameOver() {
		inicializarMenuPrincipal();
	}

	public void inicializarMenuPrincipal() {

		setLayout(null);
		setSize(400, 400);
		labelFondoPrincipal = new JLabel();
		labelFondoPrincipal.setSize(400,400);
		labelFondoPrincipal.setIcon(new
		ImageIcon("imagenes/fondoanimado.jpg"));
		add(labelFondoPrincipal,0);
		
		if(Matriz.ganador == false) {
			label = new JLabel();
			label.setBounds(60, 50, 300, 50);
			label.setFont(new Font("Arial", Font.BOLD, 45));
			label.setForeground(Color.cyan);
			label.setText("¡PERDEDOR!");
			//System.out.println(Cronometro.cronometro);
			add(label,0);
		}else {
			label = new JLabel();
			label.setBounds(70, 50, 300, 50);
			label.setFont(new Font("Arial", Font.BOLD, 45));
			label.setForeground(Color.cyan);
			label.setText("¡GANADOR!");
			add(label,0);
			labelTiempo = new JLabel();
			labelTiempo.setBounds(65, 120, 300, 40);
			labelTiempo.setFont(new Font("Arial", Font.BOLD, 30));
			labelTiempo.setForeground(Color.cyan);
			labelTiempo.setText("Tiempo: "+ Cronometro.cronometro+ " segundos");
			//System.out.println(Cronometro.cronometro);
			add(labelTiempo,0);
		}
		
		
		boton = new JButton("Volver al menú principal");
		boton.setBounds(90, 250, 200, 50);
		add(boton,0);
		boton1 = new JButton("Salir del juego");
		boton1.setBounds(90, 310, 200, 50);
		add(boton1,0);
		boton2 = new JButton("Reintentar");
		boton2.setBounds(90, 190, 200, 50);
		add(boton2,0);
		
		boton.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				Panel.panel2.setVisible(false);
				VentanaGameOver.ventanaGameOver.dispose();
				Ventana.ventana.dispose();
				Ventana ventana = new Ventana(false);	
				Cronometro.cronometro = 0;
			}		
		});
		
		boton1.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				System.exit(1);
			}		
		});
		
		boton2.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				//Panel.panel2.remove(comp);
				//Ventana.ventana.remove(Panel.panel2);
				
				int tamaño = Panel.minas;
				int minas = Panel.tamaño;
				
				VentanaGameOver.ventanaGameOver.dispose();
				Ventana.ventana.dispose();
				
				Ventana ventana = new Ventana(true);
				
				System.out.println("tamaño: "+ tamaño + " minas: "+minas);
				
				Cronometro.cronometro = 0;
				
				//Ventana ventana = new Ventana();			
			}		
		});
		
		
		
		
		
	}
}
