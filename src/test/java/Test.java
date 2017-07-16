import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.function.Function;

import com.naren.others.Person;

/**
 * 
 */

/**
 * @author nstanwar
 *
 */
public class Test {

	public final static Comparator<Person> COMPARATOR = Comparator.comparing(Person::getfName)
			.thenComparing(Person::getfName);
	public final static Function<Person, String> TO_STRING = p -> p.getfName() + " " + p.getfName();
	static int i = 10;
	private static final String STR = "Test {userName} if you can ? ";

	/**
	 * 
	 */
	public Test() {

	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// test21();

		List list = new ArrayList<>();

		list.add("12");// 12
		list.add(Arrays.asList(new String[] { "12", "34", "55" }));// [12]

		list.add(Arrays.asList(Arrays.asList(new String[] { "12", "34", "55" }).toArray()));// [12,[12],[[12]]]

		System.out.println(list);
		flatList(list);

	}

	private static void flatList(Object obj) {

		if (obj instanceof String) {
			System.out.println((String) obj);
		} else {
			List list = (List) obj;
			for (Object item : list) {
				if (item instanceof String) {
					System.out.println((String) item);
				} else {
					List listChild = (List) item;
					flatList(listChild);
				}
			}
		}

	}

	/**
	 * 
	 */
	private static void test21() {
		boolean b = true;
		boolean b1 = false;
		System.out.println(b & b1);
		System.out.println("I like Coding".charAt(12));
		int x = 5 >> 2;
		int x1 = x >>> 2;
		System.out.println("X1" + x1);
		Test t = new Test();
		t.m();
		Object o = 1;
		synchronized (o) {
			// method of object class
			// release lock to execute other thread
			// use in thread intercommunication
			// throw exception java.lang.IllegalMonitorStateException if use
			// without synchronized block or method
			// o.wait();
			// o.notify();
		}
		// Sleep is static method of thread class
		// throws InterruptedException exception
		// Pause current thread for some time
		// Don't release lock
		try {
			// Thread.sleep(1);
		} catch (Exception e) {

		}

		System.out.println("D" + o);
		System.out.println(STR.replace("{userName}", "Narender"));
	}

	@SuppressWarnings("unused")
	private static void test() {
		// Tree set not allow null because it use binary tree and sort element
		// so it will throw null pointer exception
		Set<String> set = new TreeSet<String>();
		// set.add(null);
		// set.add(null);
		// set.add(null);
		String s = null;
		String d = (s != null ? s : "2222");
		Person p = new Person();
		p.setAge(12);
		p.setfName("Narneder");
		// pass by reference
		System.out.println(p);
		passMe(p);
		System.out.println(p);
		String message = "Smoky";
		System.out.println(message);
		passMe(message);
		System.out.println(message);
		int postedRewards = 0;
		for (int i = 1; i < 100; i++) {
			System.out.println("-----------" + postedRewards);
			if (postedRewards == 99) {
				break;
			}
			for (int j = 0; j < 100; j++) {
				postedRewards++;
				if (postedRewards == 99) {
					break;
				}
			}

		}
	}

	private static void passMe(final Object p) {
		if (p instanceof String) {
			// p = "fucker";
		} else if (p instanceof Person) {
			Person person = (Person) p;
			person.setAge(45);
			person.setfName("Holy Smoke");
		}
	}

	@SuppressWarnings("unused")
	private static void getISODate() {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());
		System.out.println(nowAsISO);
		// 2016-03-07T07:36:25Z
		String thisMoment = String.format("%tFT%<tRZ", Calendar.getInstance(TimeZone.getTimeZone("Z")));
		System.out.println(thisMoment);
	}

	void m() {
		System.out.println(Test.i);
	}
}

class A {
	public void blah() {
		System.out.println("a");
	}
}

class B extends A {
	// private void blah() {System.out.println("b");}
}
