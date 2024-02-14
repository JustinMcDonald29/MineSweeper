package suc;
//import javax.swing.*;
//import java.awt.event.*;
import java.util.Arrays;

import javax.swing.SwingUtilities;



public class Main {
	public static void main(String[] args) {
		/*char[][] board = Methods.createBoard(30,24,160);
		board = Methods.populateBoard(board);
		Methods.printBoard(board);*/
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				BoardFrame frame = new BoardFrame(200,200, 2000);
				
			}

		});
		
	
	}

}
