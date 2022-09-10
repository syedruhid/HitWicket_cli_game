public class Board {
	Spot[][] boxes;

	public Board()
	{
		this.resetBoard();
	}

	public Spot getBox(int x, int y)
	{

		if (x < 0 || x > 4 || y < 0 || y > 4) {
			throw new Exception("Index out of bound");
		}

		return boxes[x][y];
	}

	public void resetBoard()
	{
		// initialize white pieces
		boxes[0][0] = new Spot(0, 0, new Pawn(true));
		boxes[0][1] = new Spot(0, 1, new Pawn(true));
		boxes[0][2] = new Spot(0, 2, new Pawn(true));
		//...
		boxes[0][3] = new Spot(0, 3, new Pawn(true));
		boxes[0][4] = new Spot(0, 4, new Pawn(true));
		//...

		// initialize black pieces
		boxes[4][0] = new Spot(4, 0, new Pawn(false));
		boxes[4][1] = new Spot(4, 1, new Pawn(false));
		boxes[4][2] = new Spot(4, 2, new Pawn(false));
		//...
		boxes[4][3] = new Spot(4, 3, new Pawn(false));
		boxes[4][4] = new Spot(4, 4, new Pawn(false));
		//...
		for (int i = 1; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				boxes[i][j] = new Spot(i, j, null);
			}
		}
	}
}
