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
	
	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public int getGemasAtual() {
		return gemasAtual;
	}

	@Override
	public int getGemasTotal() {
		return gemasTotal;
	}

	@Override
	public void setGemasAtual(int gemasAtual) {
		this.gemasAtual = gemasAtual;
	}

	@Override
	public void setGemasTotal(int gemasTotal) {
		this.gemasTotal = gemasTotal;
	}
}