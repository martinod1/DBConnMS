package ie.martin.rest;

import ie.martin.model.PurchasedShare;
import ie.martin.model.RequestObject;
import ie.martin.model.Share;
import ie.martin.model.UserDet;
import ie.martin.service.ShareRedisService;
import ie.martin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShareRestAPI {
	
	@Autowired
	private ShareRedisService redis;

	@Autowired
	private UserService user;



	
	@RequestMapping(value="/get-share", method=RequestMethod.GET)
	public double getShare() {
		return redis.getShare("GOOG");
	}
	
	@RequestMapping(value="/cache-shares-to-redis", method=RequestMethod.POST)
	public void cacheSharesToRedis(@RequestBody RequestObject request) {

		System.out.println("in DB rec shares");
		List<Share> shares = request.shareList;

		redis.saveShares(shares);
	}
	//implement this part
	@RequestMapping(value="/get-cached-shares", method=RequestMethod.GET)
	public List<Share> getCachedShares(String [] shareNames)
	{

		System.out.println("inside getting cached shares");
		//hardcoded in for now
		String  stocks [] = {"AAPL","GOOG","IBM","MSFT","FB","INTC"};

		List<Share> shares = redis.getCachedShares(stocks);
		for(Share s: shares)
		{
			System.out.println(s.toString());
		}
		return shares;
	}

	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public void addUser(@RequestBody RequestObject request)
	{
	/*	ArrayList<Share> shares = new ArrayList<Share>();
		UserDet usr = new UserDet();
		usr.setName("Martin1");
		usr.setBalance(1000000);
		usr.setStocks(shares);*/
		UserDet usr = request.getUser();

		user.createUser(usr);

	}

	//@RequestBody RequestObject request
	@RequestMapping(value="/buy-share", method=RequestMethod.GET)
	public void buyShare()
	{
		//UserDet usr = request.getUser();

		ArrayList<PurchasedShare> shares = new ArrayList<PurchasedShare>();
		UserDet usr = new UserDet();
		usr.setName("Martin1");
		usr.setBalance(1000000);

		Share s = new Share();
		s.setName("GOOG");
		s.setValue(10000.12);
		PurchasedShare p = new PurchasedShare();
		p.setShare(s);
		p.setAmount(12);
		shares.add(p);
		usr.setStocks(shares);
		user.buyShare(usr);
	}
	@RequestMapping(value="/sell-share", method=RequestMethod.GET)
	public void sellShare()
	{
		UserDet u = user.getPortfolio("Martin1");

	}

	@RequestMapping(value="/get-portfolio", method=RequestMethod.GET)
	public UserDet getUserPortfolio()
	{
		UserDet u = user.getPortfolio("Martin1");
		System.out.println(u.toString());
		return u;
	}


}


