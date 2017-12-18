package com.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.InfoOperator;
import com.pojo.InfoOperatorId;

/**
 	* A data access object (DAO) providing persistence and search support for InfoOperator entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.InfoOperator
  * @author MyEclipse Persistence Tools 
 */
public class InfoOperatorDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(InfoOperatorDAO.class);
		//property constants
	public static final String OXINGMING = "oxingming";
	public static final String OPHONE = "ophone";
	public static final String OSHENFENZHENG = "oshenfenzheng";
	public static final String OGONGZI = "ogongzi";
	public static final String OLIZHI = "olizhi";



	protected void initDao() {
		//do nothing
	}
    
    public void save(InfoOperator transientInstance) {
        log.debug("saving InfoOperator instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(InfoOperator persistentInstance) {
        log.debug("deleting InfoOperator instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public InfoOperator findById( com.pojo.InfoOperatorId id) {
        log.debug("getting InfoOperator instance with id: " + id);
        try {
            InfoOperator instance = (InfoOperator) getHibernateTemplate()
                    .get("com.pojo.InfoOperator", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(InfoOperator instance) {
        log.debug("finding InfoOperator instance by example");
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
      log.debug("finding InfoOperator instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from InfoOperator as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByOxingming(Object oxingming
	) {
		return findByProperty(OXINGMING, oxingming
		);
	}
	
	public List findByOphone(Object ophone
	) {
		return findByProperty(OPHONE, ophone
		);
	}
	
	public List findByOshenfenzheng(Object oshenfenzheng
	) {
		return findByProperty(OSHENFENZHENG, oshenfenzheng
		);
	}
	
	public List findByOgongzi(Object ogongzi
	) {
		return findByProperty(OGONGZI, ogongzi
		);
	}
	
	public List findByOlizhi(Object olizhi
	) {
		return findByProperty(OLIZHI, olizhi
		);
	}
	

	public List findAll() {
		log.debug("finding all InfoOperator instances");
		try {
			String queryString = "from InfoOperator";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public InfoOperator merge(InfoOperator detachedInstance) {
        log.debug("merging InfoOperator instance");
        try {
            InfoOperator result = (InfoOperator) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(InfoOperator instance) {
        log.debug("attaching dirty InfoOperator instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(InfoOperator instance) {
        log.debug("attaching clean InfoOperator instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static InfoOperatorDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (InfoOperatorDAO) ctx.getBean("InfoOperatorDAO");
	}
}