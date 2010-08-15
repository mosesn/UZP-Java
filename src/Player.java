
public class Player extends Entity{
	private int exp;
	private int lvl;
	
	public Player(int initAgi, int initStr, int initCon) {
		super(initAgi, initStr, initCon);
		exp=0;
		lvl=1;
	}
	
	public boolean addExp(int numPts){
		exp+=numPts;
		if (exp>=10*square(lvl)){
			lvl++;
			return true;
		}
		else return false;
	}
	
	public int expToLvl(){
		return (int) (10.0*square(lvl)-exp);
	}

	public int getExp(){
		return exp;
	}

}
