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
		
		if (X!=0 && Y!=0) {
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
}
