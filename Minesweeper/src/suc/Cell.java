package suc;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.border.LineBorder;



public class Cell extends JButton {

	private boolean mine = false;
	private int nHood = 0;
	private JButton button;
	public Status s = Status.HIDDEN;
	private int[] loc;
	
	
	/**
	 * No argument constructor, still haven't decided exactly how initializing the board will go.
	 * This will be used in the case that the jButton is part of the cell object, thus the cell object
	 * will have to be initialized before the board is generated, after which it will be given its fields 
	 * through a different method  
	 */
	
	//public Cell() {
		
		//button = new JButton();
		
		//create jButton with given coordinates
	//}
	
	/**
	 * The more I think about it this most likely won't get used.  In the case it does it will accept c from the generated 
	 * board (2d char array) which will determine whether it is a mine or not.  This doesn't really make sense currently
	 * as the board is also populating with numbers which represent how many mines are in an empty cell, meaning I'd need 
	 * to make another constructor for that
	 * @param c
	 */
	
	public Cell(char c, int row, int col) {
		
		System.out.println(Character.toString(c));
		switch(c) {
		
		case '#':
			
			this.mine = true;
			break;
			
		case ('-'):
			
			break;
		
		case ('$'):
			
			break;
			
		default:
			
			this.nHood = c - '0';
			
		}
		
		this.loc = new int[] {row,col};
		
		
		/*if(c == '#') {	
			this.mine = true;
		}*/
		//this.button = new JButton();
		//setText(""+Character.toString(c));
		setText ("("+nHood+")" + Arrays.toString(loc));
		setBorder(new LineBorder(Color.BLACK));
		setPreferredSize(new Dimension(10, 10));
		if(this.mine == true) {
			
			setBackground(Color.ORANGE);
		
		} else if(this.nHood > 0){
			
			setBackground(Color.WHITE);
		
		} else {
			
			setBackground(Color.GRAY);
		}
		
	}
	
	public boolean click(/*action*/) {
		
		boolean gameOver = false;
		
		switch(this.s) {
		
		case HIDDEN:
			
			if(this.mine = true) {
				//game lost
				gameOver = true;
				return gameOver;
			} else {
				//reveal cell
				this.s = Status.REVEALED;
			}
			return gameOver;
			
		case REVEALED:
			
			//revealAdj()
			return gameOver;
			
		default:
			
			return gameOver;
			
		}
	}
	
	public void altClick(/*action*/) {

		switch(this.s) {
		
		case REVEALED:
			
			break;
			
		case FLAGGED:
			
			this.s = Status.HIDDEN;
			
		case HIDDEN:
			
			this.s = Status.FLAGGED;

		}
	}
}
