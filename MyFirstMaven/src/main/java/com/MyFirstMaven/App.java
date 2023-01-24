package com.MyFirstMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student obj
		Student st = new Student();
		st.setId(102312);
		st.setName("amit");
		st.setCity("new delhi");
		System.out.println(st);

		// creating obj of address
		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("DELHI");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1232.32);

		// reading image
		FileInputStream fis = new FileInputStream("src/main/java/photo.png");
		byte[] date = new byte[fis.available()];
		fis.read();
		ad.setImage(date);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(st);
		session.save(ad);

		tx.commit();
		session.close();
		System.out.println("done...");

		// SessionFactory factory =new
		// Configuration().configure().buildSessionFactory();

	}
}
