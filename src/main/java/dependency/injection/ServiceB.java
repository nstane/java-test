/**
 * 
 */
package dependency.injection;

/**
 * @author Narender Singh
 *
 */
public class ServiceB implements Service{

	private SomeDAO someDao;
	/**
	 * 
	 */
	public ServiceB(SomeDAO someDao) {
		 
		this.someDao =someDao;
	}
	
	public void someFunction(){
		System.out.println("ServiceB");
		someDao.someFunction();
	}


}
