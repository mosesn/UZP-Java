public abstract class Monster extends Entity{
	public Monster (int initAgi, int initStr, int initCon,String name) {
		
		super(initAgi, initStr, initCon, name);
		
	}

	public abstract void attack();
}