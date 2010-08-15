import java.util.Stack;


public class AmmoBag extends Item{
	private Stack<Ammo> ammos;
	private int id;
	private int size;
	
	public <E> AmmoBag(Ammo ammo){
		super(ammo.toString());
		ammos.push(ammo);
		id=ammo.getId();
		size=0;
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
			return true;
		}
		else return false;
	}
	
	public String toString(){
		return super.toString() + " x " + size;
	}

	public boolean isUsable() {
		return true;
	}
	
}
