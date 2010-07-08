import java.util.Stack;


public class AmmoBag extends Item{
	Stack<Ammo> ammos;
	int id;
	int size;
	String name;
	
	public <E> AmmoBag(Ammo ammo){
		ammos.push(ammo);
		id=ammo.getId();
		name=ammo.toString();
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
		return name + " x " + size;
	}
	
}
