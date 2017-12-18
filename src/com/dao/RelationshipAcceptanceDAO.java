package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.RelationshipAcceptance;

/**
 * A data access object (DAO) providing persistence and search support for
 * RelationshipAcceptance entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.RelationshipAcceptance
 * @author MyEclipse Persistence Tools
 */
public class RelationshipAcceptanceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(RelationshipAcceptanceDAO.class);
	// property constants
	public static final String AC_ACCEPT = "acAccept";
	public static final String AC_REFUSE = "acRefuse";

	protected void initDao() {
		// do nothing
	}

	public void save(RelationshipAcceptance transientInstance) {
		log.debug("saving RelationshipAcceptance instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RelationshipAcceptance persistentInstance) {
		log.debug("deleting RelationshipAcceptance instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelationshipAcceptance findById(java.lang.Integer id) {
		log.debug("getting RelationshipAcceptance instance with id: " + id);
		try {
			RelationshipAcceptance instance = (RelationshipAcceptance) getHibernateTemplate()
					.get("com.pojo.RelationshipAcceptance", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RelationshipAcceptance instance) {
		log.debug("finding RelationshipAcceptance instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RelationshipAcceptance instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RelationshipAcceptance as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAcAccept(Object acAccept) {
		return findByProperty(AC_ACCEPT, acAccept);
	}

	public List findByAcRefuse(Object acRefuse) {
		return findByProperty(AC_REFUSE, acRefuse);
	}

	public List findAll() {
		log.debug("finding all RelationshipAcceptance instances");
		try {
			String queryString = "from RelationshipAcceptance";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RelationshipAcceptance merge(RelationshipAcceptance detachedInstance) {
		log.debug("merging RelationshipAcceptance instance");
		try {
			RelationshipAcceptance result = (RelationshipAcceptance) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RelationshipAcceptance instance) {
		log.debug("attaching dirty RelationshipAcceptance instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelationshipAcceptance instance) {
		log.debug("attaching clean RelationshipAcceptance instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RelationshipAcceptanceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RelationshipAcceptanceDAO) ctx.getBean("RelationshipAcceptanceDAO");
	}
}