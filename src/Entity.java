
public class Entity {
	private final static double strMod=.25;
	private final static double hpMod=.5;
	private final static double conMod=1.25;
	private final static double agiMod=.1;
	private int agi;
	private int str;
	private int con;
	private int exp;
	private int lvl;
	private int hp;
	private boolean alive;
	private boolean poisoned;
	private Poison poison;

	public Entity(int initAgi, int initStr, int initCon) {
		poisoned=false;
		poison=null;
		agi=initAgi;
		str=initStr;
		con=initCon;
		alive=true;
		exp=0;
		lvl=1;
		hp=(int) (.5*str+5);
		// TODO Auto-generated constructor stub
	}
	
	public boolean takeDmg(int dmgNum){
		hp-=dmgNum;
		if (hp<=0){
			alive=false;
		}
		return alive;
	}
	
	public boolean dodge(Weapon weapon,int targetAgi){
		return weapon.aim(targetAgi,agi);
	}
	
	public int awareCheck(){
		return (int) Math.random()*20+agi;
	}
	
	public int saveCheck(){
		return (int)Math.random()*20+con;
	}
	
	public void poisonCheck(){
		if (saveCheck()<poison.getResist()){
			takeDmg(poison.getDmg());
		}
	}
		
	public int bruteCheck(){
		return (int) Math.random()*20+str;
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
		return (int) (str*strMod+weapon.damage());
	}
	
	public boolean aimWeapon(Weapon weapon,Entity target){
		if (weapon.isUsable()){
			return weapon.aim(agi,target.getAgi());
		}
		else{
			return false;
		}
	}
	
	private boolean aim(int agi2) {
		// TODO Auto-generated method stub
		return false;
	}

	private int square(int n){
		return n*n;
	}
	
	public boolean addExp(int numPts){
		exp+=numPts;
		if (exp>=10*square(lvl)){
			lvl++;
			return true;
		}
		else return false;
	}
	
	public int getAgi(){
		return agi;
	}
	
	public int getStr(){
		return str;
	}
	
	public int getCon(){
		return con;
	}
	
	public int getExp(){
		return exp;
	}
	
	public int expToLvl(){
		return (int) (10.0*square(lvl)-exp);
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