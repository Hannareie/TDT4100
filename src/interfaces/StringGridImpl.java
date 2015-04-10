 
 
package interfaces;
 
import java.util.ArrayList;
 
public class StringGridImpl implements StringGrid{
        private int rows;
        private int columnCount;
        ArrayList<ArrayList<String>> grid;
       
        StringGridImpl(int rows, int columnCount){
                this.rows = rows;
                this.columnCount = columnCount;
                grid = new ArrayList<ArrayList<String>>();
                for (int i = 0; i < rows; i++){
                        ArrayList<String> init = new ArrayList<String>();
                        for (int j = 0; j < columnCount; j++){
                                init.add("0");
                               
                        }
                        grid.add(init);
                       
                }
               
        }
       
        public int getRowCount() {
                return this.rows;
        }
 
       
        public int getColumnCount() {
                return this.columnCount;
        }
 
       
        public String getElement(int row, int column) {
                return grid.get(row).get(column);
        }
 
       
        public void setElement(int row, int column, String element) {
                grid.get(row).set(column, element);
               
        }
       
       
 
}