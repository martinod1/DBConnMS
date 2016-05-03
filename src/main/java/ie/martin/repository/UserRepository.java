package ie.martin.repository;

import ie.martin.model.UserDet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDet, String> {

}
