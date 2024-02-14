package suc;
import java.util.Random; 
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Methods {
	private static Random rng = new Random();
	
	
	
	public static char[][] createBoard(int rows, int cols, int mines){
		
		char[][] board = new char[rows][cols];
		fill(board, '-');
		firstClick(board);
		randomize(mines, board);
		populateBoard(board);
		return board;
	}
	
	private static void populateBoard(char[][] board) {
		for (int r = 0; r < rowsIn(board); r++) {
			for (int c = 0; c < colsIn(board); c++) {
				int n = numMines(nMoore(board,r, c));
				if(n > 0 && !(board[r][c] == '#') ) {
					board[r][c] = (char)(n +'0');
				} else {
					continue;
				}
			}
		} 
	}
	
	/**
	 * Used as part of createBoard, will eventually take in the coordinates of the first cell clicked in a game, and assign 
	 * @param board
	 */
	
	private static void firstClick(char[][] board) {
		int rCenter = 2;
		int cCenter = 2;
		for (int r = rCenter - 1; r <= rCenter + 1; r++) {
			for (int c = cCenter - 1; c <= cCenter + 1; c++) {
				if (indexOk(board, r, c)) {
					board[r][c] = '$';
				} else {
					continue;
				}
			}
		}
	}
	
	private static int[][] minedIndexes(char[][] cells) {		
		int rows = rowsIn(cells);
		int cols = colsIn(cells);
		int n = 0;
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				if(cells[r][c] == '#') {
					n++;
				}
			}
		}
		
		int[][] minedIndexes = new int [2][n];
		
		int i = 0;
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				if(cells[r][c] == '#') {
					minedIndexes [0][i] = r;
					minedIndexes [1][i] = c;
					i++;
				}
			}
		}		
	
		return(minedIndexes);	
		
	}
	
	private static void fill(char[][] cells, char s) {		
		int rows = rowsIn(cells);
		int cols = colsIn(cells);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				cells[r][c] = s;
			}
		}
	}
	
	
	private static void randomize(int totMines, char[][] cells) {		
		if(totMines<1) {
			throw new IllegalArgumentException();
		}
		
		int rows = rowsIn(cells);
		int cols = colsIn(cells);
		int row;
		int col;
		int numMined = 0;
		
		while(numMined < totMines) {
			row = rng.nextInt(rows);
			col = rng.nextInt(cols);
			if(cells[row][col] == '-') {
				cells[row][col] = '#';
				numMined++;	
			} else { 
				continue;
			}
		}	
	}
	
	private static int rowsIn(char[][] cells) {
		return (cells.length);
		}
	

	/**
	 * Returns the number of columns in the two-dimensional array of cells.
	 * 
	 * @param cells a two-dimensional array
	 * @return the number of columns in the two-dimensional array {@code cells}
	 */
	private static int colsIn(char[][] cells) {
		if (rowsIn(cells) > 0) {
			return(cells[0].length);
		}
		return 0;
	}

	private static boolean indexOk(char[][] cells, int row, int col) {
		if (row < 0 || row >= rowsIn(cells)) {
			return false; 
		}
		if (col < 0 || col >= colsIn(cells)) {
			return false;
		}
	return true;
	}

	/**
	 * Prints the cells of a Forest-fire model followed by a new line.
	 * 
	 * <p>
	 * Empty cells are represented with a hyphen '-', trees are represented with the
	 * character 'T', and burning trees are represented with the character '#'.
	 * There are no separator characters between cells. Each row of {@code cells} is
	 * printed on a separate line.
	 * 
	 * @param cells a two-dimensional array
	 */
	public static void printBoard(char[][] cells) {
		int rows = rowsIn(cells);
		int cols = colsIn(cells);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				char s = cells[r][c];
				System.out.print(" "+s+" ");
			}	
			System.out.println();
		}
	}
	
	private static char[][] nMoore(char[][] cells,int row,int col) {
		char[][]nHood = new char[3][3];
		int left = col - 1;
		int top = row - 1;
		
		for (int r = 0; r < 3; r++) { 
			int cellsRow = top + r;
			for (int c = 0; c < 3; c++) {
				
				int cellsCol = left + c;
				
				if (indexOk(cells, cellsRow, cellsCol)) {
					nHood[r][c] = cells[cellsRow][cellsCol];
				} else {
					nHood[r][c] = '-';
				}
				
			}
		}
		return (nHood);
	}
	
	public static boolean isMine(char[][] cells, int row, int col)   {
		return (cells[row][col] == '#');
	}
	
	public static int numMines(char[][] cells) {
		int rows = rowsIn(cells);
		int cols = colsIn(cells);
		int n = 0;
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (isMine(cells, r, c)) {
					n += 1;
				}
			}
		}
		return n;
	}
}	


		
	


