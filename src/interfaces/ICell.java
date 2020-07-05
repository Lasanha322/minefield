package interfaces;

public interface ICell {	
	public void setExaminada(boolean examinada);
	public void setRevelada(boolean revelada);
	public void setConteudo(IConteudo conteudo);
	public boolean examinada();
	public boolean revelada();
	public IConteudo getConteudo();
}