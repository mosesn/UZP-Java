
public class CombatInterface extends TextInterface{
	public int Battle(Monster entity, Player player){
		boolean gone=false;
		printString("You have started combat with a wild "+entity+".");
		while (!entity.isDead()){
			printString("What do you do?!?!");
			readString();
			if (gone){
				return 0;
			}
			enemyturn(entity);
			
		}
		return 0;
	}
	
	public void enemyturn(Monster entity){
		entity.attack();
		
	}
	
	public void flee(Monster entity, Player player, Boolean gone){
		if (entity.getAgi()<player.getAgi()){
			printString("Your cowardly flee is suceesful. Leave the room before he engages you again.");
			gone = true;
		} else {
			printString("Your cowardice failed you; You are still locked in combat.");
		}
	}
	
	public void enemyTurn(Monster entity, Player player){
		
		
	}
	
	public void Use(Item item, Monster entity, Player player){
		
		
		
	}
	
}
