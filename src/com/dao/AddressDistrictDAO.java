package com.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.AddressDistrict;

/**
 	* A data access object (DAO) providing persistence and search support for AddressDistrict entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.AddressDistrict
  * @author MyEclipse Persistence Tools 
 */
public class AddressDistrictDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(AddressDistrictDAO.class);
		//property constants
	public static final String DIS_NAME = "disName";



	protected void initDao() {
		//do nothing
	}
    
    public void save(AddressDistrict transientInstance) {
        log.debug("saving AddressDistrict instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AddressDistrict persistentInstance) {
        log.debug("deleting AddressDistrict instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AddressDistrict findById( java.lang.Integer id) {
        log.debug("getting AddressDistrict instance with id: " + id);
        try {
            AddressDistrict instance = (AddressDistrict) getHibernateTemplate()
                    .get("com.pojo.AddressDistrict", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(AddressDistrict instance) {
        log.debug("finding AddressDistrict instance by example");
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
      log.debug("finding AddressDistrict instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AddressDistrict as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDisName(Object disName
	) {
		return findByProperty(DIS_NAME, disName
		);
	}
	

	public List findAll() {
		log.debug("finding all AddressDistrict instances");
		try {
			String queryString = "from AddressDistrict";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AddressDistrict merge(AddressDistrict detachedInstance) {
        log.debug("merging AddressDistrict instance");
        try {
            AddressDistrict result = (AddressDistrict) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AddressDistrict instance) {
        log.debug("attaching dirty AddressDistrict instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AddressDistrict instance) {
        log.debug("attaching clean AddressDistrict instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AddressDistrictDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AddressDistrictDAO) ctx.getBean("AddressDistrictDAO");
	}
}