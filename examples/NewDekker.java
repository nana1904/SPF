

import java.util.HashMap;
import java.util.Map;

import BenchMe.src.main.java.PNCounter;
import BenchMe.src.main.java.PrionCloud;
import gov.nasa.jpf.symbc.Debug;


public class NewDekker {
	 static cloud store= new cloud();//new HashMap<Integer, Integer>();
	int n_replicas=2;
	 //PrionCloud<GCounter> cloud = new PrionCloud<GCounter>(n_replicas, GCounter.class);
	 static int a=0,b=0;
	 
	 public  void newDekker() {
		  int x=1,y=2;
		  	store.put(x, 0);
		  	store.put(y, 0);
		  	
			thread1();
			thread2(); 
			
			assert( a==1 || b==1);//|| y==2  );
		}
		 public void thread1(){
			int x=1,y=2;
			store.put(x,1);
			a=store.get(y);
			//a=x;
			//store.put(x, 1);
			// store.get(y);
			//return a;
		}
		 public void thread2(){
			int x=1,y=2;
			store.put(y,1);
			b=store.get(x);
			//b=y
			//store.put(y, 1);
			 //store.get(x);
			//return b;
		}
	public static void main(String[] args) {
		NewDekker testinst = new NewDekker();
		testinst.newDekker();
	}
	
	// / Free admission
	/*public static void dekker() {
		TransitCenter drip;
		drip = cloud.get(0);
		drip.increase(2); 
		cloud.put(drip);
		drip = cloud.get(1);
		drip.increase(2); 
		cloud.put(drip);
		int y;
		y = drip.value(0);
		System.out.println("y=="+y);
		assert(   y==4 );//|| y==2  );
	}*/
	
}


class cloud{
	static int get(int x){    // change a=x to a=memory.read(x)
		return x;
	}
	static void put(int x, int val){   // change x=b to memory.write(x,b)
		x = val;
	}
}

