package ie.martin.service;

import ie.martin.model.Share;

import java.util.List;

public interface ShareRedisService {
	
	//void getStocks() throws IOException;
	
	double getShare(String key);
	
	void saveShares(List<Share>shares);

	List<Share> getCachedShares(String []keys);

}
