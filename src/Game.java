import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import interfaces.IBoard;
import interfaces.IGUI;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;

public class Game implements IGame {
	private ISettings Configuracao;
	private IBoard Tabuleiro; 
	private IPlayer[] Jogadores;
	
	public void esperarJogada() {
	}

	
	public void verificarJogada() {
	}

	
	public void verificarFinal() {
	}
	
	public static void main(String[] args) {
		int ScanFrequency = 24;
		boolean runGame = true;
		Timer gameScan = new Timer(1/(ScanFrequency*1000), null);
		IGUI GUI = new GUI();
		ISettings Configuracao = new Settings();
		
		GUI.imprimirMenuInicial();	
		while(runGame) {
			if (GUI.getLastAction() == "start") {
				GUI.imprimirGame(new Game());
			} else if (GUI.getLastAction() == "settings") {
				GUI.imprimirSettings(Configuracao);
			} else if (GUI.getLastAction() == "exit") {
				runGame = false;
			}
		}
	}
}