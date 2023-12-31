public class GenshinCalc {
	public DataBase dataBase;

	public GenshinCalc(DataBase in){
		dataBase = in;
	}

	public void printBossAndWMNum(){
		for (int i = 0; i < dataBase.getBossSize(); i = i + 1){
			System.out.printf("%s: %d\n", dataBase.getBossName(i), dataBase.getAllMaterial(i));
		}
	}

	public void subCharSkill(String name, int s1, int s2, int s3, int level){
		int index = -1, charID = -1;

		for (int i = 0; i < dataBase.getBossSize(); i = i + 1){
			for (int j = 0; j < dataBase.getCharSize(i); j = j + 1){
				if (dataBase.getCharName(i, j).equals(name)){
					index = i;
					charID = j;
				}
			}
		}
		if (index == -1){
			System.out.printf("[Exception] NameNotFoundException(%s)\n", name);
			return;
		}

		dataBase.subSkillLevel(index, charID, s1, s2, s3, level);
	}

	public void subCharSkillFromCSV(String [][] csv, int level){
		if (csv == null){
			return;
		}

		for (String[] strings : csv) {
			subCharSkill(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), level);
		}
	}

	public static int getDefaultMaterialSize(int n){
		if (((n < 1) || (n > 10)) || n <= 6){
			return 0;
		}
		return switch (n) {
			case 7 -> 3;
			case 8 -> 6;
			case 9 -> 12;
			default -> 18;
		};
	}
}
