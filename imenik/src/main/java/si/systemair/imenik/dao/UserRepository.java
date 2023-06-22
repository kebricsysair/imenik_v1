package si.systemair.imenik.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.systemair.imenik.models.Oddelek;
import si.systemair.imenik.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "update User u set u = ?1 where u.id = ?2")
    void putUser(Optional<User> user, Long id);
    /*
    @Transactional
    @Modifying
    @Query(value = "update User u set u.surname = :sur, u.name = :nam, u.department = :dep, u.businessPhone = :bpho, u.company = :comp," +
            " u.email = :mail, u.jobTitle = :job, u.mobilePhone = :mob, u.number = :num, u.postcode = :post where u.id = :id" )
    void updateUser(Optional<User> user, Long id);

     */

    @Query(value = "select u from User u " +
            "where u.department = IF ((?1 = ''), u.department, ?1) " +
            "and u.name = IF((?2 = ''), u.name, ?2 ) " +
            "and u.surname = IF((?3 = ''), u.surname, ?3)" +
            "and u.postcode = IF((?4 = 0), u.postcode, ?4) or u.priority > 0 order by u.priority desc")
    Iterable<User> filterUsersBy(String department, String name, String surname, Integer postCode);

    @Query(value = "select u from User u order by u.priority desc")
    Iterable<User> getAllUsers();

    @Query(value = "select distinct u.department from User u")
    Iterable<String> getAllDepartments();
}
