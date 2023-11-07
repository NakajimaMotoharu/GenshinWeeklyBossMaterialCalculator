import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadCSV {
	List<String>lines = null;
	List<String>chars = null;

	public ReadCSV(){
	}

	public void readMaterial(String fileName){
		Path path = Paths.get(fileName);

		try {
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.printf("[Exception] MaterialFileNotFoundException(%s)\n", fileName);
			System.exit(1);
		}
	}

	public void readChars(String fileName){
		Path path = Paths.get(fileName);

		try {
			chars = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.printf("[Exception] SkillFileNotFoundException(%s)\n", fileName);
			System.exit(1);
		}
	}

	public DataBase getData(){
		if (lines == null){
			return null;
		}
		DataBase dataBase = new DataBase(lines.size());
		for (int i = 0; i < lines.size(); i = i + 1){
			dataBase.setNames(lines.get(i).split(","), i);
		}

		return dataBase;
	}

	public String[][] getChars(){
		if (chars == null){
			return null;
		}

		String[][] ans = new String[chars.size()][];

		for (int i = 0; i < chars.size(); i = i + 1){
			ans[i] = chars.get(i).split(",");
		}

		return ans;
	}
}
