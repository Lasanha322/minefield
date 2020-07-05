package interfaces;

public interface ICell {	
	public void setExaminada(boolean examinada);
	public void setConteudo(IConteudo conteudo);
	public boolean examinada();
	public IConteudo getConteudo();
}