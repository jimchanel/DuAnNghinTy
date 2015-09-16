package com.huynvb.pr0ject.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huynvb.pr0ject.common.Constant.FilterKind;
import com.huynvb.pr0ject.model.User;

@Service
public class UserService extends BaseService {
	private String keyFilter;
	public List<User> getPaging(int page, int limit) {
		try {
			int start = page * limit - limit;
			Map<String, Object> prmList = new HashMap<String, Object>();
			StringBuffer sqlBuffer = new StringBuffer("SELECT u FROM User u ");
			sqlBuffer.append(getBaseSQL(prmList));
			appendOrderField(sqlBuffer, "u");
			TypedQuery<User> query = em.createQuery(sqlBuffer.toString(),
					User.class);
			if (prmList.size() > 0)
				for (Entry<String, Object> item : prmList.entrySet())
					query.setParameter(item.getKey(), item.getValue());
			List<User> list = query.setFirstResult(start).setMaxResults(limit)
					.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int countTotal() {
		try {
			Map<String, Object> prmList = new HashMap<String, Object>();
			StringBuffer sqlBuffer = new StringBuffer("SELECT COUNT(u) FROM User u ");
			sqlBuffer.append(getBaseSQL(prmList));
			Query query = em.createQuery(sqlBuffer.toString());
			if (prmList.size() > 0)
				for (Entry<String, Object> item : prmList.entrySet())
					query.setParameter(item.getKey(), item.getValue());
			List list = query.getResultList();
			return ((Long) list.get(0)).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	private StringBuffer getBaseSQL(Map<String, Object> prmList)
			throws SQLException {
		StringBuffer sqlBuffer = new StringBuffer();
		String whereString = getWhereFilter(prmList);
		if (whereString.length() > 0) {
			sqlBuffer.append(" WHERE 1 = 1 ");
			sqlBuffer.append(whereString);
		}
		return sqlBuffer;
	}
	private String getWhereFilter(Map<String, Object> prmList) {
		StringBuffer filterBuffer = new StringBuffer();

		if (this.keyFilter != null) {
			appendAnd(filterBuffer);
			filterBuffer.append(" u.username LIKE :keyFilter OR u.familyName LIKE :keyFilter OR u.email LIKE :keyFilter ");
			prmList.put("keyFilter", this.keyFilter);
		}
		return filterBuffer.toString();
	}
	public void clearFilter() {
		this.keyFilter = null;
	}
	public String getKeyFilter() {
		return keyFilter;
	}
	public void setKeyFilter(String keyFilter) {
		this.keyFilter = keyFilter;
	}
	public void setKeyFilter(String keyFilter, FilterKind kind) {
		this.keyFilter = this.buildFilterString2(keyFilter, kind.getValue());
	}
	
	@Transactional(rollbackFor = { Exception.class })
	public boolean add(User cate) throws Exception{
		try {
			em.persist(cate);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public boolean update(User cate) throws Exception{
		try {
			em.merge(cate);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	@Transactional(rollbackFor = { Exception.class })
	public boolean delete(String username) throws Exception{
		try {
			User cate = findById(username);
			em.remove(cate);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public User findById(String username) {
		return em.find(User.class, username);
	}
	public boolean checkUSER_EXIST(String username, boolean isEdit, long id) {
		try {
			StringBuffer sqlBuffer = new StringBuffer(
					"SELECT COUNT(a) FROM User a WHERE a.username = '"
							+ username + "' "
							+ (isEdit ? ("AND a.id != " + id) : ""));
			Query query = em.createQuery(sqlBuffer.toString());
			return ((Long) query.getSingleResult()) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public String role(String username){
		try {
			String role = "";
			StringBuffer sqlBuffer = new StringBuffer(
					"SELECT authority FROM tbl_authorities WHERE username = '"
							+ username + "' ");
			Query query = em.createNativeQuery(sqlBuffer.toString());
			List list = query.getResultList();
			for (int i = 0; i < list.size(); i++) {
				role += list.get(i) + ";";
			}
			return role;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Transactional(rollbackFor = { Exception.class })
	public void deleteRole(String username){
		try {
			StringBuffer sqlBuffer = new StringBuffer(
					"DELETE FROM tbl_authorities WHERE username = '"
							+ username + "' ");
			em.createNativeQuery(sqlBuffer.toString()).executeUpdate();
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional(rollbackFor = { Exception.class })
	public void addRole(String username, String role, String author, String description){
		try {
			StringBuffer sqlBuffer = new StringBuffer(
					" INSERT INTO tbl_authorities(username, authority, update_username, description) VALUE (?, ?, ?, ?) ");
			em.createNativeQuery(sqlBuffer.toString())
			.setParameter(1, username)
			.setParameter(2, role)
			.setParameter(3, author)
			.setParameter(4, description)
			.executeUpdate();
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
