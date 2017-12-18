package com.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.AddressCity;

/**
 * A data access object (DAO) providing persistence and search support for
 * AddressCity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.AddressCity
 * @author MyEclipse Persistence Tools
 */
public class AddressCityDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AddressCityDAO.class);
	// property constants
	public static final String CNAME = "cname";

	protected void initDao() {
		// do nothing
	}

	public void save(AddressCity transientInstance) {
		log.debug("saving AddressCity instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AddressCity persistentInstance) {
		log.debug("deleting AddressCity instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AddressCity findById(java.lang.Integer id) {
		log.debug("getting AddressCity instance with id: " + id);
		try {
			AddressCity instance = (AddressCity) getHibernateTemplate().get(
					"com.pojo.AddressCity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AddressCity instance) {
		log.debug("finding AddressCity instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AddressCity instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AddressCity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findAll() {
		log.debug("finding all AddressCity instances");
		try {
			String queryString = "from AddressCity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AddressCity merge(AddressCity detachedInstance) {
		log.debug("merging AddressCity instance");
		try {
			AddressCity result = (AddressCity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AddressCity instance) {
		log.debug("attaching dirty AddressCity instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AddressCity instance) {
		log.debug("attaching clean AddressCity instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AddressCityDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AddressCityDAO) ctx.getBean("AddressCityDAO");
	}
}