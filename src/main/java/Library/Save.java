package Library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Save {

	public static void main(String[] args) {
		
		Configuration con= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Autor.class).
				addAnnotatedClass(Books.class).
				addAnnotatedClass(Visitor.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Autor yazar1=new Autor(10, "Adem Kara");
		Autor yazar2=new Autor(20, "Mehmet Yasa");
		Autor yazar3=new Autor(30, "Sinem Durmus");
		
		Visitor ziy1=new Visitor(1000, "Alex", 1);
		Visitor ziy2=new Visitor(2000, "Sofie", 2);
		Visitor ziy3=new Visitor(3000, "Emilie", 5);
		Visitor ziy4=new Visitor(4000, "Ronaldo", 3);
		
		Books kitap1=new Books(111, "Kurtlarla Dans", "Ingilizce");
		yazar1.getKitapBilgi().add(kitap1);
		ziy1.getKitapBilgiZyr().add(kitap1);
				
		Books kitap2=new Books(222, "Ates Altinda", "Turkce");
		yazar1.getKitapBilgi().add(kitap2);
		ziy1.getKitapBilgiZyr().add(kitap2);
		
		
		Books kitap3=new Books(333, "Ozgurluk", "Ingilizce");
		yazar2.getKitapBilgi().add(kitap3);
		ziy4.getKitapBilgiZyr().add(kitap3);
		
		Books kitap4=new Books(444, "ALtin Madeni", "Fransizca");
		yazar2.getKitapBilgi().add(kitap4);
		ziy2.getKitapBilgiZyr().add(kitap4);
		
		Books kitap5=new Books(555, "Rica", "Turkce");
		yazar3.getKitapBilgi().add(kitap5);
		ziy4.getKitapBilgiZyr().add(kitap5);
	
		session.save(yazar1);
		session.save(yazar2);
		session.save(yazar3);
		session.save(ziy1);
		session.save(ziy2);
		session.save(ziy3);
		session.save(ziy4);
		session.save(kitap1);
		session.save(kitap2);
		session.save(kitap3);
		session.save(kitap4);
		session.save(kitap5);
		
		
		
		tx.commit();
		session.close();
		sf.close();

	}

}
