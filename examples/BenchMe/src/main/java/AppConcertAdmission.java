package BenchMe.src.main.java;
import static java.lang.Thread.sleep;


/**
 * Created by bookchen on 11/27/16.
 */
public class AppConcertAdmission {
    private final static int n_entrances = 2;  // number of entrances,
    private final static int n_seats   = 3;    // use to test the correctness of this application
    // when n_seats = even, free_admission() will fail, when n_seats = odd, it still work, but just HAPPEN to be correct.
    static PrionCloud cloud = new PrionCloud(n_entrances); // create a RDT/cluster with the same number of replicas/nodes

    public AppConcertAdmission(){
    }

    public void test(){
        free_admission();
       int n_tickets = n_seats;
      //  ticket_admission(n_tickets);

        cloud.propagate(); // make the distributed system to arrive eventual state

        /// below is to check if the result is expected
        GCounter drip = cloud.get(0);
        System.out.print("eventually drip = "+drip.value(0));
        //System.out.print(drip.value());
        System.out.println(", correct drip = " + n_seats);
        assert (drip.value(0)==n_seats);
    }

    void ticket_admission(int n_tickets){
        GCounter drip;
        for(int i=0; i<n_tickets; ++i) {
            drip = cloud.get(i%2);
            drip.increase(1);
            cloud.put(drip);
        }
    }

    void free_admission (){
        int i=1;
        GCounter drip = cloud.get(i%2);
            drip.increase(1);
            cloud.put(drip);
            
            i++;
            drip = cloud.get(i%2);              
            drip.increase(1);
            cloud.put(drip);
            
            i++;
            drip = cloud.get(i%2);            
            drip.increase(1);
            cloud.put(drip);
               
    }
}


