package com.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.AddressProvince;

/**
 	* A data access object (DAO) providing persistence and search support for AddressProvince entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.AddressProvince
  * @author MyEclipse Persistence Tools 
 */
public class AddressProvinceDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(AddressProvinceDAO.class);
		//property constants
	public static final String PRO_NAME = "proName";



	protected void initDao() {
		//do nothing
	}
    
    public void save(AddressProvince transientInstance) {
        log.debug("saving AddressProvince instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AddressProvince persistentInstance) {
        log.debug("deleting AddressProvince instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AddressProvince findById( java.lang.Integer id) {
        log.debug("getting AddressProvince instance with id: " + id);
        try {
            AddressProvince instance = (AddressProvince) getHibernateTemplate()
                    .get("com.pojo.AddressProvince", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(AddressProvince instance) {
        log.debug("finding AddressProvince instance by example");
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
      log.debug("finding AddressProvince instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AddressProvince as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByProName(Object proName
	) {
		return findByProperty(PRO_NAME, proName
		);
	}
	

	public List findAll() {
		log.debug("finding all AddressProvince instances");
		try {
			String queryString = "from AddressProvince";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AddressProvince merge(AddressProvince detachedInstance) {
        log.debug("merging AddressProvince instance");
        try {
            AddressProvince result = (AddressProvince) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AddressProvince instance) {
        log.debug("attaching dirty AddressProvince instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AddressProvince instance) {
        log.debug("attaching clean AddressProvince instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AddressProvinceDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AddressProvinceDAO) ctx.getBean("AddressProvinceDAO");
	}
}