

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dungeon testDungeon=new Dungeon(2,2);
		testDungeon.addRoom(0,0);
		testDungeon.addRoom(0,1);
		TextInterface talker=new TextInterface();
		Room tmpRoom=testDungeon.getRoom(0,0);
		tmpRoom.addExits("NWS");
		testDungeon.getRoom(0,1).addExits("NS");
		if (testDungeon.connect(0,0,0,1)){
			talker.printString("TRUE");
		}
		
		
		talker.printString(testDungeon.getRoom(0,0).printExits());
		talker.printString(testDungeon.getRoom(0,0).go("SOUTH").printExits());
	}

}
