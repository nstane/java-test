/**
 * 
 */
package dependency.injection;

/**
 * @author Narender Singh
 *
 */
public class DependenciesInjection {

	private Service serviceA =Factory.getInstance().getService("A");
	/**
	 * 
	 */
	public DependenciesInjection() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		new DependenciesInjection().testServices();
	}
	
	private void testServices(){
		serviceA.someFunction();
	}
}
