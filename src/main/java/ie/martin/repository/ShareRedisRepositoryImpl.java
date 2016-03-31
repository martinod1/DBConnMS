package ie.martin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository("shareRedisRepository")
public class ShareRedisRepositoryImpl implements ShareRedisRepository {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public RedisTemplate<String, String> getRedisTemplate()
	{
		return redisTemplate;
	}
	
	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void add(String key, String value){
		redisTemplate.boundValueOps(key).set(value);
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}




}
