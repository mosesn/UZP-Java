/**
 * Weapons are of type item, and deal a certain amount of damage.
 * @author Moses
 *
 */
public abstract class Weapon extends Item{
	/**
	 * Determines how much damage a weapon should deal.
	 * @return the value of the damage the weapon doles out
	 */
	public Weapon(String name){
		super(name);
	}
	
	public abstract int damage();
	public abstract boolean aim(int mod,int targetMod);
}
