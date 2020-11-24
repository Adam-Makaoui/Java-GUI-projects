
public interface stackADT {

	/**
	 * Inserts item to the top of the array stack that is the next available slot
	 * (its null)
	 * 
	 * @param record - the record to put
	 * @throws stackException - indicates that we can't put.
	 */
	public void put(stackRecord record) throws stackException;

	/**
	 * removes the top most element of the stack or throws an exception
	 * 
	 * @throws stackException - can't remove an item that doesn't exist
	 */
	public void remove() throws stackException;

	/**
	 * displays to the console the top-most item of the stack
	 * 
	 * @throws stackException
	 */
	public void first() throws stackException;

	/**
	 * displays the stack onto the console
	 */
	public void toStringStack();

	/**
	 * 
	 * @return an int representing the size of the stack
	 */
	public int getSize();

}
