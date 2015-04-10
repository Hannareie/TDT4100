package delegation;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {

	private Iterator<Double> iterator1, iterator2;
	private Double default1, default2;
	BinaryOperator<Double> operator;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator){
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
	}
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator){
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = default1;
		this.default2 = default2;
		this.operator = operator;
	}

	@Override
	public boolean hasNext() {
		if(!this.iterator1.hasNext()){
			if(this.iterator2.hasNext() && this.default1 != null){
				return true;
			}
		}
		if(!this.iterator2.hasNext()){
			if(this.iterator1.hasNext() && this.default2 != null){
				return true;
			}
		}
		if(this.iterator1.hasNext() && this.iterator2.hasNext()){
			return true;
		}
		return false;
	}

	@Override
	public Double next() {
		return null;
	}

}
