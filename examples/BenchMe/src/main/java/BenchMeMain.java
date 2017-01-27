package BenchMe.src.main.java;
import static java.lang.Thread.sleep;

/**
 * Created by bookchen on 8/15/16.
 */

public class BenchMeMain {

    public static void main(String[] args){
    	//AppHelloGCounter app = new AppHelloGCounter();
    	//AppConcertAdmission app = new AppConcertAdmission();  
        AppBankAccount app = new AppBankAccount();
    	app.test();
    }

}
