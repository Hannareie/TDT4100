package interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {

	private String[][] grid;
	private int rows;
	private int columnCount;
	
	public StringGridImpl(int rows, int columnCount){
		this.rows = rows;
		this.columnCount = columnCount;
		this.grid = new String[rows+1][columnCount+1];
	}
	
	@Override
	public int getRowCount() {
		return this.rows;
	}

	@Override
	public int getColumnCount() {
		return this.columnCount;
	}

	@Override
	public String getElement(int row, int column) {
		return this.grid[row][column];
	}

	@Override
	public void setElement(int row, int column, String element) {
		this.grid[row][column] = element;
	}
	
	@Override
	public Iterator<String> iterator() {
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i <= this.rows; i++){
			for(int j = 0; j <= this.columnCount; j++){
				if(this.grid[i][j] != null){
					temp.add(this.grid[i][j]);					
				}
			}
		}
		return temp.iterator();
	}
}