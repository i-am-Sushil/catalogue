package com.food.order.catalogue.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.order.catalogue.model.Product;

@Service
public class CatalogueRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> listProducts() {
		final Session session = sessionFactory.getCurrentSession();
		final CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Product> query = builder.createQuery(Product.class);
	    query.select( query.from(Product.class));
	    return session.createQuery(query).getResultList();
	}

	public Product getProduct(final Integer productId) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Product.class, productId);
		} finally {
			session.close();
		}
	}
	
	public Boolean addProduct(final Product product) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return Boolean.FALSE;
		} finally {
			session.close();
		}
		return Boolean.TRUE;
	}

	public Boolean updateProduct(final Product product) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return Boolean.FALSE;
		} finally {
			session.close();
		}
		return Boolean.TRUE;
	}

	public Boolean deleteProduct(final Integer productId) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(session.load(Product.class, productId));
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return Boolean.FALSE;
		} finally {
			session.close();
		}
		return Boolean.TRUE;
	}
}
