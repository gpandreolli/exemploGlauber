package utfpr.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateHelper {

	public static void save(Object object) throws Exception {
		try {
			Session session = HibernateHelper.openSession();
			Transaction transaction = session.beginTransaction();
			try {
				session.saveOrUpdate(object);
				transaction.commit();
			} catch (RuntimeException e) {
				transaction.rollback();
				throw(e);
			} finally {
				session.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void delete(Object object) throws Exception {
		try {
			Session session = HibernateHelper.openSession();
			Transaction transaction = session.beginTransaction();
			try {
				session.delete(object);
				transaction.commit();
			} catch (RuntimeException e) {
				transaction.rollback();
				throw(e);
			}
			finally {
				session.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static void update(Object object) throws Exception {
		try {
			Session session = HibernateHelper.openSession();
			Transaction transaction = session.beginTransaction();
			try {
				session.merge(object);
				transaction.commit();
			} catch (RuntimeException e) {
				transaction.rollback();
				throw(e);
			} finally {
				session.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static Session openSession() throws Exception {
		try {
			return HibernateManager.getInstance().openSession();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void closeSession() throws Exception {
		try {
			HibernateManager.getInstance().close();
		} catch (Exception e) {
			throw e;
		}
	}
	
}