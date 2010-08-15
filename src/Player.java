
public class Player extends Entity{
	private final static double strMod=.25;
	private int exp;
	private int lvl;
	
	public Player(int initAgi, int initStr, int initCon,String name) {
		super(initAgi, initStr, initCon, name);
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

	
	public int useWeapon(Weapon weapon,Entity target){
		if (aimWeapon(weapon,target)){
			int dmg=dmgWeapon(weapon);
			target.takeDmg(dmg);
			return dmg;
		}
		else return 0;
	}
	
	public int dmgWeapon(Weapon weapon){
		return (int) (getStr()*strMod+weapon.damage());
	}
	
	public boolean aimWeapon(Weapon weapon,Entity target){
		if (weapon.isUsable()){
			return weapon.aim(getAgi(),target.getAgi());
		}
		else{
			return false;
		}
	}
	
}
