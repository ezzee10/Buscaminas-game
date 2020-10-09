import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Cronometro {

	static int cronometro = 0;
	private static Cronometro crono;
	Timer timer = new Timer();

	public Cronometro() {
		encenderTimer();
	}
	
	public void encenderTimer() {

		TimerTask task = new TimerTask() {
			

			@Override
			public void run() {
				Panel.reloj.setText("Tiempo: "+String.valueOf(cronometro));
				Panel.cantMinas.setText("Minas: "+ Matriz.minas);
				cronometro++;
			}
		};

		timer.schedule(task, 0, 1000);
	}
	
	public void apagarTimer() {
		timer.cancel();
	}
}
