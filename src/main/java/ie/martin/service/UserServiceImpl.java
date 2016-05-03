package ie.martin.service;

import ie.martin.model.UserDet;
import ie.martin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.cache.support.NullValue;
*/
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

		//get name in portfolio
		String name = user.getName();

		//check if already exists
		UserDet oldUser = repo.findOne(name);
		if(oldUser!=null)
		{
			//delete if user already has portfolio
			repo.delete(oldUser.getName());
		}
		//insert updated portfolio
		return repo.insert(user);
	}

/*
	@Override
	public UserDet buyShare(UserDet u) {
		return repo.insert(u);
	}
*/

	public UserDet sellShare(UserDet u) {return repo.insert(u);}

	@Override
	public UserDet getPortfolio(String username) {
		System.out.println("inside service user is " +username);
		//System.out.println(username);
		System.out.println(repo.findAll());
		UserDet u = repo.findOne(username);
		//if(u.toString()== Null)
		{
	//		System.out.println("NULL");
		}
	//	else
		{
		//	System.out.println("not null");
		}

		//System.out.println(u.toString());
		return repo.findOne(username);
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
