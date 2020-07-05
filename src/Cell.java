import interfaces.ICell;
import interfaces.IConteudo;

public class Cell implements ICell {
	private boolean examinada;
	private boolean revelada;
	private IConteudo Conteudo;

	public Cell() {
		examinada = false;
		revelada = false;
		Conteudo = new Vazio();
	}
	
	@Override
	public void setExaminada(boolean examinada) {
		this.examinada = examinada;
	}
	
	@Override
	public void setRevelada(boolean revelada) {
		this.revelada = revelada;
	}
	
	@Override
	public void setConteudo(IConteudo conteudo) {
		this.Conteudo = conteudo;
	}
	
	@Override
	public boolean examinada() {
		return examinada;
	}
	
	@Override
	public boolean revelada() {
		return revelada;
	}
	
	@Override
	public IConteudo getConteudo() {
		return Conteudo;
	}	
}