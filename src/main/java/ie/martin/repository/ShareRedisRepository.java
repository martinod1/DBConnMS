package ie.martin.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ShareRedisRepository  {
	
	void add(String key, String value);
	
	String get(String key);

	

}
