import interfaces.IPlayer;

public class Player implements IPlayer {
	private int GemasAtual;
	private int GemasTotal;
	
	public int getGemasAtual() {
		return GemasAtual;
	}

	public int getGemasTotal() {
		return GemasTotal;
	}

	public void setGemasAtual(int GemasAtual) {
		this.GemasAtual=GemasAtual;
	}

	public void setGemasTotal(int GemasTotal) {
		this.GemasTotal=GemasTotal;
	}
}