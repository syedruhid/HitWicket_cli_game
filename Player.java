public abstract class Player {
	public boolean whiteSide;
	public boolean Player;

	public boolean isWhiteSide()
	{
		return this.whiteSide;
	}
	public boolean isPlayer()
	{
		return this.Player;
	}
}

public class HumanPlayer extends Player {

	public HumanPlayer(boolean whiteSide)
	{
		this.whiteSide = whiteSide;
		this.Player = true;
	}
}
