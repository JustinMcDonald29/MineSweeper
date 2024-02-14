package suc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BoardFrame {

	private JFrame frame;
	private JPanel panel;
	private char[][] board;
	public BoardFrame(int rows, int cols, int mines) {
		initialize(rows, cols, mines);
	}
	
	private void initialize(int rows, int cols, int mines) {
		
		board = Methods.createBoard(rows, cols, mines);
		Methods.printBoard(board);
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 800);
		frame.setMinimumSize(new Dimension(250,400));
		frame.setBackground(Color.GRAY);
		frame.setLocationRelativeTo(null);
		
		GridLayout gLayout = new GridLayout();
		
		gLayout.setColumns(cols);
		gLayout.setRows(rows);
		gLayout.setHgap(0);
		gLayout.setVgap(0);
		
		BorderLayout bLayout = new BorderLayout();
		
		bLayout.setHgap(50);
		bLayout.setVgap(80);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 400, 640);
		panel.setBackground(Color.BLUE);
		
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				Cell cell = new Cell(board[r][c],r,c);
				//cell.setText(Character.toString(board[r][c]));
				//cell.setBorder(new LineBorder(Color.BLACK));
				//cell.setPreferredSize(new Dimension(10, 10));
				panel.add(cell);
			}
			
			
		}
		
		panel.setLayout(gLayout);
		frame.add(panel, bLayout.CENTER);
		frame.setVisible(true);
	}
}
