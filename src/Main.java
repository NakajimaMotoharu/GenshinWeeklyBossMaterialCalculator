public class Main {
	public static void main(String[] args) {
		ReadCSV readCSV = new ReadCSV();
		if (args.length < 2){
			System.out.println("<program> <level> <Material.csv> <Skill.csv>");
			return;
		}
		int level = 1;
		try {
			level = Integer.parseInt(args[0]);
		} catch (Exception e){
			System.out.printf("[Exception] NotAnIntegerException(%s)\n", args[0]);
			System.exit(1);
		}
		readCSV.readMaterial(args[1]);

		if (args[1] != null) {
			readCSV.readChars(args[2]);
		}

		DataBase dataBase = readCSV.getData(level);
		GenshinCalc genshinCalc = new GenshinCalc(dataBase);
		genshinCalc.subCharSkillFromCSV(readCSV.getChars(), level);
		genshinCalc.printBossAndWMNum();
	}
}
