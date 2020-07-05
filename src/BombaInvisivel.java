import interfaces.IConteudo;

public class BombaInvisivel implements IConteudo {
	@Override
	public boolean visivel() {
		return false;
	}
}