import java.util.HashSet;

/**
 * The class sack has a restraint on how many items it can hold, 
 * and it cannot hold duplicates of items.
 * @author Moses
 *
 */
public class Sack extends HashSet<Item>{
	private static final int maxSize=20;
	
	private int size;
	
	public Sack(){
		super();
		size=0;
	}
	
	/**
	 * boolean add returns true if it successfully adds an item to the sack.
	 */
	public boolean add(Item item){
		if (size>maxSize){
			return false;
		}
		else{
			Item addItem;
			if(item instanceof Ammo){
				addItem=new AmmoBag((Ammo) item);
			}
			else{
				addItem=item;
			}
			
			if (super.add(item)){
				size++;
				return true;
			}
			else return false;
		}
	}
	
	/**
	 * Returns each item in the sack.  Each line is separated by a newline character.
	 */
	public String toString(){
		String toPrint=new String("\n");
		for (Item item:this){
			toPrint+=item+"\n";
		}
		return toPrint;
	}
}
