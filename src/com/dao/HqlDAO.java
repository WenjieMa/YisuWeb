package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HqlDAO extends HibernateDaoSupport {
	public List findByHql(final String hql, final Object... objects) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(hql);
				for (int i = 0; i < objects.length; i++) {
					query.setParameter(i, objects[i]);
				}
				return query.list();
			}

		});
		return list;
	}
	// 分页查询1
	// Template n. 模版，样板
	// merge v. 合并，融入
	// persist v. 坚持，将。。。持久化
	public List pageQuery(final String hql, final Integer page,
			final Integer size, final Object... objects) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (objects != null) {
					for (int i = 0; i < objects.length; i++) {
						query.setParameter(i, objects[i]);
					}
				}
				if (page != null && size != null) {
					query.setFirstResult((page - 1) * size).setMaxResults(size);
				}
				session.close();
				return query.list();
			}
		});
	}

	public int update(String hql, Object... objects) {
		return getHibernateTemplate().bulkUpdate(hql, objects);
	}

	public void bulkUpdate(String hql, Object... objects) {
		getHibernateTemplate().bulkUpdate(hql, objects);
	}

	public float unique(String hql, Object... objects) {
		List list = findByHql(hql, objects);
		if (list.size() != 0) {
			Object object = list.get(0);
			if (object != null) {
				return Float.parseFloat(object.toString());
			}
		}
		return 0;
	}

	// 获取session1
	public Session getSessionFromSpring() {
		return super.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session;
			}
		});
	}
	// 获取session2
	public Session getSessionFromSpring2() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
	
	// 调用function
	public Object queryFunction(final String fn, final Object... p) {
		return super.getHibernateTemplate().execute(new HibernateCallback() {
			// {?=call getchild(?)}
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection connection = session.connection();
				String sql = fn;
				CallableStatement cs = connection.prepareCall(sql);
				cs.registerOutParameter(1, Types.VARCHAR);
				if (p != null)
					for (int i = 0; i < p.length; i++) {
						cs.setObject(i + 2, p[i]);
					}
				cs.execute();
				String msg = cs.getString(1);
				return msg;
			}
		});
	}

}
