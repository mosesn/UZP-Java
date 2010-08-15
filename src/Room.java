import java.util.HashSet;


public abstract class Room {
	
	private HashSet<Exit> exits;
	private Room[] entrances;
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
	
	public boolean addRoom(int x,int y,Room room){
		if (rooms[x][y]==null){
			rooms[x][y]=room;
			return true;
		}
		else return false;
	}
	
	public Room go(Exit exit){
		return exitRooms[exitConv(exit)];
	}
	
	
	//  TODO: add code that actually connects.
	//  thoughts: make a new Exit class that replaces the enumerated value
	//  note: if you do this, make sure that x direction shares the same hashcode with all
	//  other x.  An id system of 0,1,2,3 would work fine.
	//  thoughts: use an array of rooms marked travels[]
	public boolean connect(int x1, int y1, int x2, int y2){
		if ((Math.abs((double) (x1-x2)))==1.0 && ((y1-y2)==0)){
			if (x1>x2){
				if (rooms[x1][y1].hasExit(Exit.EAST) && rooms[x2][y2].hasExit(Exit.WEST)){
					rooms[x1][y1].setExitRoom(Exit.EAST, rooms[x2][y2]);
					rooms[x2][y2].setExitRoom(Exit.WEST, rooms[x1][y1]);
					return true;
				}
				else return false;
			}
			else if (x2>x1){
				if (rooms[x2][y2].hasExit(Exit.EAST) && rooms[x1][y1].hasExit(Exit.WEST)){
					rooms[x1][y1].setExitRoom(Exit.WEST, rooms[x2][y2]);
					rooms[x2][y2].setExitRoom(Exit.EAST, rooms[x1][y1]);					
					return true;
				}
				else return false;
			}
			else return false;
		}
		else if ((Math.abs((double) (y1-y2)))==1.0 && ((x1-x2)==0)){
			if (y1>y2){
				if (rooms[x1][y1].hasExit(Exit.SOUTH) && rooms[x2][y2].hasExit(Exit.NORTH)){
					rooms[x1][y1].setExitRoom(Exit.SOUTH, rooms[x2][y2]);
					rooms[x2][y2].setExitRoom(Exit.NORTH, rooms[x1][y1]);
					
					return true;
				}
				else return false;
			}
			else if (y2>y1){
				if (rooms[x2][y2].hasExit(Exit.SOUTH) && rooms[x1][y1].hasExit(Exit.NORTH)){
					rooms[x1][y1].setExitRoom(Exit.NORTH, rooms[x2][y2]);
					rooms[x2][y2].setExitRoom(Exit.SOUTH, rooms[x1][y1]);
					
					return true;
				}
				else return false;
			}
			else return false;

		}
		else return false;
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
	
	public boolean bindExit(int x,int y, Exit exit){
		int tempInt=exitConv(exit);
		if (tempInt!=-1){
			if (rooms[x][y].hasExit(exit)){
				if (this.hasExit(exit)){
					entrances[tempInt]=rooms[x][y];
					return true;
				}
				else return false;
			}	
			else return false;
		}
		else return false;
	}
		
	public enum Exit{NORTH,SOUTH,EAST,WEST}
}
