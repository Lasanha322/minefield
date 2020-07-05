import interfaces.IPlayer;

public class Player implements IPlayer {
	private int ID;
	private int gemasAtual;
	private int gemasTotal;
	
	public Player(int ID) {
		this.ID = ID;
		gemasAtual = 0;
		gemasTotal = 0;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getGemasAtual() {
		return gemasAtual;
	}

	public int getGemasTotal() {
		return gemasTotal;
	}

	public void setGemasAtual(int gemasAtual) {
		this.gemasAtual = gemasAtual;
	}

	public void setGemasTotal(int gemasTotal) {
		this.gemasTotal = gemasTotal;
	}
}