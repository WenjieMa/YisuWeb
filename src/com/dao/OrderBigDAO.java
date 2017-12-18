package com.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.OrderBig;

/**
 	* A data access object (DAO) providing persistence and search support for OrderBig entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.OrderBig
  * @author MyEclipse Persistence Tools 
 */
public class OrderBigDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(OrderBigDAO.class);
		//property constants
	public static final String BSHOUHUODIZHI = "bshouhuodizhi";
	public static final String FUKUANJINE = "fukuanjine";
	public static final String BSHIFOUFUKUAN = "bshifoufukuan";
	public static final String BSHIFOUSHOUHUO = "bshifoushouhuo";
	public static final String BSHIFOUPINGJIA = "bshifoupingjia";
	public static final String BKUAIDI_ID = "bkuaidiId";
	public static final String BSHIFOUFAHUO = "bshifoufahuo";



	protected void initDao() {
		//do nothing
	}
    
    public void save(OrderBig transientInstance) {
        log.debug("saving OrderBig instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OrderBig persistentInstance) {
        log.debug("deleting OrderBig instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OrderBig findById( java.lang.Integer id) {
        log.debug("getting OrderBig instance with id: " + id);
        try {
            OrderBig instance = (OrderBig) getHibernateTemplate()
                    .get("com.pojo.OrderBig", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OrderBig instance) {
        log.debug("finding OrderBig instance by example");
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
      log.debug("finding OrderBig instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OrderBig as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByBshouhuodizhi(Object bshouhuodizhi
	) {
		return findByProperty(BSHOUHUODIZHI, bshouhuodizhi
		);
	}
	
	public List findByFukuanjine(Object fukuanjine
	) {
		return findByProperty(FUKUANJINE, fukuanjine
		);
	}
	
	public List findByBshifoufukuan(Object bshifoufukuan
	) {
		return findByProperty(BSHIFOUFUKUAN, bshifoufukuan
		);
	}
	
	public List findByBshifoushouhuo(Object bshifoushouhuo
	) {
		return findByProperty(BSHIFOUSHOUHUO, bshifoushouhuo
		);
	}
	
	public List findByBshifoupingjia(Object bshifoupingjia
	) {
		return findByProperty(BSHIFOUPINGJIA, bshifoupingjia
		);
	}
	
	public List findByBkuaidiId(Object bkuaidiId
	) {
		return findByProperty(BKUAIDI_ID, bkuaidiId
		);
	}
	
	public List findByBshifoufahuo(Object bshifoufahuo
	) {
		return findByProperty(BSHIFOUFAHUO, bshifoufahuo
		);
	}
	

	public List findAll() {
		log.debug("finding all OrderBig instances");
		try {
			String queryString = "from OrderBig";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OrderBig merge(OrderBig detachedInstance) {
        log.debug("merging OrderBig instance");
        try {
            OrderBig result = (OrderBig) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OrderBig instance) {
        log.debug("attaching dirty OrderBig instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OrderBig instance) {
        log.debug("attaching clean OrderBig instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static OrderBigDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (OrderBigDAO) ctx.getBean("OrderBigDAO");
	}
}