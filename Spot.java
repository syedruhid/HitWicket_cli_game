public class Spot implements Piece {
	private Piece piece;
	private int x;
	private int y;
    private Piece Piece;

	public Spot(int x, int y, Piece piece)
	{
		this.setPiece(piece);
		this.setX(x);
		this.setY(y);
	}
    Piece p;

	public Piece getPiece(p)
	{
		this.piece = p;
	}

	public void setPiece(p)
	{
		this.piece = p;
	}

	public int getX()
	{
		return this.x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
}
