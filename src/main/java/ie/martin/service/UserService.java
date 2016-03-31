package ie.martin.service;

import ie.martin.model.UserDet;


public interface UserService {

	UserDet createUser(UserDet u);
	UserDet buyShare(UserDet u);
	UserDet sellShare(UserDet u);
	UserDet getPortfolio(String username);
}

/* 	UserDet createUser(UserDet user);
	UserDet findByUsername(String username);
	List<UserDet> findAllUsers(); */
