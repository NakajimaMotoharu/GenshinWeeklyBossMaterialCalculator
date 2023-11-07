public class DataBase {
	private final String[] bossName;
	private final String[][] charName;
	private final int[][] materialNum;

	public DataBase(int bossNum){
		bossName = new String[bossNum];
		charName = new String[bossNum][];
		materialNum = new int[bossNum][];
	}

	public void setNames(String[] data, int index){
		bossName[index] = data[1];
		int charSize = data.length - 2;
		charName[index] = new String[charSize];
		materialNum[index] = new int[charSize];
		for (int i = 0; i < charName[index].length; i = i + 1){
			charName[index][i] = data[i + 2];
			materialNum[index][i] = 18;
		}
	}

	public String toCharName(int index){
		String ans = "", tmp;

		for (int i = 0; i < charName[index].length; i = i + 1){
			if (i + 1 == charName[index].length){
				tmp = ans + charName[index][i];
			} else {
				tmp = ans + charName[index][i] + ", ";
			}
			ans = tmp;
		}

		return ans;
	}

	public int getCharSize(int index){
		return charName[index].length;
	}

	public int getBossSize(){
		return bossName.length;
	}

	public String getBossName(int index){
		return bossName[index];
	}

	public int getMaterialNum(int index, int charID){
		return materialNum[index][charID];
	}

	public void subMaterialNum(int index, int charID, int sub){
		materialNum[index][charID] = materialNum[index][charID] - sub;
	}

	public String getCharName(int index, int charID){
		return charName[index][charID];
	}

	public int getAllMaterial(int index){
		int ans = 0;
		for (int i = 0; i < materialNum[index].length; i = i + 1){
			ans = ans + materialNum[index][i];
		}
		return ans;
	}

	public void subSkillLevel(int index, int charID, int s1, int s2, int s3){
		int m1 = 0, m2 = 0, m3 = 0;
		switch (s1) {
			case 7 -> m1 = 1;
			case 8 -> m1 = 2;
			case 9 -> m1 = 4;
			case 10 -> m1 = 6;
		}
		switch (s2) {
			case 7 -> m2 = 1;
			case 8 -> m2 = 2;
			case 9 -> m2 = 4;
			case 10 -> m2 = 6;
		}
		switch (s3) {
			case 7 -> m3 = 1;
			case 8 -> m3 = 2;
			case 9 -> m3 = 4;
			case 10 -> m3 = 6;
		}

		subMaterialNum(index, charID, m1 + m2 + m3);
	}
}
