import java.awt.event.ActionEvent;
import interfaces.IBoard;
import interfaces.IGUI;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;

public class Game implements IGame {
	private int turno;
	private int celulasReveladas;
	private IPlayer vencedor;
	private IGUI Graficos;
	private ISettings Configuracao;
	private IBoard Tabuleiro; 
	private IPlayer[] Jogadores;
	
	public Game(IGUI Graficos) {
		this.turno = 0;
		this.celulasReveladas = 0;
		this.Graficos = Graficos;
		this.Configuracao = Graficos.getSettings();
		this.Tabuleiro = new Board((int)Math.pow(Configuracao.getTamanhoDoTabuleiro(), 2), Configuracao.getNumeroDeGemas());
		this.Jogadores = new Player[Configuracao.getNumeroDeJogadores()];
		for(int i = 0; i < Configuracao.getNumeroDeJogadores(); i++) {
			Jogadores[i] = new Player(i + 1);
		}
		this.vencedor = Jogadores[0];
		
		Graficos.imprimirGame(this);
	}

	public void esperarJogada() {/*
		synchronized(Graficos) {
			try {
				Graficos.wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				System.out.println("An unexpected error happened and the game will be closed.");
			}			
		}*/
	}
	
	public void verificarJogada() {
	}

	
	public void verificarFinal() {
	}
	
	public int proximoTurno() {
		return (turno+1)%Configuracao.getNumeroDeJogadores();
	}
	
	@Override
	public boolean acabou() {
		if (celulasReveladas >= (int)Math.pow(Configuracao.getTamanhoDoTabuleiro(), 2))
			return true;
		else
			return false;
	}
	
	@Override
	public int getTurno() {
		return turno;
	}
	
	@Override
	public ISettings getSettings() {
		return Configuracao;
	}
	
	@Override
	public IBoard getBoard() {
		return Tabuleiro;
	}
	
	@Override
	public IPlayer[] getPlayers() {
		return Jogadores;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		synchronized(this) {			
			int gemasAtual = Jogadores[turno].getGemasAtual();
			int gemasTotal = Jogadores[turno].getGemasTotal();
			String conteudo = Tabuleiro.getCell(Integer.parseInt(e.getActionCommand())).getConteudo().getClass().getName();
			System.out.println(conteudo);
			
			switch (conteudo) {
			case "Gema":
				gemasAtual++;
				gemasTotal++;
				Jogadores[turno].setGemasAtual(gemasAtual);
				Jogadores[turno].setGemasTotal(gemasTotal);
				break;
			case "Bomba":
				Jogadores[turno].setGemasAtual(0);
				break;
			default:
				break;
			}
			
			if (Configuracao.getGanhaQuemPegouMais()) {
				if (Jogadores[turno].getGemasTotal() > vencedor.getGemasTotal())
					vencedor = Jogadores[turno];
			} else if (Configuracao.getGanhaQuemTemMais()) {
				if (Jogadores[turno].getGemasAtual() > vencedor.getGemasAtual())
					vencedor = Jogadores[turno];
			}
			
			celulasReveladas++;
			if (acabou()) {
				Graficos.imprimirVencedor(vencedor);
			} else {
				turno = proximoTurno();				
			}						
		}
	}

	@Override
	public IPlayer getVencedor() {
		return vencedor;
	}
}