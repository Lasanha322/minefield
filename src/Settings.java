import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import interfaces.ISettings;

public class Settings implements ISettings {
	private int NumeroDeJogadores;
	private int TamanhoDoTabuleiro;
	private int NumeroDeGemas;
	private boolean GanhaQuemTemMais;
	private boolean GanhaQuemPegouMais;
	private int windowWidth;
	private int windowHeight;
	
	Settings(){
		try {
			BufferedReader settingsFile = new BufferedReader(new FileReader("settings.txt"));
			
			ArrayList<String> settingsData = new ArrayList<String>();
			int i = -1;
			do {
				i++;
				settingsData.add(settingsFile.readLine());
			} while (settingsData.get(i) != null);
			
			NumeroDeJogadores = Integer.parseInt(settingsData.get(0));
			TamanhoDoTabuleiro = Integer.parseInt(settingsData.get(1));
			NumeroDeGemas = Integer.parseInt(settingsData.get(2));
			GanhaQuemTemMais = Boolean.parseBoolean(settingsData.get(3));
			GanhaQuemPegouMais = Boolean.parseBoolean(settingsData.get(4));
			windowWidth = Integer.parseInt(settingsData.get(5));
			windowHeight = Integer.parseInt(settingsData.get(6));
			settingsFile.close();
		} catch (IndexOutOfBoundsException | NumberFormatException | IOException e) {
			e.getMessage();			
			try {
				FileWriter newSettingsFile = new FileWriter("settings.txt");
				newSettingsFile.append("1\n");
				newSettingsFile.append("10\n");
				newSettingsFile.append("25\n");
				newSettingsFile.append("true\n");
				newSettingsFile.append("false\n");
				newSettingsFile.append("640\n");
				newSettingsFile.append("360\n");
				newSettingsFile.flush();
				newSettingsFile.close();
			} catch (IOException e1) {
				System.out.println("Could not create a settings.txt file!");
			}
			
			NumeroDeJogadores = 1;
			TamanhoDoTabuleiro = 10;
			NumeroDeGemas = 25;
			GanhaQuemTemMais = true;
			GanhaQuemPegouMais = false;
			windowWidth = 640;
			windowHeight = 360;
		}
	}
	
	public int getNumeroDeJogadores() {
		return NumeroDeJogadores ;
	}

	public int getTamanhoDoTabuleiro() {
		return TamanhoDoTabuleiro;
	}

	public int getNumeroDeGemas() {
		return NumeroDeGemas;
	}

	public boolean getGanhaQuemTemMais() {
		return GanhaQuemTemMais;
	}

	public boolean getGanhaQuemPegouMais() {
		return GanhaQuemPegouMais;
	}
	
	public int getWindowWidth() {
		return windowWidth;
	}
	
	public int getWindowHeight() {
		return windowHeight;
	}

	public void setNumeroDeJogadores(int n) {
		NumeroDeJogadores = n;
	}

	public void setTamanhoDoTabuleiro(int n) {
		TamanhoDoTabuleiro = n;
	}

	public void setNumeroDeGemas(int n) {
		NumeroDeGemas = n;
	}

	public void setGanhaQuemTemMais(boolean thisCondition) {
		GanhaQuemTemMais = thisCondition;
	}

	public void setGanhaQuemPegouMais(boolean thisCondition) {
		GanhaQuemPegouMais = thisCondition;
	}
	
	public void setWindowWidth(int newWidth) {
		windowWidth = newWidth;
	}
	
	public void setWindowHeight(int newHeight) {
		windowHeight = newHeight;
	}
}