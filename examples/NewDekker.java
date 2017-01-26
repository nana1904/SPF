
import java.util.HashMap;
import java.util.Map;

//import BenchMe.src.main.java.PNCounter;
//import BenchMe.src.main.java.PrionCloud;
import gov.nasa.jpf.symbc.Debug;

public class NewDekker {
	static cloud store = new cloud();// new HashMap<Integer, Integer>();
	int n_replicas = 2;
	// PrionCloud<GCounter> cloud = new PrionCloud<GCounter>(n_replicas,
	// GCounter.class);
	static int a = 0, b = 0;
	public static final int post1=1, post2=2;

	public void newDekker() {
		int x = 1, y = 2;
		store.put(post1, 0);
		store.put(post2, 0);

		session1();
		session2();

		assert (a == 1 || b == 1);// || y==2 );
	}

	public void session1() {
		int x = 1, y = 2;
		store.put(post1, 1);
		a = store.get(post2);
		// a=x;
		// store.put(x, 1);
		// store.get(y);
		// return a;
	}

	public void session2() {
		int x = 1, y = 2;
		store.put(post2, 1);
		b = store.get(post1);
		// b=y
		// store.put(y, 1);
		// store.get(x);
		// return b;
	}

	public static void main(String[] args) {
		NewDekker testinst = new NewDekker();
		testinst.newDekker();
	}

	// / Free admission
	/*
	 * public static void dekker() { TransitCenter drip; drip = cloud.get(0);
	 * drip.increase(2); cloud.put(drip); drip = cloud.get(1); drip.increase(2);
	 * cloud.put(drip); int y; y = drip.value(0); System.out.println("y=="+y);
	 * assert( y==4 );//|| y==2 ); }
	 */

}

class cloud {
	static int get(int x) { // change a=x to a=memory.read(x)
		return x;
	}

	static void put(int x, int val) { // change x=b to memory.write(x,b)
		x = val;
	}
}
