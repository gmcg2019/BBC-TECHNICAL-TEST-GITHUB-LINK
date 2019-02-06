public class GameOfLife {
	
	private static final int	HEIGHT = 10;
	private static final long	TIME   = 120*1;
	
	public static void main(String[] args) throws InterruptedException {
		boolean [][] grid = new boolean[HEIGHT][HEIGHT];
	
    randomPattern(grid);    // random       pattern		
//  showBlinker(grid);      // Blinker      pattern  
//  showBeacon(grid);       // Beacon       pattern
//  showToad(grid);         // Toad         pattern
//  showGlider(grid);      	// Glider       pattern 
//  showPentomino(grid);    // F-Pentomino  pattern
//  showTumbler(grid);      // Tumbler      pattern
//  showEight(grid);        // Figure Eight pattern     

		while(true) {
			Thread.sleep(TIME);
			outPattern(grid);
			newPattern(grid);
			System.out.println("__________________________    next stage below -->");
		}
	}
	
	private static void newPattern(boolean[][] grid) {
		boolean[][] tempGrid = new boolean[grid.length][grid[0].length];
		transferGrid(grid, tempGrid);
		
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < HEIGHT; j++) {
		
				int countNeighbours = 0;
				for(int k = i-1; k <= i+1; k++) {
					for(int t = j-1; t <= j+1; t++) {
						if((k == i && t == j) || (t < 0 || t >= HEIGHT) || (k < 0 || k >= HEIGHT) )
							continue;
						else {
							if(grid[k][t]) {
								countNeighbours++;
							}
						}
					}
				}
				
				nextStep(tempGrid, i, j, countNeighbours);
			}
		}
		
		transferGrid(tempGrid, grid);
	}
	
	private static void nextStep(boolean[][] grid, int i, int j, int countNeighbours) {
		if(countNeighbours <= 1 || countNeighbours >= 4)
			grid[i][j] = false;
		else if(countNeighbours == 3 || countNeighbours == 4)
			grid[i][j] = true;
	}
	
	private static void transferGrid(boolean[][] src, boolean[][] dst) {
		for(int i = 0; i < HEIGHT; i++)
			System.arraycopy(src[i], 0, dst[i], 0, HEIGHT);
	}
	
	private static void outPattern(boolean[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == true) {
					System.out.print('•');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
	
	private static void randomPattern(boolean[][] grid) {
		for(int i = 0; i < HEIGHT; i++)
			for(int j = 0; j < HEIGHT; j++)
				grid[i][j] = Math.random() < 0.4;
	}
	
	/*
   * Blinker 
   */
  
  private static void showBlinker(boolean[][] grid) {
		grid[2][3] = true;
		grid[2][4] = true;
		grid[2][5] = true;
  }
        
  /*
   * Beacon
	 */
	
  private static void showBeacon(boolean[][] grid) {
		grid[2][3] = true;
		grid[2][4] = true;
		
		grid[3][3] = true;
		grid[3][4] = true;
		
		grid[4][5] = true;
		grid[4][6] = true;
		
		grid[5][5] = true;
		grid[5][6] = true;
  }
        
  /*
   * Toad
	 */
	
  private static void showToad(boolean[][] grid) {
		grid[4][4] = true;
		grid[4][5] = true;
		grid[4][6] = true;
		
		grid[5][5] = true;
		grid[5][6] = true;
		grid[5][7] = true;
  }
        
	/*
	 * Glider  n.b. should carry on but reaches limit of array
	 */
	 
	private static void showGlider(boolean[][] grid) {
		grid[0][1] = true;
		
		grid[1][2] = true;
		
		grid[2][0] = true;
		grid[2][1] = true;
		grid[2][2] = true;
	}
	
  /*       
   * F-Pentomino
	 */
	
  private static void showPentomino(boolean[][] grid) {
		grid[2][3] = true;
		grid[2][4] = true;
		grid[2][5] = true;
		
		grid[3][2] = true;
		grid[3][3] = true;
		
		grid[4][3] = true;
	}
	
	/*
	 * Tumbler
	 */
	 
	private static void showTumbler(boolean[][] grid) {
		grid[0][2] = true;
		grid[0][3] = true;
		grid[0][5] = true;
		grid[0][6] = true;
		
		grid[1][2] = true;
		grid[1][3] = true;
		grid[1][5] = true;
		grid[1][6] = true;
		
		grid[2][3] = true;
		grid[2][5] = true;
		
		grid[3][1] = true;
		grid[3][3] = true;
		grid[3][5] = true;
		grid[3][7] = true;
		
		grid[4][1] = true;
		grid[4][3] = true;
		grid[4][5] = true;
		grid[4][7] = true;
		
		grid[5][1] = true;
		grid[5][2] = true;
		grid[5][6] = true;
		grid[5][7] = true;
	}
	
	/*
	 * showEight
	 */
	 
	private static void showEight(boolean[][] grid) {
		grid[2][2] = true;
		grid[2][3] = true;
		grid[2][4] = true;
		
		grid[3][2] = true;
		grid[3][3] = true;
		grid[3][4] = true;
		
		grid[4][2] = true;
		grid[4][3] = true;
		grid[4][4] = true;
		
	  grid[5][5] = true;
		grid[5][6] = true;
		grid[5][7] = true;
		
		grid[6][5] = true;
		grid[6][6] = true;
		grid[6][7] = true;
		
		grid[7][5] = true;
		grid[7][6] = true;
		grid[7][7] = true;        
  }
}
