package com.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.InfoHighOperator;
import com.pojo.InfoHighOperatorId;

/**
 	* A data access object (DAO) providing persistence and search support for InfoHighOperator entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.InfoHighOperator
  * @author MyEclipse Persistence Tools 
 */
public class InfoHighOperatorDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(InfoHighOperatorDAO.class);
		//property constants
	public static final String HNAME = "hname";



	protected void initDao() {
		//do nothing
	}
    
    public void save(InfoHighOperator transientInstance) {
        log.debug("saving InfoHighOperator instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(InfoHighOperator persistentInstance) {
        log.debug("deleting InfoHighOperator instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public InfoHighOperator findById( com.pojo.InfoHighOperatorId id) {
        log.debug("getting InfoHighOperator instance with id: " + id);
        try {
            InfoHighOperator instance = (InfoHighOperator) getHibernateTemplate()
                    .get("com.pojo.InfoHighOperator", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(InfoHighOperator instance) {
        log.debug("finding InfoHighOperator instance by example");
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
      log.debug("finding InfoHighOperator instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from InfoHighOperator as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByHname(Object hname
	) {
		return findByProperty(HNAME, hname
		);
	}
	

	public List findAll() {
		log.debug("finding all InfoHighOperator instances");
		try {
			String queryString = "from InfoHighOperator";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public InfoHighOperator merge(InfoHighOperator detachedInstance) {
        log.debug("merging InfoHighOperator instance");
        try {
            InfoHighOperator result = (InfoHighOperator) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(InfoHighOperator instance) {
        log.debug("attaching dirty InfoHighOperator instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(InfoHighOperator instance) {
        log.debug("attaching clean InfoHighOperator instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static InfoHighOperatorDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (InfoHighOperatorDAO) ctx.getBean("InfoHighOperatorDAO");
	}
}