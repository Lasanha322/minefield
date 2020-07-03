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
	
	public Game(ISettings Configuracao) {
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
	public ISettings getSettings() {
		return Configuracao;
	}
	
	public IBoard getBoard() {
		return Tabuleiro;
	}
	
	public IPlayer[] getPlayers() {
		return Jogadores;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}