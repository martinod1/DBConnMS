package ie.martin;

import ie.martin.model.PurchasedShare;
import ie.martin.model.Share;
import ie.martin.model.UserDet;
import ie.martin.service.ShareRedisService;
import ie.martin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/*
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
*/

import java.util.ArrayList;

@SpringBootApplication
//@EnableAutoConfiguration

@EnableEurekaClient

public class DbCommMsApplication implements CommandLineRunner {

	//implements CommandLineRunner
	@Autowired
	ShareRedisService redis;
	/*
	@Autowired
	UserServiceImpl user;*/

	//@Value("${spring.data.mongodb.host}")
	String host = "host";
	
	//ArrayList<PurchasedShare> shares = new ArrayList();

	public static void main(String[] args) {
		SpringApplication.run(DbCommMsApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(host);
		System.out.println(redis.getShare("GOOG"));

	}
	
	/*  @Override
	    public void run(String ... arg0) throws Exception
	    {
	    	 System.out.println("Redis save");
	    	 Double v1 = redis.getShare("GOOG");
	    	 
	    	 System.out.println(v1.toString());
	    	 
	    	 Share s = new Share();
	    	 s.setName("GOOG");
	    	 s.setValue(10.0);
	    	// shares.add(s);
	    	 UserDet u = new UserDet();
			PurchasedShare p = new PurchasedShare();
			p.setAmount(1);
			p.setShare(s);
			shares.add(p);
	    	 u.setBalance(100000.0);
	    	 u.setName("Martin");
	    	 u.setStocks(shares);
	    	 user.createUser(u);
	    	 

}*/
	    //	System.out.println( redis.findAll().toString());
	    	
	   // }

}






