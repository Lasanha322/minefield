public class minefield {
	
	public static void main(String[] args) {
		boolean runGame = true;
		String LastAction;
		Settings Configuracao = new Settings();
		GUI Janela = new GUI();	
		
		Janela.imprimirMenuInicial();
		while (runGame) {
			synchronized (Janela) {
				try {
					Janela.wait(); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}
			
			LastAction = Janela.getLastAction();
				
			switch(LastAction) {
			case "start":
				Janela.imprimirGame(new Game(Configuracao));
				break;
			case "settings":
				Janela.imprimirSettings(Configuracao);
				break;
			case "exit":
				Janela.setVisible(false);
				runGame = false;
				break;
			default:
				break;
			}
		}
	}
}