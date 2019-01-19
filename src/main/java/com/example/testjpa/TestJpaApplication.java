package com.example.testjpa;

import com.example.testjpa.model.*;
import com.example.testjpa.repository.OrderRepository;
import com.example.testjpa.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
public class TestJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestJpaApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
        Order order = newOrder();

        orderRepository.findById(order.getId());
        orderRepository.findAll();
        orderRepository.findByName(order.getName());
        orderRepository.findByIds(Collections.singletonList(order.getId()));
        System.out.println();
    }

    public Order newOrder() {
        User user = new User();
        user.setName("tada");

        IDCard card = new IDCard("card");
        card.setType(new IDCardType("todo"));
        user.setCard(card);

        Country country = new Country("VN");
        country.setUnion(new Union("union"));

        City hcm = new City("HCM");
        hcm.setCountry(country);
        user.setCity(hcm);

        Subject subject = new Subject("bala");
        subject.setUser(user);
        user.setSubjects(Collections.singletonList(subject));

        Order order = new Order();
        order.setName("tada");
        order.setCustomer(user);

        orderRepository.save(order);

        return order;
    }
}

