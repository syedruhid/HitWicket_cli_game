public class layout {
	
    piece [][] layout;
	
	
	public layout(){
		layout = new piece[5][5];
		
		formlayout();
		
	}
	
	
	public void formlayout(){
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				layout[i][j] = null;
			}
		}
        //player A piece ap(n)
		layout[0][0] = new piece(false);
		layout[1][0] = new piece(false);
		layout[2][0] = new piece(false);
		layout[3][0] = new piece(false);
		layout[4][0] = new piece(false);
		
		//player B piece bp(n)
		layout[0][4] = new piece(true);
		layout[1][4] = new piece(true);
		layout[2][4] = new piece(true);
		layout[3][4] = new piece(true);
		layout[4][4] = new piece(true);
		
		
	}
	
	public boolean way(int oldX, int oldY, int newX, int newY){
		
		//System.out.println("isPathClear");
		
		String pieceName = layout[oldX][oldY].drawPiece();
		
		if (pieceName.equalsIgnoreCase("wk") || pieceName.equalsIgnoreCase("bk")) {
			return true;
		} else if (pieceName.equalsIgnoreCase("wn") || pieceName.equalsIgnoreCase("bn")) {
			return true;
		}
		
		int X;
		int Y;
		
		X = newX-oldX;
		Y = newY-oldY;
		
		int tempx = oldX;
		int tempy = oldY;
		int dx = 0;
		int dy = 0;
		
		if (X > 0) {
			dx = 1;
		}else if (X < 0) {
			dx = -1;
		}
		
		if (Y > 0) {
			dy = 1;
		}else if (Y < 0) {
			dy = -1;
		}
		
		
		boolean go = true;
		
		
		
		if (Y == 0) {
			tempx = tempx + dx;
			for (int i = 0; i < Math.abs(X)-1; i++) {
				if (layout[tempx][tempy] != null) {
					go = false;
					break;
				}
				
				tempx = tempx + dx;
			} 
			return go;
		}
		
		
		if (X == 0) {
		
			tempy = tempy + dy;
			for (int i = 0; i < Math.abs(Y)-1; i++) {
				if (layout[tempx][tempy] != null) {
					go = false;
				}
				
				tempy = tempy + dy;
			}
			
			return go;
		}
		
		if (X != 0 && Y != 0) {
			tempx = tempx + dx;
			tempy = tempy + dy;
			for (int i = 0; i < Math.abs(Y)-1; i++) {
				if (layout[tempx][tempy] != null) {
					go = false;
					break;
				}
				
				tempx = tempx + dx;
				tempy = tempy + dy;
			} 
		}
		
		return go;
		
	}
	
	public boolean testCastling(int oldX, int oldY, int newX, int newY) {

		int deltax = newX - oldX;
		if ( board[oldX][oldY] != null) {
			
			String pieceName = board[oldX][oldY].drawPiece();
			if (pieceName.equalsIgnoreCase("wk") && board[oldX][oldY].firstMove == true) { //is the king white and hasnt been moved
				
				if (deltax == 2) { // is it right castling?

					if (board[7][7] != null) {
						if (board[7][7].drawPiece().equalsIgnoreCase("wr") ) { //check if the rook is in its original place

							if (isPathClear(oldX, oldY, newX, newY)) {
								board[oldX][oldY] = null;
								board[7][7] = null;
								
								board[newX][newY] = new King(true);
								board[newX][newY].firstMove = false;
								
								board[5][7] = new Rook(true);
								board[5][7].firstMove = false;
								
								return true;
							}
						}
					}
				}
			}
		}
		
		if ( board[oldX][oldY] != null) {
			String pieceName = board[oldX][oldY].drawPiece();

			if (pieceName.equalsIgnoreCase("bk") && board[oldX][oldY].firstMove == true) { //is the king black and hasnt been moved

				if (deltax == 2) { // is it right castling?
					if (board[7][0] != null) { //is there a rook at the place for castling?
						if (board[7][0].drawPiece().equalsIgnoreCase("br") ) { //check if the rook is in its original place
							if (isPathClear(oldX, oldY, newX, newY)) {
								board[oldX][oldY] = null;
								board[7][0] = null;
								
								board[newX][newY] = new King(false);
								board[newX][newY].firstMove = false;
								
								board[5][0] = new Rook(false);
								board[5][0].firstMove = false;
								
								return true;
							}
						}
					}
				}
			}
		}
		
		if ( board[oldX][oldY] != null) {
			String pieceName = board[oldX][oldY].drawPiece();

			if (pieceName.equalsIgnoreCase("wk") && board[oldX][oldY].firstMove == true) { //is the king white and hasnt been moved

				if (deltax == -2) { // is it left castling?

					if (board[0][7] != null) { // check if the rook exists

						if (board[0][7].drawPiece().equalsIgnoreCase("wr") ) { //check if the rook is in its original place

							if (isPathClear(oldX, oldY, newX, newY)) {

								board[oldX][oldY] = null; //remove the king
								board[0][7] = null; //remove the rook
								
								board[newX][newY] = new King(true);
								board[newX][newY].firstMove = false;
								
								board[3][7] = new Rook(true);
								board[3][7].firstMove = false;

								
								return true;
							}
						}
					}
				}
			}
		}
		
		if ( board[oldX][oldY] != null) {
			String pieceName = board[oldX][oldY].drawPiece();

			if (pieceName.equalsIgnoreCase("bk") && board[oldX][oldY].firstMove == true) { //is the king black and hasnt been moved


				if (deltax == -2) { // is it left castling?

					if (board[0][0] != null) { // check if the rook exists

						if (board[0][0].drawPiece().equalsIgnoreCase("br") ) { //check if the rook is in its original place

							if (isPathClear(oldX, oldY, newX, newY)) {

								board[oldX][oldY] = null; //remove the king
								board[0][0] = null; //remove the rook
								
								board[newX][newY] = new King(false);
								board[newX][newY].firstMove = false;
								
								board[3][0] = new Rook(false);
								board[3][0].firstMove = false;
								
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean detectEnPassant(int oldX, int oldY, int newX, int newY) { //call this after the move had been performed for this turn
		Chess.enPassantToEliminateX = newX;
		Chess.enPassantToEliminateY = newY;
		
		if (board[newX][newY] == null) {
			return false;
		}

		if (!(board[newX][newY].drawPiece().equalsIgnoreCase("wp") || 
				board[newX][newY].drawPiece().equalsIgnoreCase("bp"))) { // white pawn or black is in the new location
			return false;
		}
		if (Math.abs(newY - oldY) != 2) { //white pawn had just moved forward by 2
			return false;
		}
		
		int tempx = newX - 1;
		
		if (tempx >= 0) {
			Chess.enPassantCapturer1X = tempx;
			Chess.enPassantCapturer1Y = newY;
			
			//System.out.println("5");
			if (board[tempx][newY] != null) {
				if (board[tempx][newY].drawPiece().equalsIgnoreCase("wp") && Chess.whiteTurn == false) {
					Chess.enPassant = true;
					Chess.enPassantX = newX;
					Chess.enPassantY = 2;
					
					return true;
				}
				
				if (board[tempx][newY].drawPiece().equalsIgnoreCase("bp") && Chess.whiteTurn == true) {
					Chess.enPassant = true;
					Chess.enPassantX = newX;
					Chess.enPassantY = 5;
					
					return true;
				}
			}
		}
		
	
		tempx = newX + 1;
		if (tempx <= 7) {
			Chess.enPassantCapturer2X = tempx;
			Chess.enPassantCapturer2Y = newY;
			
			//System.out.println("6");
			if (board[tempx][newY] != null) {
				if (board[tempx][newY].drawPiece().equalsIgnoreCase("wp") && Chess.whiteTurn == false) {
					//System.out.println("7");
					Chess.enPassant = true;
					Chess.enPassantX = newX;
					Chess.enPassantY = 2;
					return true;
				}
				
				if (board[tempx][newY].drawPiece().equalsIgnoreCase("bp") && Chess.whiteTurn == true) {
					//System.out.println("10");
					Chess.enPassant = true;
					Chess.enPassantX = newX;
					Chess.enPassantY = 5;
					return true;
				}
			}
		}
	
		
		return false;
	}
	
	public  boolean testEnPassant(int oldX, int oldY, int newX, int newY) {
		if (((Chess.enPassantCapturer1X == oldX) && (Chess.enPassantCapturer1Y == oldY)) 
				|| ((Chess.enPassantCapturer2X == oldX) && (Chess.enPassantCapturer2Y == oldY))) {
			if (newX == Chess.enPassantX && newY == Chess.enPassantY) {
				board[Chess.enPassantToEliminateX][Chess.enPassantToEliminateY] = null;
				board[newX][newY] = board[oldX][oldY];
				board[oldX][oldY] = null;
				
				return true;
			}
		}
		
		return false;
	}

	

		
		for (int y = 0; y < 8; y++){
			for (int x = 0; x < 8; x++){
				if (board[x][y] != null) {
					if (board[x][y].isWhite() == white) {
						for (int yy = 0; yy < 8; yy++){
							for (int xx = 0; xx < 8; xx++){
								boolean isNewSpotEmpty = true;
								if (board[xx][yy] != null) {
									isNewSpotEmpty = false;
								}
								if (board[x][y].canMove(x, y, xx, yy, isNewSpotEmpty)) {
									if (isPathClear(x, y, xx, yy)) {
										return false;
									}
								}
							}
						}	
					}
				}
			}
		}	
		
		return true;  //stalemate found
	}
}
