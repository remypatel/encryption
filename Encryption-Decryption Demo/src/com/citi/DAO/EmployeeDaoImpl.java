package com.citi.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.citi.Entity.Employee;
import com.citi.Service.EncryptorService;

public class EmployeeDaoImpl implements EmployeeDao
{


  public Employee getEmployee(int id) {
	Session session=EncryptorService.getSessionFactory().openSession();
	Transaction transaction = null;
	Employee employee= null;
	try {
		transaction = session.beginTransaction();
		 employee=(Employee) session.load(Employee.class,id);
		transaction.commit();
		
	} catch (HibernateException e) {
		transaction.rollback();
		e.printStackTrace();
	} finally {
		session.close();
		
	}
	return employee;
   
	
}
	 
	public void saveEmployee(Employee e){
		Session session = EncryptorService.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(e);
			transaction.commit();
		} catch (HibernateException e1) {
			transaction.rollback();
			e1.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	
	

}
