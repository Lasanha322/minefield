import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.IBoard;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;

public class Game implements IGame, ActionListener {
	private ISettings Configuracao;
	private IBoard Tabuleiro; 
	private IPlayer[] Jogadores;
	
	Game(ISettings Configuracao) {
		this.Configuracao = Configuracao;
		this.Tabuleiro = new Board(Configuracao.getTamanhoDoTabuleiro());
		this.Jogadores = new Player[Configuracao.getNumeroDeJogadores()];		
	}
	
	public void esperarJogada() {
	}

	
	public void verificarJogada() {
	}

	
	public void verificarFinal() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
