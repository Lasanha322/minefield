public class minefield {
	
	public static void main(String[] args) {
		//Inicializamos o programa
		String LastAction;
		GUI Janela = new GUI();
		Janela.imprimirStart();
		
		//Rodamos esse loop enquanto o programa estiver aberto
		boolean runGame = true;
		while (runGame) {
			synchronized (Janela) {
				try {
					Janela.wait(); 
				} catch (InterruptedException e) {
					runGame = false;
					System.out.println(e.getMessage());
					System.out.println("An unexpected error happened and the game will be closed.");
				}			
			}
			
			LastAction = Janela.getLastAction();
				
			switch(LastAction) {
			case "start":
				Janela.imprimirStart();
				break;
			case "game":
				new Game(Janela);
				break;
			case "settings":
				Janela.imprimirSettings();
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