import java.util.Stack;


public class AmmoBag extends Item{
	private static final int USES=50;
	private Stack<Ammo> ammos;
	private int id;
	private int size;
	private int used;
	
	public <E> AmmoBag(Ammo ammo){
		super(ammo.toString());
		ammos.push(ammo);
		id=ammo.getId();
		size=0;
		used=0;
	}
	
	public void add(Ammo ammo){
		ammos.push(ammo);
		size++;
	}
	
	public int hashCode(){
		return id;
	}
	
	public boolean pop(){
		if (!ammos.isEmpty()){
			ammos.pop();
			size--;
			used++;
			return true;
		}
		else return false;
	}
	
	public String toString(){
		return super.toString() + " x " + size;
	}

	public boolean isUsable() {
		if (used<USES){
			return true;
		}
		else return false;
	}
	
}
