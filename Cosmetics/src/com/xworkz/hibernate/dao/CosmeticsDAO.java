package com.xworkz.hibernate.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.hibernate.dto.CosmeticsDTO;
import com.xworkz.hibernate.util.HibernateUtil;


public class CosmeticsDAO {

	public CosmeticsDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("CosmeticsDAO created..................");
	}

	public boolean save(CosmeticsDTO dtos) {
		System.out.println("started save method with args:\t");
		boolean flag = true;
		
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			System.out.println("saving dto with session \t");
			session.save(dtos);
			tx.commit();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
			tx.rollback();
			flag = false;
		} finally {
			session.close();
			
		}

		return flag;

	}
	
	public List<CosmeticsDTO> getBySearch(String brand) {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			System.out.println("method invoked");
			Query query = session.getNamedQuery("simpleFetch");
			query.setParameter("cbrand", brand);
			List<CosmeticsDTO> list = query.list();
			System.out.println("data invoked................" );
			System.out.println(list);
			return list;
			
			
} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {

			session.close();
		}
		
		return null;
	}

}
