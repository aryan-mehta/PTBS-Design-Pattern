abstract class Person {
	// use this variable to point to a concrete produtMenu object.
	private ProductMenu theProductMenu;

	/**
	 *  
	 */
	public abstract void showMenu();

	/**
	 *  
	 */
	public void showAddButton() {
		System.out.println("Show Add Button");
	}

	/**
	 *  
	 */
	public void showViewButton() {
		System.out.println("Show View Button");
	}

	public void showRadioButton() {
		System.out.println("Show Radio Button");
	}

	public void showLabels() {
		System.out.println("Show Labels");
	}

	public abstract ProductMenu CreateProductMenu();
}
