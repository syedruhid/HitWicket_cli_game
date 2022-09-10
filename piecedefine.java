// Storing abstract data and methods to be implemented in layout.java and other java  class file
public abstract class piecedefine {
	
	private boolean bp = true;
	
	public boolean firstMove = true;
	
	public void bpcoins(boolean t){
		bp = t;
	}

	public boolean isType(){
		return this.bp;
	}
	
	
	
	public abstract boolean moves(int oldX, int oldY, int newX, int newY, boolean isFree);
	
	public abstract void movePiece();
	
	public abstract String drawPiece();
}