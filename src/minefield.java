import interfaces.IGUI;
import interfaces.ISettings;

public class minefield {	
	public static void main(String[] args) {
		boolean runGame = true;
		IGUI GUI = new GUI();
		ISettings Configuracao = new Settings();
		
		GUI.imprimirMenuInicial();	
		while(runGame) {
			if (GUI.getLastAction() == "start") {
				GUI.imprimirGame(new Game(Configuracao));
			} else if (GUI.getLastAction() == "settings") {
				GUI.imprimirSettings(Configuracao);
			} else if (GUI.getLastAction() == "exit") {
				runGame = false;
			}
		}
	}
}
