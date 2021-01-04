package utilidades;

public class Utilidad {
	// TODO este método podría tener salto de línea, para no tener que agregarlo
	// desde afuera
	public static void showMessagePredefined() {
		System.out.print("--------------------------------------- \n");
	}
	
	public static void showMessage(String message) {
		System.out.print(message);
	}

	public static void stopAndContinue() {
		timeToWait();
		cleanScreen();
	}

	public static void cleanScreen() {
		for (int i = 0; i < 10; i++) {
			Utilidad.showMessage("");
		}
		System.out.flush();
	}

	public static void timeToWait() {
		int timeWait = 10; // Segundos
		try {
			for (int i = 0; i < timeWait; i++) {
				Thread.sleep(150);
			}
		} catch (InterruptedException ie) {
			showMessage("Tiempo de espera interrumpido");
		}
	}
}
