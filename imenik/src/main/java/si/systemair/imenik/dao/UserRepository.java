package si.systemair.imenik.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.systemair.imenik.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "update User u set u = ?1 where u.id = ?2")
    void putUser(Optional<User> user, Long id);
}
