package assignment5;

public interface IntegerQueue {

	public int size();
	public boolean isEmpty();
	public Integer first() throws EmptyStructureException;
	public Integer dequeue() throws EmptyStructureException;
	public void enqueue(Integer N);
	
}
