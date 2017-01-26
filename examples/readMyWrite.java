/*public class readMyWrite {
	static PrionCloud cloud = new PrionCloud(2);

	public static void main(String[] args) {
		readMyWrite();
	}
	
	// / Free admission
	public static void readMyWrite() {
		TransitCenter drip;
		drip = cloud.get(0);
		drip.increase(7); 
		cloud.put(drip);
		//drip = cloud.get(1);
		int y;
		y = drip.value(0);
		assert(7 == y );
	}
}*/

public class readMyWrite {
	// static PrionCloud cloud = new PrionCloud(2);
	public static final int post = 1;
	static cloud1 store = new cloud1();
	static int a = 0, b = 0;

	// / Free admission
	public void simple() {

		// store.put(post, 0);

		session1();
		//session2();

		assert (a == 7 || a==0);

	}

	public void session1() {
		// int post=1;
		store.put(post, 7);
		a = store.get(post);

	}

	/*public void session2() {
		// int post=1;
		a = store.get(post);
		b = store.get(post);

	}
	 */


	public static void main(String[] args) {
		
		readMyWrite testinst = new readMyWrite();
		testinst.simple();
	}

}

/*class cloud1 {
	static int get(int x) { // change a=x to a=memory.read(x)
		return x;
	}

	static void put(int x, int val) { // change x=b to memory.write(x,b)
		x = val;
	}
}*/
