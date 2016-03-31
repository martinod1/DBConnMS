package ie.martin.service;

import ie.martin.model.UserDet;
import ie.martin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	public UserDet insert(UserDet user) {
		return repo.save(user);
	}


	
	@Override
	public UserDet createUser(UserDet user) {
		return repo.insert(user);

	}

	@Override
	public UserDet buyShare(UserDet u) {
		return repo.insert(u);
	}

	public UserDet sellShare(UserDet u) {return repo.insert(u);}

	@Override
	public UserDet getPortfolio(String username) {
		System.out.println("inside service");
		//System.out.println(username);
		UserDet u = repo.findByName("Martin1");
		//if(u.toString()== Null)
		{
			System.out.println("NULL");
		}
	//	else
		{
			System.out.println("not null");
		}
		return repo.findByName(username);
	}

}



/*@Autowired
	private UserRepository repo;

	public UserDet insert(UserDet user) {
		
		return repo.save(user);
		
	}
	
	@Override
	public UserDet createUser(UserDet user) {
		return repo.insert(user);
	}

	@Override
	public UserDet findByUsername(String username) {
		
		return repo.findByUsername(username);
		
	}

	@Override
	public List<UserDet> findAllUsers() {
		
		return repo.findAll();
	}
*/
