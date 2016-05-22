/**
 * 
 */
package dependency.injection;

import java.io.ObjectStreamException;

/**
 * @author Narender Singh
 * Make final 
 * Provide static helper class to crate object and override clone and 
 * readresolve and writeReplace to avoide breaking facory from searilization
 */
public final class Factory {

	private static class FactoryHelper {
		private static final Factory FACTORY = new Factory();

	}
	/**
	 * 
	 */
	private Factory() {
	}

	public static Factory getInstance(){
		return FactoryHelper.FACTORY;
	}

	public Service getService(String name){
		Service service =null;
		if(name.equals("A")){
			service = new ServiceA(getSomeDAO());
		}else{
			service = new ServiceB(getSomeDAO());
		}
		return service;
	}

	private SomeDAO getSomeDAO(){
		return new SomeDAO();
	}
	private Object readResolve() throws ObjectStreamException         {
		return FactoryHelper.FACTORY;
	}
	private Object writeReplace() throws ObjectStreamException {
		return FactoryHelper.FACTORY;
	}
	public Object clone() throws CloneNotSupportedException {
		// return INSTANCE
		throw new CloneNotSupportedException();
	}
}

//or 

enum SingletonFactory {
    INSTANCE;
    public static SingletonFactory getInstance() {
        return INSTANCE;
    }
}
