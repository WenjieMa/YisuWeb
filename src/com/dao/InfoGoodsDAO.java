package com.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.InfoGoods;

/**
 	* A data access object (DAO) providing persistence and search support for InfoGoods entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.InfoGoods
  * @author MyEclipse Persistence Tools 
 */
public class InfoGoodsDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(InfoGoodsDAO.class);
		//property constants
	public static final String GNAME = "gname";
	public static final String GPRICE = "gprice";
	public static final String GTYPE = "gtype";
	public static final String GKUCUN = "gkucun";
	public static final String GKONGXIANKUCUN = "gkongxiankucun";
	public static final String GXIHUANSHU = "gxihuanshu";
	public static final String GPIC = "gpic";
	public static final String GBIG_PIC = "gbigPic";
	public static final String GJIESHAO = "gjieshao";
	public static final String GJIANJIE = "gjianjie";



	protected void initDao() {
		//do nothing
	}
    
    public void save(InfoGoods transientInstance) {
        log.debug("saving InfoGoods instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(InfoGoods persistentInstance) {
        log.debug("deleting InfoGoods instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public InfoGoods findById( java.lang.Integer id) {
        log.debug("getting InfoGoods instance with id: " + id);
        try {
            InfoGoods instance = (InfoGoods) getHibernateTemplate()
                    .get("com.pojo.InfoGoods", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(InfoGoods instance) {
        log.debug("finding InfoGoods instance by example");
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
      log.debug("finding InfoGoods instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from InfoGoods as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByGname(Object gname
	) {
		return findByProperty(GNAME, gname
		);
	}
	
	public List findByGprice(Object gprice
	) {
		return findByProperty(GPRICE, gprice
		);
	}
	
	public List findByGtype(Object gtype
	) {
		return findByProperty(GTYPE, gtype
		);
	}
	
	public List findByGkucun(Object gkucun
	) {
		return findByProperty(GKUCUN, gkucun
		);
	}
	
	public List findByGkongxiankucun(Object gkongxiankucun
	) {
		return findByProperty(GKONGXIANKUCUN, gkongxiankucun
		);
	}
	
	public List findByGxihuanshu(Object gxihuanshu
	) {
		return findByProperty(GXIHUANSHU, gxihuanshu
		);
	}
	
	public List findByGpic(Object gpic
	) {
		return findByProperty(GPIC, gpic
		);
	}
	
	public List findByGbigPic(Object gbigPic
	) {
		return findByProperty(GBIG_PIC, gbigPic
		);
	}
	
	public List findByGjieshao(Object gjieshao
	) {
		return findByProperty(GJIESHAO, gjieshao
		);
	}
	
	public List findByGjianjie(Object gjianjie
	) {
		return findByProperty(GJIANJIE, gjianjie
		);
	}
	

	public List findAll() {
		log.debug("finding all InfoGoods instances");
		try {
			String queryString = "from InfoGoods";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public InfoGoods merge(InfoGoods detachedInstance) {
        log.debug("merging InfoGoods instance");
        try {
            InfoGoods result = (InfoGoods) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(InfoGoods instance) {
        log.debug("attaching dirty InfoGoods instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(InfoGoods instance) {
        log.debug("attaching clean InfoGoods instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static InfoGoodsDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (InfoGoodsDAO) ctx.getBean("InfoGoodsDAO");
	}
}