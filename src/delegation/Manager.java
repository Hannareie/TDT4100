package delegation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {

	Collection<Employee> undersatte = new ArrayList<Employee>();
	int tasks = 0;
	int neste = 0;
	
//	Manager (Collection<Employee> employees) - utløser et IllegalArgumentException dersom employees er tom
	public Manager(Collection<Employee> employees){
		if(employees.isEmpty()){
			throw new IllegalArgumentException("Du må ha folk under deg, kanskje du heller skulle vært en clerk?");
		}
		this.undersatte = employees;
	}
	
	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		tasks ++;
		if(neste+1 < undersatte.size()){
			neste ++;
		}
		else{
			neste = 0;
		}
		return ((List<Employee>) undersatte).get(neste).doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		tasks ++;
		if(neste+1 < undersatte.size()){
			neste ++;
		}
		((List<Employee>) undersatte).get(neste).printDocument(document);
	}

	@Override
	public int getTaskCount() {
		return this.tasks;
	}

	@Override
	public int getResourceCount() {
		int i = 1;
		for(Employee e : undersatte){
			i += e.getResourceCount();
		}
		return i;
	}
}