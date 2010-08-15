/*
 * Entities are the creatures that inhabit the game.
 * They consist of three main attributes: Agility (agi) Strength (str) and Constitution (con)
 * 
 * 
 * 
 * 
 * 
 * */
public class Entity {
	private final static double strMod=.25;
	private String name;
	private int agi;
	private int str;
	private int con;
	private int hp;
	private boolean alive;
	private boolean poisoned;
	private Poison poison;

	public Entity(int initAgi, int initStr, int initCon,String initName) {
		poisoned=false;
		poison=null;
		agi=initAgi;
		str=initStr;
		con=initCon;
		alive=true;
		name=initName;

		hp=(int) (strMod*str+5);
		// TODO Auto-generated constructor stub
	}
	
	public boolean takeDmg(int dmgNum){
		hp-=dmgNum;
		if (hp<=0){
			alive=false;
		}
		return alive;
	}
	
	public boolean isDead(){
		return !alive;
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

	
	private boolean aim(int agi2) {
		// TODO Auto-generated method stub
		return false;
	}

	public int square(int n){
		return n*n;
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
	
	public String toString(){
		return name;
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
