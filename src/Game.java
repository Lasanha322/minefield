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
	
	public int proximoTurno() {
		if (turno + 1 >= Configuracao.getNumeroDeJogadores())
			return 0;
		else
			return turno+1;
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
	public IPlayer getVencedor() {
		return vencedor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int gemasAtual = Jogadores[turno].getGemasAtual();
		int gemasTotal = Jogadores[turno].getGemasTotal();
		
		if (e.getActionCommand().startsWith("skill")) {
			int skillCost = e.getActionCommand().toCharArray()[5] - '0';
			
			switch(skillCost) {
			case 1:
				gemasAtual--;
				Jogadores[turno].setGemasAtual(gemasAtual);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				break;
			}
		} else {
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
				Graficos.imprimirWinner(vencedor);
			} else {
				turno = proximoTurno();				
			}	
		}
	}
}