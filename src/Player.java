
public class Player {
	private int agi;
	private int str;
	private int con;
	
	
	public Player(int initAgi, int initStr, int initCon) {
		agi=initAgi;
		str=initStr;
		con=initCon;
		// TODO Auto-generated constructor stub
	}

	public String printStats(){
		String stats=new String("AGI: ");
		
		for (int i=1;i<=agi;i++){
			stats+="=";
		}

		stats+="\nSTR: ";

		for (int i=1;i<=str;i++){
			stats+="=";
		}
		
		stats+="\nCON: ";
		
		for (int i=1;i<=con;i++){
			stats+="=";
		}
		
		return stats;
	}

}
