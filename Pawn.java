public class Pawn extends Piece {
	private boolean castlingDone = false;

	public Pawn(boolean white)
	{
		super(white);
	}


    public boolean canMove(Board board, Spot start, Spot end)
	{

		int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
		if (x + y == 1) {
			return true;
		}

		
	}
}
