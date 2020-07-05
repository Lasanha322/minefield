import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import interfaces.ISettings;

public class Settings implements ISettings {
	private boolean GanhaQuemTemMais;
	private boolean GanhaQuemPegouMais;
	private int NumeroDeJogadores;
	private int TamanhoDoTabuleiro;
	private int NumeroDeGemas;
	private int windowWidth;
	private int windowHeight;
	
	public Settings() {
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
			System.out.println(e.getMessage());			
			try {
				FileWriter newSettingsFile = new FileWriter("settings.txt");
				newSettingsFile.append("2\n");
				newSettingsFile.append("6\n");
				newSettingsFile.append("18\n");
				newSettingsFile.append("true\n");
				newSettingsFile.append("false\n");
				newSettingsFile.append("1280\n");
				newSettingsFile.append("720\n");
				newSettingsFile.flush();
				newSettingsFile.close();
				System.out.println("A new settings.txt file with the default settings was created successfully.");
			} catch (IOException e1) {
				System.out.println("Could not create a settings.txt file!");
			}
			
			NumeroDeJogadores = 2;
			TamanhoDoTabuleiro = 6;
			NumeroDeGemas = 18;
			GanhaQuemTemMais = true;
			GanhaQuemPegouMais = false;
			windowWidth = 1280;
			windowHeight = 720;
		}
	}

	@Override
	public boolean getGanhaQuemTemMais() {
		return GanhaQuemTemMais;
	}

	@Override
	public boolean getGanhaQuemPegouMais() {
		return GanhaQuemPegouMais;
	}
	
	@Override
	public int getNumeroDeJogadores() {
		return NumeroDeJogadores ;
	}

	@Override
	public int getTamanhoDoTabuleiro() {
		return TamanhoDoTabuleiro;
	}

	@Override
	public int getNumeroDeGemas() {
		return NumeroDeGemas;
	}
	
	@Override
	public int getWindowWidth() {
		return windowWidth;
	}
	
	@Override
	public int getWindowHeight() {
		return windowHeight;
	}

	@Override
	public void setGanhaQuemTemMais(boolean thisCondition) {
		GanhaQuemTemMais = thisCondition;
	}

	@Override
	public void setGanhaQuemPegouMais(boolean thisCondition) {
		GanhaQuemPegouMais = thisCondition;
	}
	
	@Override
	public void setNumeroDeJogadores(int n) {
		NumeroDeJogadores = n;
	}

	@Override
	public void setTamanhoDoTabuleiro(int n) {
		TamanhoDoTabuleiro = n;
	}

	@Override
	public void setNumeroDeGemas(int n) {
		NumeroDeGemas = n;
	}
	
	@Override
	public void setWindowWidth(int newWidth) {
		windowWidth = newWidth;
	}
	
	@Override
	public void setWindowHeight(int newHeight) {
		windowHeight = newHeight;
	}
}