import java.util.Random;

public class Game {
	int playerLeftIndent, computerLeftIndent, topIndent, centerIndent, 
	fieldSize, cellSize,dirX,dirY,x,y;
	Random rn = new Random();
	
	Field playerField, computerField;
	
	Game(){
		topIndent = 150;
		
		centerIndent = 250;
		fieldSize = 10;
		cellSize = 50;
		
		playerLeftIndent = 350;
		computerLeftIndent = playerLeftIndent + fieldSize * cellSize + centerIndent;
	
		
		playerField = new Field(topIndent, playerLeftIndent, fieldSize, cellSize, false);
		
		computerField = new Field(topIndent, computerLeftIndent, fieldSize, cellSize, true);
	}
		public void chooseDirection() {
			int dir = rn.nextInt(4);
			switch (dir) {
			case 0: // �����
				dirX = -1;
				dirY = 0;
				break;
			case 1:
				dirX = 0;
				dirY = -1;
				break;
			case 2:
				dirX = 1;
				dirY = 0;
				break;
			case 3:
				dirX = 0;
				dirY = 1;
				break;
			default:
				break;
			}
		}
	
	public void computerTurn() {
		int code;
		while((code = playerField.shoot(x, y)) > 0) {
			int damagedCount = playerField.countOfDamageShipCells();
			if(damagedCount > 0) {
				if(damagedCount == 1) {
					x -= dirX;
					y -= dirY;
					chooseDirection();
					if(x + dirX >= 0 && x + dirX < 10 && y + dirY >=0 && y + dirY < 10) {
						x += dirX;
						y += dirY;
					}else{
						dirX=0;
						dirY=0;
				}
				}else{
					if(code ==3) {
					dirX *=-1;
					dirY *=-1;
					}
					if(x + dirX >= 0 && x + dirX < 10 && y + dirY >=0 && y + dirY < 10) {
						x += dirX;
						y += dirY;
					}else{
						dirX=0;
						dirY=0;
					}
				}
			}else{
			    x = rn.nextInt(10);
				y = rn.nextInt(10);
				dirX =0;
				dirY =0;
			}
			
			}
	}
	public void playerTurn(int x, int y) {
		x -= computerLeftIndent;
		y -= topIndent;
		x /= cellSize;
		y /= cellSize ;
		if(computerField.shoot(x, y) == 0) {
			computerTurn();
		}
	}
	
}
