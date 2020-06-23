import interfaces.ICell;
import interfaces.IConteudo;

public class Cell implements ICell {
	private IConteudo Conteudo;
	private boolean Revelada;
	
	@Override
	public IConteudo getConteudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getRevelada() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRevelada(boolean Revelada) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConteudo(IConteudo conteudo) {
		// TODO Auto-generated method stub
		
	}
}