package utils;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.*;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		try {
			// create service reg inst from its builder.
			StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
			sf = new MetadataSources(reg).
					buildMetadata().buildSessionFactory();
			System.out.println("sf created ...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static SessionFactory getSf() {
		return sf;
	}
	

}
