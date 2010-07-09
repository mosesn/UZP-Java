
public abstract class Item {
	private String name;
	
	public Item(String thisName){
		name=new String(thisName);
	}
	
	public abstract boolean isUsable();
	
	public String toString(){
		return name;
	}
}
