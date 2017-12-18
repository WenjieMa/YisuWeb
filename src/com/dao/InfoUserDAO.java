package com.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.InfoUser;

/**
 	* A data access object (DAO) providing persistence and search support for InfoUser entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.InfoUser
  * @author MyEclipse Persistence Tools 
 */
public class InfoUserDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(InfoUserDAO.class);
		//property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String UZHIFUMIMA = "uzhifumima";
	public static final String UNICHENG = "unicheng";
	public static final String UXINGMING = "uxingming";
	public static final String UXINGBIE = "uxingbie";
	public static final String UPHONE = "uphone";
	public static final String UQQ = "uqq";
	public static final String UXINGZUO = "uxingzuo";
	public static final String UEMAIL = "uemail";
	public static final String UTOUXIANG = "utouxiang";
	public static final String UMONEY = "umoney";
	public static final String UCHANGYONGDIZHI1 = "uchangyongdizhi1";
	public static final String UCHANGYONGDIZHI2 = "uchangyongdizhi2";
	public static final String UCHANGYONGDIZHI3 = "uchangyongdizhi3";
	public static final String UCHANGYONGDIZHI4 = "uchangyongdizhi4";
	public static final String UCHANGYONGDIZHI5 = "uchangyongdizhi5";
	public static final String UMIBAOWENTI1 = "umibaowenti1";
	public static final String UMIBAOWENTI2 = "umibaowenti2";
	public static final String UDAAN1 = "udaan1";
	public static final String UDAAN2 = "udaan2";
	public static final String UDIANG_ID = "udiangId";



	protected void initDao() {
		//do nothing
	}
    
    public void save(InfoUser transientInstance) {
        log.debug("saving InfoUser instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(InfoUser persistentInstance) {
        log.debug("deleting InfoUser instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public InfoUser findById( java.lang.Integer id) {
        log.debug("getting InfoUser instance with id: " + id);
        try {
            InfoUser instance = (InfoUser) getHibernateTemplate()
                    .get("com.pojo.InfoUser", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(InfoUser instance) {
        log.debug("finding InfoUser instance by example");
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
      log.debug("finding InfoUser instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from InfoUser as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByUzhifumima(Object uzhifumima
	) {
		return findByProperty(UZHIFUMIMA, uzhifumima
		);
	}
	
	public List findByUnicheng(Object unicheng
	) {
		return findByProperty(UNICHENG, unicheng
		);
	}
	
	public List findByUxingming(Object uxingming
	) {
		return findByProperty(UXINGMING, uxingming
		);
	}
	
	public List findByUxingbie(Object uxingbie
	) {
		return findByProperty(UXINGBIE, uxingbie
		);
	}
	
	public List findByUphone(Object uphone
	) {
		return findByProperty(UPHONE, uphone
		);
	}
	
	public List findByUqq(Object uqq
	) {
		return findByProperty(UQQ, uqq
		);
	}
	
	public List findByUxingzuo(Object uxingzuo
	) {
		return findByProperty(UXINGZUO, uxingzuo
		);
	}
	
	public List findByUemail(Object uemail
	) {
		return findByProperty(UEMAIL, uemail
		);
	}
	
	public List findByUtouxiang(Object utouxiang
	) {
		return findByProperty(UTOUXIANG, utouxiang
		);
	}
	
	public List findByUmoney(Object umoney
	) {
		return findByProperty(UMONEY, umoney
		);
	}
	
	public List findByUchangyongdizhi1(Object uchangyongdizhi1
	) {
		return findByProperty(UCHANGYONGDIZHI1, uchangyongdizhi1
		);
	}
	
	public List findByUchangyongdizhi2(Object uchangyongdizhi2
	) {
		return findByProperty(UCHANGYONGDIZHI2, uchangyongdizhi2
		);
	}
	
	public List findByUchangyongdizhi3(Object uchangyongdizhi3
	) {
		return findByProperty(UCHANGYONGDIZHI3, uchangyongdizhi3
		);
	}
	
	public List findByUchangyongdizhi4(Object uchangyongdizhi4
	) {
		return findByProperty(UCHANGYONGDIZHI4, uchangyongdizhi4
		);
	}
	
	public List findByUchangyongdizhi5(Object uchangyongdizhi5
	) {
		return findByProperty(UCHANGYONGDIZHI5, uchangyongdizhi5
		);
	}
	
	public List findByUmibaowenti1(Object umibaowenti1
	) {
		return findByProperty(UMIBAOWENTI1, umibaowenti1
		);
	}
	
	public List findByUmibaowenti2(Object umibaowenti2
	) {
		return findByProperty(UMIBAOWENTI2, umibaowenti2
		);
	}
	
	public List findByUdaan1(Object udaan1
	) {
		return findByProperty(UDAAN1, udaan1
		);
	}
	
	public List findByUdaan2(Object udaan2
	) {
		return findByProperty(UDAAN2, udaan2
		);
	}
	
	public List findByUdiangId(Object udiangId
	) {
		return findByProperty(UDIANG_ID, udiangId
		);
	}
	

	public List findAll() {
		log.debug("finding all InfoUser instances");
		try {
			String queryString = "from InfoUser";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public InfoUser merge(InfoUser detachedInstance) {
        log.debug("merging InfoUser instance");
        try {
            InfoUser result = (InfoUser) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(InfoUser instance) {
        log.debug("attaching dirty InfoUser instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(InfoUser instance) {
        log.debug("attaching clean InfoUser instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static InfoUserDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (InfoUserDAO) ctx.getBean("InfoUserDAO");
	}
}