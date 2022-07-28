package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User user1 = new User("Ivan", "Ivanov", "ivanov@mail.ru");
      User user2 = new User("Anton", "Antonov", "antonov@mail.ru");
      User user3 = new User("Petr", "Petrov", "petrov@mail.ru");
      Car car1 = new Car("UAZ", 3151);
      Car car2 = new Car("Camry", 1);
      Car car3 = new Car("Camry", 2);
      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      User userByCar1 = userService.getUserByCar("UAZ", 3151);
      User userByCar2 = userService.getUserByCar("Camry", 1);
      User userByCar3 = userService.getUserByCar("Camry", 2);
      System.out.println(userByCar1);
      System.out.println(userByCar2);
      System.out.println(userByCar3);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
