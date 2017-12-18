package com.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.RelationshipFriends;

/**
 	* A data access object (DAO) providing persistence and search support for RelationshipFriends entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.RelationshipFriends
  * @author MyEclipse Persistence Tools 
 */
public class RelationshipFriendsDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RelationshipFriendsDAO.class);
		//property constants



	protected void initDao() {
		//do nothing
	}
    
    public void save(RelationshipFriends transientInstance) {
        log.debug("saving RelationshipFriends instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RelationshipFriends persistentInstance) {
        log.debug("deleting RelationshipFriends instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RelationshipFriends findById( java.lang.Integer id) {
        log.debug("getting RelationshipFriends instance with id: " + id);
        try {
            RelationshipFriends instance = (RelationshipFriends) getHibernateTemplate()
                    .get("com.pojo.RelationshipFriends", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RelationshipFriends instance) {
        log.debug("finding RelationshipFriends instance by example");
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
      log.debug("finding RelationshipFriends instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RelationshipFriends as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all RelationshipFriends instances");
		try {
			String queryString = "from RelationshipFriends";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RelationshipFriends merge(RelationshipFriends detachedInstance) {
        log.debug("merging RelationshipFriends instance");
        try {
            RelationshipFriends result = (RelationshipFriends) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RelationshipFriends instance) {
        log.debug("attaching dirty RelationshipFriends instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RelationshipFriends instance) {
        log.debug("attaching clean RelationshipFriends instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RelationshipFriendsDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RelationshipFriendsDAO) ctx.getBean("RelationshipFriendsDAO");
	}
}