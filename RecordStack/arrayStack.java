
public class arrayStack implements stackADT {
	/** The number of items in the stack ALSO THE TOP OF STACK */
	int sizeTop;
	// int top = sizeTop;
	/** the stack itself, holding records */
	stackRecord[] stack;

	public arrayStack(int sizeTop) { // implements stack adt
		this.sizeTop = 0;
		this.stack = new stackRecord[sizeTop];

	}

	/* ------------------- Methods ------------------- */

	private void expandCapacity() {
		System.out.println("---------expanding capacity---------");
		stackRecord[] tempStack = new stackRecord[stack.length * 2];
		for (int i = 0; i < stack.length; i++) { // for all items in full stack
			tempStack[i] = stack[i];
		}
		this.stack = tempStack;

	}

	/**
	 * 
	 */
	public void put(stackRecord record) throws stackException {
		if (stack.length == getSize()) { // stack is full
			expandCapacity();
		}
		if (stack.length != getSize()) {
			stack[sizeTop] = record;
			System.out.println("putting record " + record.getName() + " at top " + sizeTop + " successful!!");
			sizeTop++;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stackADT#remove()
	 */
	public void remove() throws stackException {
		if (stack.length == 0 || stack == null) { // stack is not of a real size
			throw new stackException("Error : Can't remove item from empty stack");
		}
		stackRecord tempStackRecord = stack[sizeTop - 1];

		// if (stack.length != getSize()) {
		stack[sizeTop - 1] = null; // dont need to set the record to null since type objects are defaulted to null
		sizeTop--;
		System.out.println("removed record " + tempStackRecord.getName() + " at top " + sizeTop + " successful!!");

		// }

	}

	/**
	 * Displays the first item in the stack
	 */
	public void first() throws stackException {
		if (stack.length == 0 || stack == null) { // stack is not of a real size
			throw new stackException("Error : Can't put item in stack");
		}
		System.out.print("The top record of the stack is: ");
		stack[sizeTop - 1].printRec();

	}

	/**
	 * Returns the number of items in the stack
	 */
	public int getSize() {
		return sizeTop;

	}

	/**
	 * displays contents of stack by simply displaying them
	 */
	public void toStringStack() {
		String result = "";
		for (int i = 0; i < sizeTop; i++) { // for all items in stack
			result = result + stack[i].getName() + " " + stack[i].getAge() + "\n";
		}

		System.out.println(result);
	}

}
