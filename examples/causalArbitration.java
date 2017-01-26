public class causalArbitration {
	// static PrionCloud cloud = new PrionCloud(2);
	public static final int post = 1;
	static cloud store = new cloud();
	static int a = 0, b = 0;

	// / Free admission
	public void simple() {

		// store.put(post, 0);

		session1();
		session2();
		session3();
		assert (a == b);
		System.out.println("a="+a+",b="+b);
	}

	public void session1() {
		// int post=1;
		store.put(post, 1);

	}

	public void session2() {
		// int post=1;
		a = store.get(post);
		//b = store.get(post);
	    	store.put(post, 2);

	}

    	public void session3() {
		// int post=1;
		b = store.get(post);
	       
		//b = store.get(post);

	}


	public static void main(String[] args) {
		
		causalArbitration testinst = new causalArbitration();
		testinst.simple();
	}

}

class cloud {
	static int get(int x) { // change a=x to a=memory.read(x)
		return x;
	}

	static void put(int x, int val) { // change x=b to memory.write(x,b)
		x = val;
	}
}
