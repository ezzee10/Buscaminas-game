import javax.swing.JFrame;

public class VentanaGameOver extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanelGameOver panel;
	static JFrame ventanaGameOver;

	public VentanaGameOver() {
		ventanaGameOver = new JFrame("Buscaminas");
		ventanaGameOver.setSize(400, 400);
		ventanaGameOver.setTitle(" ");
		ventanaGameOver.setResizable(false);
		ventanaGameOver.setLayout(null);
		ventanaGameOver.setLocationRelativeTo(null);
		PanelGameOver panel = new PanelGameOver();
		ventanaGameOver.add(panel);
		ventanaGameOver.setVisible(true);
		ventanaGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void apagarVentana() {
		ventanaGameOver.setVisible(false);
	}
}
