package ie.martin;

import ie.martin.model.Share;
import ie.martin.service.ShareRedisService;
import ie.martin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DbCommMsApplication implements CommandLineRunner {
	
	@Autowired
	ShareRedisService redis;
	
	@Autowired
	UserServiceImpl user;
	
	ArrayList<Share> shares = new ArrayList();

	public static void main(String[] args) {
		SpringApplication.run(DbCommMsApplication.class, args);
	}
	
	  @Override
	    public void run(String ... arg0) throws Exception
	    {
	    	/* System.out.println("Redis save");
	    	 Double v1 = redis.getShare("GOOG");
	    	 
	    	 System.out.println(v1.toString());
	    	 
	    	 Share s = new Share();
	    	 s.setName("GOOG");
	    	 s.setValue(10.0);
	    	 shares.add(s);
	    	 UserDet u = new UserDet();
	    	 u.setBalance(100000.0);
	    	 u.setName("Martin");
	    	 u.setStocks(shares);
	    	 user.createUser(u);*/
	    	 
	    	 
	    //	System.out.println( redis.findAll().toString());
	    	
	    }
}




