import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Matriz {

	private int[][] matriz;
	private int fila;
	private int columna;
	static int minas;
	private Random azar;
	private JLabel[][] matrizEtiquetas;
	private JLabel[][] matrizEtiquetasVacias;
	private JButton[][] botones;
	static boolean ganador;
	static boolean activado = false;
	private int contadorDeClicks = 0;
	private Cronometro reloj;

	public Matriz(int fila, int columna, int minas) {
		if (fila == columna) {
			this.fila = fila;
			this.columna = columna;
			this.minas = minas;
			crearMatriz();
			// crearCasillasVacias();
			crearCasillasConImagenesYBotones();
		} else {
			throw new Error("la cantidad de filas debe ser igual a la cantidad de columnas");
		}

	}

	public void crearMatriz() {

		matriz = new int[fila][columna];

		int numero = 0;
		int numero1 = 1;
		azar = new Random();

		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				matriz[i][j] = 0;
			}
		}

		for (int i = 0; i < minas; i++) {
			numero = azar.nextInt(fila);
			numero1 = azar.nextInt(columna);
			if (matriz[numero][numero1] != 9) {
				matriz[numero][numero1] = 9;
			} else {
				i--;
			}

		}

		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {

				if (matriz[i][j] != 9) {

					int contador = 0;

					if (i > 0) {
						if (matriz[i - 1][j] == 9) {
							contador++;
						}
					}
					if (i > 0 && j > 0) {
						if (matriz[i - 1][j - 1] == 9) {
							contador++;
						}
					}
					if (i > 0 && j < columna - 1) {
						if (matriz[i - 1][j + 1] == 9) {
							contador++;
						}
					}
					if (j > 0 && i < fila - 1) {
						if (matriz[i + 1][j - 1] == 9) {
							contador++;
						}
					}
					if (i < fila - 1 && j < columna - 1) {
						if (matriz[i + 1][j + 1] == 9) {
							contador++;
						}
					}
					if (i < fila - 1) {
						if (matriz[i + 1][j] == 9) {
							contador++;
						}
					}
					if (j > 0) {
						if (matriz[i][j - 1] == 9) {
							contador++;
						}
					}
					if (j < columna - 1) {
						if (matriz[i][j + 1] == 9) {
							contador++;
						}
					}
					matriz[i][j] = contador;
				}
			}
		}

		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println(" ");
		}
	}

	public void crearCasillasVacias() {

		matrizEtiquetasVacias = new JLabel[fila][columna];
		int contador2 = 0;
		Ventana.ventana.setSize(fila * 50 + 140, columna * 50 + 140);
		for (int i = 0; i < fila; i++) {
			int contador = 0;
			for (int j = 0; j < columna; j++) {
				matrizEtiquetasVacias[i][j] = new JLabel();
				matrizEtiquetasVacias[i][j].setSize(50, 50);
				matrizEtiquetasVacias[i][j].setLocation(65 + contador, 50 + contador2);
				matrizEtiquetasVacias[i][j]
						.setIcon(new ImageIcon("imagenes/recuadro.jpg"));
				matrizEtiquetasVacias[i][j].setVisible(true);
				Panel.panel2.add(matrizEtiquetasVacias[i][j], 0);
				contador += 50;
			}
			contador2 += 50;
		}

	}

	public void crearCasillasConImagenesYBotones() {

		int contadorBoton = 0;
		botones = new JButton[fila][columna];
		for (int i = 0; i < fila; i++) {
			int contadorBoton2 = 0;
			for (int j = 0; j < columna; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setSize(50, 50);
				botones[i][j].setLocation(65 + contadorBoton2, 50 + contadorBoton);
				Panel.panel2.add(botones[i][j], 0);
				contadorBoton2 += 50;
			}
			contadorBoton += 50;
		}

		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				botones[i][j].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON1) {
							if (reloj == null) {
								reloj = new Cronometro();
							}
							boolean activado = true;
							for (int i = 0; i < fila; i++) {
								for (int j = 0; j < columna; j++) {
									if (e.getSource() == botones[i][j]) {
										contadorDeClicks++;
										botones[i][j].setVisible(false);
										matrizEtiquetas[i][j].setVisible(true);
										if(matriz[i][j] == 0) {
											casillerosVecinosVacios(i, j);
										}
										if (matriz[i][j] == 9) {
											for (int k = 0; k < fila; k++) {
												for (int h = 0; h < columna; h++) {
													if (matriz[k][h] == 9) {
														botones[k][h].setVisible(false);
														matrizEtiquetas[k][h].setVisible(true);
													}
												}
											}
											ganador = false;
											VentanaGameOver nueva = new VentanaGameOver();
											Ventana.ventana.setEnabled(false);
											reloj.apagarTimer();
										} else if (contadorDeClicks == (Panel.tamaño * Panel.tamaño - Panel.minas)) {
											ganador = true;
											VentanaGameOver nueva = new VentanaGameOver();
											Ventana.ventana.setEnabled(false);
											reloj.apagarTimer();
										}
									}
								}
							}
						}

						if (e.getButton() == MouseEvent.BUTTON3) {
							for (int i = 0; i < fila; i++) {
								for (int j = 0; j < columna; j++) {
									if (e.getSource() == botones[i][j]) {
										if (botones[i][j].getIcon() == null) {
											botones[i][j].setIcon(new ImageIcon(
													"imagenes/bandera.jpg"));
										} else {
											botones[i][j].setIcon(null);
										}

									}
								}
							}
						}
					}
				});
			}
		}

		matrizEtiquetas = new JLabel[fila][columna];
		int contador2 = 0;
		Ventana.ventana.setSize(fila * 50 + 140, columna * 50 + 140);
		

		for (int i = 0; i < fila; i++) {
			int contador = 0;
			for (int j = 0; j < columna; j++) {
				matrizEtiquetas[i][j] = new JLabel();
				matrizEtiquetas[i][j].setSize(50, 50);
				matrizEtiquetas[i][j].setLocation(65 + contador, 50 + contador2);
				int aux = matriz[i][j];
				String valor = String.valueOf(aux);
				matrizEtiquetas[i][j]
						.setIcon(new ImageIcon("imagenes/" + valor + ".jpg"));
				matrizEtiquetas[i][j].setVisible(false);
				Panel.panel2.add(matrizEtiquetas[i][j], 0);
				contador += 50;
			}
			contador2 += 50;
		}
	}

	public void casillerosVecinosVacios(int fila, int columna) {
		
			if (fila > 0) {
				if (matriz[fila - 1][columna] == 0) {
					if(botones[fila-1][columna].isVisible()) {
						botones[fila-1][columna].setVisible(false);
						matrizEtiquetas[fila-1][columna].setVisible(true);
						mostrarCasillasAlLadoDeVacio(fila-1,columna);
						casillerosVecinosVacios(fila-1,columna);
					}		
				}
			}
			if (fila > 0 && columna > 0) {
				if (matriz[fila - 1][columna - 1] == 0) {
					if(botones[fila-1][columna-1].isVisible()) {
						botones[fila-1][columna-1].setVisible(false);
						matrizEtiquetas[fila-1][columna-1].setVisible(true);
						mostrarCasillasAlLadoDeVacio(fila-1,columna-1);
						casillerosVecinosVacios(fila-1,columna-1);
					}
				}
			}
			if (fila > 0 && columna < this.columna - 1) {
				if (matriz[fila - 1][columna + 1] == 0) {
					if(botones[fila-1][columna+1].isVisible()) {
						botones[fila-1][columna+1].setVisible(false);
						matrizEtiquetas[fila-1][columna+1].setVisible(true);
						mostrarCasillasAlLadoDeVacio(fila-1,columna+1);
						casillerosVecinosVacios(fila-1,columna+1);
					}
				}
			}
			if (columna > 0 && fila < this.fila - 1) {
				if (matriz[fila + 1][columna - 1] == 0) {
					if(botones[fila+1][columna-1].isVisible()) {
						botones[fila+1][columna-1].setVisible(false);
						matrizEtiquetas[fila+1][columna-1].setVisible(true);
						mostrarCasillasAlLadoDeVacio(fila+1,columna-1);
						casillerosVecinosVacios(fila+1,columna-1);
					}
				}
			}
			if (fila < this.fila - 1 && columna < this.columna - 1) {
				if (matriz[fila + 1][columna + 1] == 0) {
					if(botones[fila+1][columna+1].isVisible()) {
					botones[fila+1][columna+1].setVisible(false);
					matrizEtiquetas[fila+1][columna+1].setVisible(true);
					mostrarCasillasAlLadoDeVacio(fila+1,columna+1);
					casillerosVecinosVacios(fila+1,columna+1);
					}
				}
			}
			if (fila < this.fila - 1) {
				if (matriz[fila + 1][columna] == 0) {
					if(botones[fila+1][columna].isVisible()) {
					botones[fila+1][columna].setVisible(false);
					matrizEtiquetas[fila+1][columna].setVisible(true);
					mostrarCasillasAlLadoDeVacio(fila+1,columna);
					casillerosVecinosVacios(fila+1,columna);
					}
				}
			}
			if (columna > 0) {
				if (matriz[fila][columna-1] == 0) {
					if(botones[fila][columna-1].isVisible()) {
					botones[fila][columna-1].setVisible(false);
					matrizEtiquetas[fila][columna-1].setVisible(true);
					mostrarCasillasAlLadoDeVacio(fila,columna-1);
					casillerosVecinosVacios(fila,columna-1);
					}
				}
			}
			if (columna < this.columna - 1) {
				if (matriz[fila][columna+1] == 0) {
					if(botones[fila][columna+1].isVisible()) {
					botones[fila][columna+1].setVisible(false);
					matrizEtiquetas[fila][columna+1].setVisible(true);
					mostrarCasillasAlLadoDeVacio(fila,columna+1);
					casillerosVecinosVacios(fila,columna+1);
					}
				}
			}
		}
	
	public void mostrarCasillasAlLadoDeVacio(int fila, int columna) {
		
		if (fila > 0) {
			if (matriz[fila - 1][columna] != 0) {
				if(botones[fila-1][columna].isVisible()) {
					botones[fila-1][columna].setVisible(false);
					matrizEtiquetas[fila-1][columna].setVisible(true);
				}		
			}
		}
		if (fila > 0 && columna > 0) {
			if (matriz[fila - 1][columna - 1] != 0) {
				if(botones[fila-1][columna-1].isVisible()) {
					botones[fila-1][columna-1].setVisible(false);
					matrizEtiquetas[fila-1][columna-1].setVisible(true);
				}
			}
		}
		if (fila > 0 && columna < this.columna - 1) {
			if (matriz[fila - 1][columna + 1] != 0) {
				if(botones[fila-1][columna+1].isVisible()) {
					botones[fila-1][columna+1].setVisible(false);
					matrizEtiquetas[fila-1][columna+1].setVisible(true);
				}
			}
		}
		if (columna > 0 && fila < this.fila - 1) {
			if (matriz[fila + 1][columna - 1] != 0) {
				if(botones[fila+1][columna-1].isVisible()) {
					botones[fila+1][columna-1].setVisible(false);
					matrizEtiquetas[fila+1][columna-1].setVisible(true);
				}
			}
		}
		if (fila < this.fila - 1 && columna < this.columna - 1) {
			if (matriz[fila + 1][columna + 1] != 0) {
				if(botones[fila+1][columna+1].isVisible()) {
				botones[fila+1][columna+1].setVisible(false);
				matrizEtiquetas[fila+1][columna+1].setVisible(true);
				}
			}
		}
		if (fila < this.fila - 1) {
			if (matriz[fila + 1][columna] != 0) {
				if(botones[fila+1][columna].isVisible()) {
				botones[fila+1][columna].setVisible(false);
				matrizEtiquetas[fila+1][columna].setVisible(true);
				}
			}
		}
		if (columna > 0) {
			if (matriz[fila][columna-1] != 0) {
				if(botones[fila][columna-1].isVisible()) {
				botones[fila][columna-1].setVisible(false);
				matrizEtiquetas[fila][columna-1].setVisible(true);
				}
			}
		}
		if (columna < this.columna - 1) {
			if (matriz[fila][columna+1] != 0) {
				if(botones[fila][columna+1].isVisible()) {
				botones[fila][columna+1].setVisible(false);
				matrizEtiquetas[fila][columna+1].setVisible(true);
				}
			}
		}
		
		
	}
	
	}

