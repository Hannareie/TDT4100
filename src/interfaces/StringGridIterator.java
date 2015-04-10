//Fant ut at selve next() koden gjorde det sikk motsatt av det jeg hadde tenkt, så jeg byttet om koden for rowMajor og !rowMajor.
 
package interfaces;
 
import java.util.Iterator;
 
public class StringGridIterator implements Iterator<String> {
        private StringGrid grid;
        private boolean rowMajor;
        private int rows;
        private int columnCount;
       
       
        StringGridIterator(StringGrid grid, boolean rowMajor){
                this.grid = grid;
                this.rowMajor = rowMajor;
               
               
        }
        @Override
        public boolean hasNext() {
        	return !((rows == grid.getRowCount()) || (columnCount == grid.getColumnCount()));
        	}
               
       
 
        @Override
        public String next() {
                String element = grid.getElement(rows, columnCount);
                if (rowMajor){
                        if(columnCount < grid.getColumnCount()-1){
                                columnCount++;
                        }
                        else{
                                columnCount = 0;
                                rows++;
                        }
                }
                else{
                        if (rows < grid.getRowCount()-1){
                                rows++;
                        }
                        else{
                                rows = 0;
                                columnCount++;
                        }
                }
                return element;
               
               
        }
 
        @Override
        public void remove() {
                throw new UnsupportedOperationException("You are not allowed to remove strings form the grid");
               
        }
       
 
}
 
 
 