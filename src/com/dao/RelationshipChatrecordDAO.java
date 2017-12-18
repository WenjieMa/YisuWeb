package com.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.RelationshipChatrecord;

/**
 	* A data access object (DAO) providing persistence and search support for RelationshipChatrecord entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.RelationshipChatrecord
  * @author MyEclipse Persistence Tools 
 */
public class RelationshipChatrecordDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RelationshipChatrecordDAO.class);
		//property constants
	public static final String RECORD_TEXT = "recordText";
	public static final String RECORD_IS_PIC = "recordIsPic";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RelationshipChatrecord transientInstance) {
        log.debug("saving RelationshipChatrecord instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RelationshipChatrecord persistentInstance) {
        log.debug("deleting RelationshipChatrecord instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RelationshipChatrecord findById( java.lang.Integer id) {
        log.debug("getting RelationshipChatrecord instance with id: " + id);
        try {
            RelationshipChatrecord instance = (RelationshipChatrecord) getHibernateTemplate()
                    .get("com.pojo.RelationshipChatrecord", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RelationshipChatrecord instance) {
        log.debug("finding RelationshipChatrecord instance by example");
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
      log.debug("finding RelationshipChatrecord instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RelationshipChatrecord as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRecordText(Object recordText
	) {
		return findByProperty(RECORD_TEXT, recordText
		);
	}
	
	public List findByRecordIsPic(Object recordIsPic
	) {
		return findByProperty(RECORD_IS_PIC, recordIsPic
		);
	}
	

	public List findAll() {
		log.debug("finding all RelationshipChatrecord instances");
		try {
			String queryString = "from RelationshipChatrecord";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RelationshipChatrecord merge(RelationshipChatrecord detachedInstance) {
        log.debug("merging RelationshipChatrecord instance");
        try {
            RelationshipChatrecord result = (RelationshipChatrecord) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RelationshipChatrecord instance) {
        log.debug("attaching dirty RelationshipChatrecord instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RelationshipChatrecord instance) {
        log.debug("attaching clean RelationshipChatrecord instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RelationshipChatrecordDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RelationshipChatrecordDAO) ctx.getBean("RelationshipChatrecordDAO");
	}
}