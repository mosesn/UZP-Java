import java.util.HashSet;


public class Room {
	
	private HashSet<Exit> exits;
	private Room[] exitRooms;

	public Room(){
		exits=new HashSet<Exit>();
		exitRooms=new Room[4];
	}
	
	public void addExits(String exitName){
		exitName=exitName.toUpperCase();
		if (exitName.indexOf('N')!=-1){
			addExit(Exit.NORTH);
		}
		if(exitName.indexOf('S')!=-1){
			addExit(Exit.SOUTH);
		}
		if(exitName.indexOf('E')!=-1){
			addExit(Exit.EAST);
		}
		if(exitName.indexOf('W')!=-1){
			addExit(Exit.WEST);
		}
	}
	
	public boolean addExit(Exit exit){
		return exits.add(exit);
	}
	
	public boolean hasExit(Exit exit){
		return exits.contains(exit);
	}
	
	public boolean setExitRoom(Exit exit, Room room){
		if (exitRooms[exitConv(exit)]==null){
			exitRooms[exitConv(exit)]=room;
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public Room go(Exit exit){
		return exitRooms[exitConv(exit)];
	}
	
	public Room go(String str){
		return go(strToExit(str));
	}
	
	public Exit strToExit(String str){
		if (str.equals("NORTH")){
			return Exit.NORTH;
		}
		else if(str.equals("SOUTH")){
			return Exit.SOUTH;
		}
		else if(str.equals("WEST")){
			return Exit.WEST;
		}
		else if(str.equals("EAST")){
			return Exit.EAST;
		}
		else return null;
	}
	
	public int exitConv(Exit exit){
		if (exit.equals(Exit.NORTH)){
			return 0;
		}
		else if (exit.equals(Exit.SOUTH)){
			return 1;
		}
		else if (exit.equals(Exit.EAST)){
			return 2;
		}
		else if (exit.equals(Exit.WEST)){
			return 3;
		}
		else return -1;
	}
	
	public String printExits(){
		return exits.toString();
	}
	
		
	public enum Exit{NORTH,SOUTH,EAST,WEST}
}
