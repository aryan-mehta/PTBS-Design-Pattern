//Bridge Pattern - abstract class on one side of the bridge
abstract class Person {
	public UserInfoItem personInformation;
	// use this variable to point to a concrete productMenu object.
	private ProductMenu theProductMenu;

	/**
	 *  
	 */
	public abstract void showMenu();

	/**
	 *  
	 */
	//Call this function to show the 'Add' Button
	public void showAddButton() {
		System.out.println("Show Add Button");
	}

	/**
	 *  
	 */
	//Call this function to show the 'View' Button
	public void showViewButton() {
		System.out.println("Show View Button");
	}

	//Call this function to show the 'Radio' Button
	public void showRadioButton() {
		System.out.println("Show Radio Button");
	}

	//Call this function to show the 'Labels'
	public void showLabels() {
		System.out.println("Show Labels");
	}

	//The Abstract Factory Method - According to the product type create product menu
	public abstract ProductMenu CreateProductMenu();
}
