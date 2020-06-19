import interfaces.IPlayer;

public class Player implements IPlayer {
int GemasAtual;
int GemasTotal;
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
