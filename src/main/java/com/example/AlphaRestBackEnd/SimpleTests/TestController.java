package com.example.AlphaRestBackEnd.SimpleTests;

import com.example.AlphaRestBackEnd.DAO.BeverageDir.BeverageDao;
import com.example.AlphaRestBackEnd.DAO.BeverageDir.BeverageDetailDao;
import com.example.AlphaRestBackEnd.DAO.JpaRepository.*;
import com.example.AlphaRestBackEnd.DAO.ManufacturerDir.ManufacturerDao;
import com.example.AlphaRestBackEnd.DAO.UserDir.UserDao;
import com.example.AlphaRestBackEnd.DAO.UserDir.UserDetailDao;
import com.example.AlphaRestBackEnd.Entity.Beverage;
import com.example.AlphaRestBackEnd.Entity.Manufacturer;
import com.example.AlphaRestBackEnd.Entity.User;
import com.example.AlphaRestBackEnd.Entity.UserDetail;
import com.example.AlphaRestBackEnd.Service.UserDir.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private UserDao userDao;
    private BeverageDao beverageDao;
    private UserDetailDao userDetailDao;
    private BeverageDetailDao beverageDetailDao;
    private ManufacturerDao manufacturerDao;

    private UserJpaRepository userJpaRepository;
    private UserDetailJpaRepository userDetailJpaRepository;
    private ManufacturerJpaRepository manufacturerJpaRepository;
    private BeverageJpaRepository beverageJpaRepository;
    private BeverageDetailJpaRepository beverageDetailJpaRepository;

    private UserService userService;

    @Autowired
    public TestController(UserService userService ,UserDao userDao, BeverageDao beverageDao, UserDetailDao userDetailDao, BeverageDetailDao beverageDetailDao, ManufacturerDao manufacturerDao, UserJpaRepository userJpaRepository, UserDetailJpaRepository userDetailJpaRepository, ManufacturerJpaRepository manufacturerJpaRepository, BeverageJpaRepository beverageJpaRepository, BeverageDetailJpaRepository beverageDetailJpaRepository) {
        this.userDao = userDao;
        this.beverageDao = beverageDao;
        this.userDetailDao = userDetailDao;
        this.beverageDetailDao = beverageDetailDao;
        this.manufacturerDao = manufacturerDao;
        this.userJpaRepository = userJpaRepository;
        this.userDetailJpaRepository = userDetailJpaRepository;
        this.manufacturerJpaRepository = manufacturerJpaRepository;
        this.beverageJpaRepository = beverageJpaRepository;
        this.beverageDetailJpaRepository = beverageDetailJpaRepository;

        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/userDetail")
    public List<UserDetail> findAllPLM() {
        return userDetailDao.findAll();
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable int userId) {
        return userDao.findById(userId);
    }

    @GetMapping("/userDetails/{userDetailId}")
    public UserDetail findByIdPLM(@PathVariable int userDetailId) {
        return userDetailDao.findById(userDetailId);
    }

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        user.setId(0);
        userDao.save(user);
        return user;
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        userDao.save(user);
        return user;
    }

    @DeleteMapping("/user/{userId}")
    public String deleteById(@PathVariable int userId) {
        userDao.deleteById(userId);
        return "Deleted employee with id: " + userId;
    }


    @GetMapping("/beverage")
    public List<Beverage> findAllBeverages() {
        return beverageDao.findAll();
    }

    @GetMapping("/beverage/{beverageId}")
    public Beverage findBeverageById(@PathVariable int beverageId) {
        return beverageDao.findById(beverageId);
    }

    @GetMapping("/manufacturer")
    public List<Manufacturer> findAllManufacturers() {
        return manufacturerDao.findAll();
    }

    @GetMapping("/manufacturer/{manufacturerId}")
    public Manufacturer findManufacturerById(@PathVariable int manufacturerId) {
        return manufacturerDao.findById(manufacturerId);
    }

    /////////////////////////////////////////////////////////////////

    @GetMapping("/userJpa")
    public List<User> findAllJpa() {
        return userJpaRepository.findAll();
    }

    @GetMapping("/beverageJpa")
    public List<Beverage> findAllBeveragesJpa() {
        return beverageJpaRepository.findAll();
    }

    @GetMapping("/manufacturerJpa")
    public List<Manufacturer> findAllManufacturersJpa() {
        return manufacturerJpaRepository.findAll();
    }


    //Logging test
    @RequestMapping("/logTest")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

}

