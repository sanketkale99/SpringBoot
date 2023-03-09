package com.spring;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.entity.User;
import com.spring.repository.UserRepository;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(SpringJpaApplication.class, args);
		
		UserRepository userRepository=context.getBean(UserRepository.class);
		
//		User user=new User();
//		user.setName("Sanket");
//		user.setCity("Pune");
//		user.setStatus("Spring Boot Developer");
//		User users=userRepository.save(user);
//		System.out.println(users);
		
		//saving single user
//		User user3=userRepository.save(user1);
//		User user4=userRepository.save(user2);
//		System.out.println(user3 +"\n" +  user4);
		
	//saving multipe users
//		User user1=new User();
//		user1.setName("Aniket");
//		user1.setCity("Mumbai");
//		user1.setStatus("web Developer");
//		
//		User user2=new User();
//		user2.setName("Adi");
//		user2.setCity("Mh");
//		user2.setStatus("Django Developer");
//		
//		List<User> users=List.of(user1,user2);
//		Iterable<User> result=userRepository.saveAll(users);
//		
//		result.forEach(user->{
//			System.out.println(user);
//		});
	
		
		
		//update users
//		Optional<User> optional=userRepository.findById(28);
//		User user=optional.get();
//		user.setCity("Pune");
//		User result=userRepository.save(user);
//		System.out.println(result);
		
		
		
		//how to get the data
		//Iterable<User> itr=userRepository.findAll();
		//type 1 to get all data 
		/* 
		itr.forEach(new Consumer<User>() { 	// Consumer- This is a functional interfacewhose functional method is accept(Object). 

			@Override
			public void accept(User t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
		*/
		//type 2 get all data 
		//itr.forEach(t -> {System.out.println(t);});
		
		// delete user 
		
		//userRepository.deleteAll(allusers);
		
		//find data
//		List<User> users=userRepository.findByCity("Mumbai");
//		users.forEach(t-> System.out.println(t));
		
//		List<User > users=userRepository.findByNameAndCity("Sanket", "Pune");
//		users.forEach(t->{System.out.println(t);});

//		List<User > users=userRepository.getUserByName("Mayur");
// 		users.forEach(t->{System.out.println(t);});

		List<User > users=userRepository.getUsers();
		users.forEach(t->{System.out.println(t);});

	}

}
