import java.util.HashSet;

public class Dungeon extends Room{
	private Room[][] rooms;
	private Room[] entrances;

	public Dungeon(int cols, int rows) {
		super();
		rooms=new Room[cols][rows];
		for (int i=0;i<cols;i++){
			for (int j=0;j<cols;j++){
				rooms[i][j]=new Room();
			}
		}
		entrances=new Room[4];
		
	}
	public boolean addRoom(int x,int y,Room room){
		if (rooms[x][y]==null){
			rooms[x][y]=room;
			return true;
		}
		else return false;
	}
	
	public boolean addRoom(int x,int y){
		if (rooms[x][y]==null){
			rooms[x][y]=new Room();
			return true;
		}
		else return false;
	}


	public boolean connect(int x1, int y1, int x2, int y2){
		if ((Math.abs((double) (x1-x2)))==1.0 && ((y1-y2)==0)){
			if (x1<x2){
				rooms[x1][y1].addExit(Exit.EAST);
				rooms[x2][y2].addExit(Exit.WEST);
				rooms[x1][y1].setExitRoom(Exit.EAST, rooms[x2][y2]);
				rooms[x2][y2].setExitRoom(Exit.WEST, rooms[x1][y1]);
			}
			else if (x2<x1){
				rooms[x2][y2].hasExit(Exit.EAST);
				rooms[x1][y1].hasExit(Exit.WEST);
				rooms[x1][y1].setExitRoom(Exit.WEST, rooms[x2][y2]);
				rooms[x2][y2].setExitRoom(Exit.EAST, rooms[x1][y1]);					
			}
			else return false;
		}
		else if ((Math.abs((double) (y1-y2)))==1.0 && ((x1-x2)==0)){
			if (y1<y2){
				rooms[x1][y1].hasExit(Exit.SOUTH);
				rooms[x2][y2].hasExit(Exit.NORTH);
				rooms[x1][y1].setExitRoom(Exit.SOUTH, rooms[x2][y2]);
				rooms[x2][y2].setExitRoom(Exit.NORTH, rooms[x1][y1]);
			}
			else if (y2<y1){
				rooms[x2][y2].hasExit(Exit.SOUTH);
				rooms[x1][y1].hasExit(Exit.NORTH);
				rooms[x1][y1].setExitRoom(Exit.NORTH, rooms[x2][y2]);
				rooms[x2][y2].setExitRoom(Exit.SOUTH, rooms[x1][y1]);
			}
			else return false;

		}
		else return false;

		return true;
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
	public Room getRoom(int x, int y) {
		// TODO Auto-generated method stub
		return rooms[x][y];
	}
	
}
