package com.onespan.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.onespan.hibernate.dto.Address;
import com.onespan.hibernate.dto.User;

public class HibernateTest {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId(3);
		user1.setUserName("Kenan Engineer");

		Address kenanAddress = new Address();
		kenanAddress.setStreet("1231");
		kenanAddress.setCity("Surat");
		kenanAddress.setState("Gujarat");
		kenanAddress.setPincode("12345");

		user1.setAddress(kenanAddress);
		user1.setJoinedDate(new Date());
		user1.setDescription("Kenan Description");

		final SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.getTransaction().commit();
		session.close();

		user1 = null;

		session = sessionFactory.openSession();
		user1 = (User) session.get(User.class, 1);
//		user1.getListOfAddresses();
	}
}
