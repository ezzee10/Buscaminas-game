import java.applet.AudioClip;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static JFrame ventana;
	private Panel panel;
	private boolean reintentar;
	
	public Ventana(boolean reintentarJuego){
		this.reintentar = reintentarJuego;
		ventana = new JFrame("Buscaminas");
		ventana.setSize(800,800);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		if(reintentarJuego) {
			panel = new Panel();
			panel.segundoPanel();
		}else {
			panel = new Panel();
			ventana.add(panel);
			
		}
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
