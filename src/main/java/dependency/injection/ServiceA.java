/**
 * 
 */
package dependency.injection;

/**
 * @author Narender Singh
 *
 */
public class ServiceA implements Service{

	private SomeDAO someDao;
	/**
	 * 
	 */
	public ServiceA(SomeDAO someDao) {
		 
		this.someDao =someDao;
	}
	
	public void someFunction(){
		System.out.println("ServiceB");
		someDao.someFunction();
	}
}
