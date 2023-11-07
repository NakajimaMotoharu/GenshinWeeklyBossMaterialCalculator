public class Main {
	public static void main(String[] args) {
		ReadCSV readCSV = new ReadCSV();
		if (args[0] == null){
			System.out.println("<program> <Material.csv> <Skill.csv>");
			return;
		}
		readCSV.readMaterial(args[0]);

		if (args[1] != null) {
			readCSV.readChars(args[1]);
		}

		DataBase dataBase = readCSV.getData();
		GenshinCalc genshinCalc = new GenshinCalc(dataBase);
		genshinCalc.subCharSkillFromCSV(readCSV.getChars());
		genshinCalc.printBossAndWMNum();
	}
}
