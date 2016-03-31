package ie.martin.service;

import ie.martin.model.Share;
import ie.martin.repository.ShareRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShareRedisServiceImpl implements ShareRedisService{

	@Autowired
	ShareRedisRepository shareRepo;
	
	@Override
	public double getShare(String key) {
		
		String value = shareRepo.get(key);
		
		//change returned value to double
		double v = Double.parseDouble(value);
		
		System.out.println("Value = " + value);
		
		return v;
		
		
	}

	@Override
	public void saveShares(List<Share> shares) {
		//loop through each share  in list
		for(Share s:shares)
		{
			//System.out.println("within share saving!!!");
			//cast from double to string to save to DB
			String value = String.valueOf(s.getValue());
			shareRepo.add(s.getName(), value);
		}
		
	}

	@Override
	public List<Share> getCachedShares(String [] keys) {

		List<Share> shares = new ArrayList<Share>();
		for( String key: keys)
		{
			Share s = new Share();
			s.setName(key);
			Double value = Double.parseDouble(shareRepo.get(key));
			s.setValue(value);
			shares.add(s);
		}
		return shares;
	}


}
