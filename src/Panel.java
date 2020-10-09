import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel label, label1, label2, label3, label4, label5,label6,labelFondoPrincipal,labelFondoSecundario;
	public static JPanel panel2;
	private JTextField texto, texto1;
	private JButton botonJugar;
	private Matriz matriz;
	private JLabel relojImagen;
	private JButton botonFacil;
	private JButton botonMedio;
	private JButton botonDificil;
	private JButton botonPersonalizado;
	static JLabel cantMinas;
	static JLabel reloj;
	static int tamaño;
	static int minas;

	public Panel() {

		inicializarMenuPrincipal();

	}
	
	public int getTamaño() {
		return tamaño;
	}
	
	public int getMinas() {
		return minas;
	}

	public void inicializarMenuPrincipal() {

		setLayout(null);
		setSize(800, 800);
		labelFondoPrincipal = new JLabel();
		labelFondoPrincipal.setSize(800,800);
		ImageIcon imagen = new ImageIcon("imagenes/fondoanimado.jpg"); // getClass().getResource(\"/imagenes/
		labelFondoPrincipal.setIcon(imagen);
		//labelFondoPrincipal.setIcon(new ImageIcon(getClass().getResource("imagenes/fondoanimado.jpg")));
		//labelFondoPrincipal.setIcon(new ImageIcon("imagenes/fondoanimado.jpg"));
		add(labelFondoPrincipal,0);
		label = new JLabel();
		label.setBounds(230, 50, 400, 50);
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.cyan);
		label.setText("BUSCAMINAS");
		add(label,0);
		label1 = new JLabel();
		label1.setBounds(200, 150, 500, 30);
		label1.setFont(new Font("Arial", Font.BOLD, 30));
		label1.setForeground(Color.cyan);
		label1.setText("Elija la dificultad que desee");
		label1.setVisible(true);
		add(label1,0);
		texto = new JTextField();
		texto.setBounds(420, 370, 300, 50);
		texto.setFont(new Font("Arial", Font.BOLD, 30));
		texto.setVisible(false);
		add(texto,0);
		texto1 = new JTextField();
		texto1.setBounds(420, 470, 300, 50);
		texto1.setFont(new Font("Arial", Font.BOLD, 30));
		texto1.setVisible(false);
		add(texto1,0);
		botonJugar = new JButton("JUGAR");
		botonJugar.setBounds(260, 600, 200, 50);
		botonJugar.setFont(new Font("Arial", Font.BOLD, 30));
		botonJugar.setForeground(Color.RED);
		add(botonJugar,0);
		label5 = new JLabel("etiqueta2");
		label4 = new JLabel("etiqueta");
		label3 = new JLabel("etiqueta1");
		add(label4,0);
		add(label3,0);
		add(label5,0);
		
		botonFacil = new JButton("FACIL");
		botonFacil.setBounds(70, 240, 300, 50);
		botonFacil.setFont(new Font("Arial", Font.BOLD, 30));
		botonFacil.setForeground(Color.RED);
		add(botonFacil,0);
		
		botonMedio = new JButton("INTERMEDIO");
		botonMedio.setBounds(70, 320, 300, 50);
		botonMedio.setFont(new Font("Arial", Font.BOLD, 30));
		botonMedio.setForeground(Color.RED);
		add(botonMedio,0);
		
		botonDificil = new JButton("DIFICIL");
		botonDificil.setBounds(70, 400, 300, 50);
		botonDificil.setFont(new Font("Arial", Font.BOLD, 30));
		botonDificil.setForeground(Color.RED);
		add(botonDificil,0);
		
		botonPersonalizado = new JButton("PERSONALIZADO");
		botonPersonalizado.setBounds(420, 240, 300, 50);
		botonPersonalizado.setFont(new Font("Arial", Font.BOLD, 30));
		botonPersonalizado.setForeground(Color.RED);
		add(botonPersonalizado,0);
		
		botonFacil.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				tamaño = 8;
				minas = 10;
				segundoPanel();
				setVisible(false);
			}		
		});
		
		botonMedio.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				tamaño = 16;
				minas = 40;
				segundoPanel();
				setVisible(false);
			}		
		});
		
		botonDificil.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				tamaño = 18;
				minas = 60;
				segundoPanel();
				setVisible(false);
			}		
		});
		
		

		texto.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9') {
					e.consume();
				}
			}
		});

		texto1.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9') {
					e.consume();
				}
			}
		});
		
		botonPersonalizado.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				label6 = new JLabel();
				label6.setBounds(420, 320, 300, 50);
				label6.setFont(new Font("Arial", Font.BOLD, 20));
				label6.setForeground(Color.cyan);
				label6.setText("Ingrese el tamaño del tablero");
				add(label6,0);
				texto.setVisible(true);
				label2 = new JLabel();
				label2.setBounds(420, 420, 300, 50);
				label2.setFont(new Font("Arial", Font.BOLD, 20));
				label2.setForeground(Color.cyan);
				label2.setText("Ingrese la cantidad de minas");
				texto1.setVisible(true);
				add(label2,0);
				
				botonJugar.addMouseListener(new MouseAdapter() {

					public void mousePressed(MouseEvent e) {
						

						try {
							tamaño = Integer.parseInt(texto.getText());
							minas = Integer.parseInt(texto1.getText());

							if (tamaño < 4 || minas == 0 || tamaño >16) {
								label5.setBounds(80, 550, 700, 20);
								label5.setFont(new Font("Arial", Font.BOLD, 15));
								label5.setForeground(Color.WHITE);
								System.out.println("xd");
								if (label3.isVisible() || label4.isVisible()) {
									label3.setText(" ");
									label4.setText(" ");
									label5.setText(
											"El tamaño del tablero debe ser superior a 4, menor a 16 y la cantidad de minas no puede ser 0");
									repaint();
								} else {
									label5.setText(
											"El tamaño del tablero debe ser superior a 4 y la cantidad de minas no pueden ser 0");
									;
									repaint();
								}
							} else if (minas >= tamaño*tamaño) {
								label4.setBounds(160, 550, 500, 20);
								label4.setFont(new Font("Arial", Font.BOLD, 15));
								label4.setForeground(Color.WHITE);
								System.out.println("xd");
								if (label3.isVisible() || label5.isVisible()) {
									label3.setText(" ");
									label5.setText(" ");
									label4.setText("La cantidad de minas no puede ser igual o mayor que el tablero");
									repaint();
								} else {
									label4.setText("La cantidad de minas no puede ser igual o mayor que el tablero");
									repaint();
								}
							} else {
								segundoPanel();
								setVisible(false);
								AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/musica1.wav"));
								sonido.play();
							
							}
						} catch (NumberFormatException e1) {
							label3.setBounds(160, 550, 500, 20);
							label3.setFont(new Font("Arial", Font.BOLD, 15));
							label3.setForeground(Color.WHITE);
							if (label4.isVisible() || label5.isVisible()) {
								label4.setText(" ");
								label5.setText(" ");
								label3.setText("Debe ingresar el tamaño de tablero y la cantidad de minas");
								repaint();
							} else {
								label3.setText("Debe ingresar el tamaño de tablero y la cantidad de minas");
								repaint();
							}
						}
					}
				});
				
			}		
		});
		

		
	}

	public void segundoPanel() {		
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setSize(1920, 1080);
		Ventana.ventana.add(panel2);
		labelFondoSecundario = new JLabel();
		labelFondoSecundario.setSize(panel2.getWidth(),panel2.getHeight());
		System.out.println("ancho: "+ panel2.getWidth()+ "alto: "+ panel2.getHeight());
		labelFondoSecundario.setIcon(new ImageIcon("imagenes/espacio.jpg"));
		reloj = new JLabel();
		reloj.setBounds(90, 10, 100, 40);
		reloj.setVisible(true);
		reloj.setFont(new Font("Arial",Font.BOLD,20));
		reloj.setForeground(Color.CYAN);
		reloj.setText("Tiempo: ");
		cantMinas = new JLabel();
		cantMinas.setBounds(250, 10, 100, 40);
		cantMinas.setVisible(true);
		cantMinas.setFont(new Font("Arial",Font.BOLD,20));
		cantMinas.setForeground(Color.CYAN);
		cantMinas.setText("Minas: ");
		panel2.add(labelFondoSecundario,0);
		panel2.add(reloj,0);
		panel2.add(cantMinas,0);
		
		matriz = new Matriz(tamaño,tamaño,minas);
	}
}
