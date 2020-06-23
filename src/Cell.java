import interfaces.ICell;
import interfaces.IConteudo;

public class Cell implements ICell {
IConteudo Conteudo;
boolean Revelada;
	public IConteudo getConteudo() {
		return Conteudo;
	}

	public boolean getRevelada() {
		return Revelada;
	}
	public void setRevelada(boolean Revelada) {
		this.Revelada=Revelada;

	}
	public void setConteudo(IConteudo conteudo) {
		this.Conteudo=conteudo;
	}

}
