package si.systemair.imenik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.systemair.imenik.dao.UserRepository;
import si.systemair.imenik.models.Oddelek;
import si.systemair.imenik.models.User;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userDao;
    @GetMapping("/")
    public Iterable<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userDao.findById(id);
    }
    @PostMapping("/private/post/user/new")
    public User postUser(@RequestBody User user){
        System.out.println(user);
        /*
        User newUser = userDao.save(user);
        Long id = newUser.getId();
        return id;
         */
        return userDao.save(user);
    }
    @DeleteMapping("/private/delete/user/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userDao.deleteById(id);
    }

    @GetMapping("/filter")
    public Iterable<User> returnFilteredUsers(
            @RequestParam("department") String department,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("postCode") Integer postCode
    ){
        System.out.println(userDao.filterUsersBy(department, name, surname, postCode));

        Iterable<User> filteredUsers = userDao.filterUsersBy(department, name, surname, postCode);

        return userDao.filterUsersBy(department, name, surname, postCode);
    }
    @GetMapping("/departments")
    public Iterable<String> getAllDepartments(){
        return userDao.getAllDepartments();
    }

    /*
    nesi na frontend -urejanje naredi, da imas v input oknih ze vrednosti
     */
    @PutMapping("/private/put/user/{id}")
    public void putUser(@PathVariable("id") Long id, @RequestBody User user){
        /*
        Optional<User> oldUser = userDao.findById(id);
        System.out.println(user);
        if(oldUser == null){
            System.out.printf("Error. User does not exist.");
            return;
        }
        userDao.updateUser(Optional.ofNullable(user), id);

        try{
            if(user.getName() != null) oldUser.orElseThrow().setName(user.getName());
            if(user.getSurname() != null) oldUser.orElseThrow().setSurname(user.getSurname());
            if(user.getEmail() != null) oldUser.orElseThrow().setEmail(user.getEmail());
            if(user.getBusinessPhone() != null) oldUser.orElseThrow().setBusinessPhone(user.getBusinessPhone());
            if(user.getCompany() != null) oldUser.orElseThrow().setCompany(user.getCompany());
            if(user.getJobTitle() != null) oldUser.orElseThrow().setJobTitle(user.getJobTitle());
            if(user.getMobilePhone() != null) oldUser.orElseThrow().setMobilePhone(user.getMobilePhone());
            if(user.getNumber() != null) oldUser.orElseThrow().setNumber(user.getNumber());
            if(user.getPostcode() != null) oldUser.orElseThrow().setPostcode(user.getPostcode());
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        userDao.putUser(oldUser, oldUser.orElseThrow().getId());

         */
    }
}
