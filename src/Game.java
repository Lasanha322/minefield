import java.awt.event.ActionEvent;
import interfaces.IBoard;
import interfaces.ICell;
import interfaces.IGUI;
import interfaces.IGame;
import interfaces.IPlayer;
import interfaces.ISettings;

public class Game implements IGame {
	private int contador;
	private int turno;
	private int celulasReveladas;
	private int skillModifier;
	private IGUI Graficos;
	private ISettings Configuracao;
	private IBoard Tabuleiro; 
	private IPlayer[] Jogadores;
	private IPlayer Vencedor;
	
	public Game(IGUI Graficos) {
		this.Graficos = Graficos;
		
		contador = 0;
		turno = 0;
		celulasReveladas = 0;
		Configuracao = Graficos.getSettings();
		Tabuleiro = new Board((int)Math.pow(Configuracao.getTamanhoDoTabuleiro(), 2), Configuracao.getNumeroDeGemas());
		Jogadores = new Player[Configuracao.getNumeroDeJogadores()];
		for(int i = 0; i < Configuracao.getNumeroDeJogadores(); i++) {
			Jogadores[i] = new Player(i + 1);
		}
		Vencedor = Jogadores[0];
		
		Graficos.imprimirGame(this);
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
	public int proximoTurno() {
		if (turno + 1 >= Configuracao.getNumeroDeJogadores())
			return 0;
		else
			return turno+1;
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
	public IPlayer getWinner() {
		return Vencedor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if (action.startsWith("skill")) {
			skillModifier = action.toCharArray()[5] - '0';
			System.out.println("Skill Modifier changed to " + skillModifier);
			
			if (skillModifier == 5) {
				//A Skill 5 eh a unica que tem efeito logo quando voce a seleciona			
				encontrarGema();
				skillModifier = 0;
				Jogadores[turno].setGemasAtual(Jogadores[turno].getGemasAtual() - 5);				
			}
		} else {
			int number = Integer.parseInt(action);
			
			switch(skillModifier) {
			case 1:
				//Revela 4 celulas do campo
				revelarCelula(Tabuleiro.getCell(number));
				contador++;
				if (contador >= 4 || acabou()) {
					contador = 0;
					Jogadores[turno].setGemasAtual(Jogadores[turno].getGemasAtual() - 1);
					skillModifier = 0;
					turno = proximoTurno();
				}
				break;
			case 2:
				//Examina uma celula e ainda permite revelar o conteudo de qualquer celula
				if (contador == 0) {
					examinarCelula(Tabuleiro.getCell(number));
					contador++;
					Jogadores[turno].setGemasAtual(Jogadores[turno].getGemasAtual() - 2);
				} else {
					revelarCelula(Tabuleiro.getCell(number));
					contador = 0;
					skillModifier = 0;
					turno = proximoTurno();
				}
				break;
			case 3:
				//Coloca uma bomba em uma celula
				colocarBomba(Tabuleiro.getCell(number), true);
				Jogadores[turno].setGemasAtual(Jogadores[turno].getGemasAtual() - 3);
				skillModifier = 0;
				turno = proximoTurno();
				break;
			case 4:
				//Coloca uma bomba INVISIVEL em uma celula
				colocarBomba(Tabuleiro.getCell(number), false);
				Jogadores[turno].setGemasAtual(Jogadores[turno].getGemasAtual() - 4);
				skillModifier = 0;
				turno = proximoTurno();
				break;
			default:
				revelarCelula(Tabuleiro.getCell(number));
				turno = proximoTurno();
				break;
			}			
		}	
		
		if (acabou()) {
			Graficos.imprimirWinner(Vencedor);
		}
	}

	private void revelarCelula(ICell Cell) {
		celulasReveladas++;		
		Cell.setExaminada(true);
		
		String conteudo = Cell.getConteudo().getClass().getName();		
		switch (conteudo) {
		case "Gema":
			Jogadores[turno].setGemasAtual(Jogadores[turno].getGemasAtual() + 1);
			Jogadores[turno].setGemasTotal(Jogadores[turno].getGemasTotal() + 1);
			break;
		case "Bomba":
			Jogadores[turno].setGemasAtual(0);
			break;
		default:
			break;
		}
		
		if (Configuracao.getGanhaQuemPegouMais()) {
			if (Jogadores[turno].getGemasTotal() > Vencedor.getGemasTotal())
				Vencedor = Jogadores[turno];
		} else if (Configuracao.getGanhaQuemTemMais()) {
			if (Jogadores[turno].getGemasAtual() > Vencedor.getGemasAtual())
				Vencedor = Jogadores[turno];
		}

		System.out.println(conteudo);
	}
	
	private void examinarCelula(ICell Cell) {
		if (Cell.getConteudo().visivel()) {
			Cell.setExaminada(true);
			System.out.println("Tem um " + Cell.getConteudo().getClass().getName() + " escondido!");			
		}
	}	

	private void colocarBomba(ICell Cell, boolean visivel) {
		if (visivel)
			Cell.setConteudo(new Bomba());
		else
			Cell.setConteudo(new BombaInvisivel());
		System.out.println("Bomba colocada!");
	}
	
	private void encontrarGema() {
		boolean achou = false;
		int tamanhoDoTabuleiro = (int)Math.pow(Configuracao.getTamanhoDoTabuleiro(), 2);
		String conteudo;
		for (int i = 0; achou == false || i >= tamanhoDoTabuleiro ; i++) {
			conteudo = Tabuleiro.getCell(i).getConteudo().getClass().getName();
			if (conteudo == "Gema") {
				achou = true;
				Tabuleiro.getCell(i).setExaminada(true);
				System.out.println("Gema encontrada!");
			}
		}
	}
}