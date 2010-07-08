
public abstract class Poison extends Item{
	private String name;
	private int dmg;
	private int resist;
	
	public Poison(int thisDmg,int thisResist,String thisName){
		name=new String(thisName);
		dmg=thisDmg;
		resist=thisResist;
	}
	
	public int getResist(){
		return resist;
	}
	
	public int getDmg(){
		return dmg;
	}
}
