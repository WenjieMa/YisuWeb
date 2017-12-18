package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.OrderSmall;

/**
 	* A data access object (DAO) providing persistence and search support for OrderSmall entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.OrderSmall
  * @author MyEclipse Persistence Tools 
 */
public class OrderSmallDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(OrderSmallDAO.class);
		//property constants
	public static final String SHULIANG = "shuliang";
	public static final String PINGJIA = "pingjia";
	public static final String HAOZHONGCHA = "haozhongcha";
	public static final String XINGJI = "xingji";
	public static final String SHIFOUPINGJIA = "shifoupingjia";



	protected void initDao() {
		//do nothing
	}
    
    public void save(OrderSmall transientInstance) {
        log.debug("saving OrderSmall instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OrderSmall persistentInstance) {
        log.debug("deleting OrderSmall instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OrderSmall findById( com.pojo.OrderSmallId id) {
        log.debug("getting OrderSmall instance with id: " + id);
        try {
            OrderSmall instance = (OrderSmall) getHibernateTemplate()
                    .get("com.pojo.OrderSmall", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OrderSmall instance) {
        log.debug("finding OrderSmall instance by example");
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
      log.debug("finding OrderSmall instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OrderSmall as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByShuliang(Object shuliang
	) {
		return findByProperty(SHULIANG, shuliang
		);
	}
	
	public List findByPingjia(Object pingjia
	) {
		return findByProperty(PINGJIA, pingjia
		);
	}
	
	public List findByHaozhongcha(Object haozhongcha
	) {
		return findByProperty(HAOZHONGCHA, haozhongcha
		);
	}
	
	public List findByXingji(Object xingji
	) {
		return findByProperty(XINGJI, xingji
		);
	}
	
	public List findByShifoupingjia(Object shifoupingjia
	) {
		return findByProperty(SHIFOUPINGJIA, shifoupingjia
		);
	}
	

	public List findAll() {
		log.debug("finding all OrderSmall instances");
		try {
			String queryString = "from OrderSmall";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OrderSmall merge(OrderSmall detachedInstance) {
        log.debug("merging OrderSmall instance");
        try {
            OrderSmall result = (OrderSmall) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OrderSmall instance) {
        log.debug("attaching dirty OrderSmall instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OrderSmall instance) {
        log.debug("attaching clean OrderSmall instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static OrderSmallDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (OrderSmallDAO) ctx.getBean("OrderSmallDAO");
	}
}