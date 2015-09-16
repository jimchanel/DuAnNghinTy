package com.huynvb.pr0ject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.mysql.jdbc.StringUtils;
import com.huynvb.pr0ject.common.OrderField;
/**
 * @author HunyNV
 *
 */
public class BaseService {
	private String sql;
	protected static final String FILE_TYPE_NOTIFY = "Thông báo";
	protected static final String FILE_TYPE_CONTRACT = "Hợp đồng";
	protected static final String FILE_TYPE_CONTRACT_KIND = "Mẫu hợp đồng";
	protected static final String FILE_TYPE_DOCUMENT = "Tài liệu";
	protected static final String STATUS_DANGCHINHSUA = "Đang chỉnh sửa";
	protected static final String STATUS_TRAVE = "Trả về";
	protected static final String STATUS_CHOKY = "Chờ ký";
	protected static final String STATUS_DAKY = "Đã ký";
	protected static final String STATUS_DADONGDAU = "Đã đóng dấu";
	protected static final String NOTARY_OFFICE_NAME = "notary_office_name";
	public static final Byte SYNC_OPTION_NOT_CONTENT = 1;
	public static final Byte SYNC_OPTION_NOT_RELATEOBJ = 2;
	protected static final HashMap<String, Byte> contractStatus;
	static {
		contractStatus = new HashMap<String, Byte>();
		contractStatus.put(STATUS_DANGCHINHSUA, (byte)0);
		contractStatus.put(STATUS_TRAVE, (byte)1);
		contractStatus.put(STATUS_CHOKY, (byte)2);
		contractStatus.put(STATUS_DAKY, (byte)3);
		contractStatus.put(STATUS_DADONGDAU, (byte)4);
	};
	protected static final HashMap<String, Integer> fileTypes;
	static {
		fileTypes = new HashMap<String, Integer>();
		fileTypes.put(FILE_TYPE_CONTRACT, 1);
		fileTypes.put(FILE_TYPE_NOTIFY, 2);
		fileTypes.put(FILE_TYPE_CONTRACT_KIND, 3);
		fileTypes.put(FILE_TYPE_DOCUMENT, 4);
    };
    @PersistenceContext(name = "entityManagerFactory", unitName="persistenceUnit")
	protected EntityManager em;
	public final HashMap<String, String> userRoles;
	{
		userRoles = new HashMap<String, String>();
		userRoles.put("1", "1");
		userRoles.put("2", "2");
		userRoles.put("3", "3");
		userRoles.put("4", "4");
		userRoles.put("5", "5");
    };
	/** Create entitymanager*/
	protected void getEntityManager() {
		em = Persistence.createEntityManagerFactory("persistenceUnit")
				.createEntityManager();
	}
	
	/** Order field list */
    private List<OrderField> orderFieldList;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
	
	/**
	 * @return the orderFieldList
	 */
	public List<OrderField> getOrderFieldList() {
		return orderFieldList;
	}

	/**
	 * @param orderFieldList the orderFieldList to set
	 */
	public void setOrderFieldList(List<OrderField> orderFieldList) {
		this.orderFieldList = orderFieldList;
	}

	/**
     * @param strBuffer
     *            
     */
    protected void appendAnd(StringBuffer strBuffer) {    
    	strBuffer.append(" AND ");
    }
    
    /**
     * @param strBuffer
     *            
     */
    protected void appendOr(StringBuffer strBuffer) {
    	strBuffer.append(" OR ");
    }
    
    /**
     * <P>
     * Build filter string
     * </P>
     * 
     * @param filterSource
     *            Filter source
     * @param kind
     *            Kind of filter
     * @return Filter string
     */
    protected String buildFilterString(String filterSource, int kind) {

        if (filterSource == null) {
            return null;
        }

        switch (kind) {
        case 1:
            return "'%" + filterSource + "'";
        case 2:
        	return "'%" + filterSource + "%'";
        case 3:
        	return "'" + filterSource + "%'";
        case 4:
        	return "'" + filterSource + "'";
        default:
            return filterSource;
        }
    }
    
    protected String buildFilterString2(String filterSource, int kind) {

        if (filterSource == null) {
            return null;
        }

        switch (kind) {
        case 1:
            return "%" + filterSource;
        case 2:
        	return "%" + filterSource + "%";
        case 3:
        	return filterSource + "%";
        case 4:
        	return filterSource;
        default:
            return filterSource;
        }
    }
    
    /**
     * Append order field
     * @param strBuffer SQL
     */
    protected void appendOrderField(StringBuffer strBuffer) {
    	if (orderFieldList == null || orderFieldList.isEmpty()) {
    		return;
    	}
    	strBuffer.append(" ORDER BY ");
    	for (int i = 0; i < orderFieldList.size(); i++) {
    		OrderField orderField = orderFieldList.get(i);
    		strBuffer.append(orderField.getFieldName() + " " + orderField.getOrderType());
    		if (i < orderFieldList.size() - 1) {
    			strBuffer.append(", ");
    		}
		}
    	orderFieldList = null;
    }
    
    /**
     * Append order field
     * @param strBuffer SQL
     */
    protected void appendOrderField(StringBuffer strBuffer, String objectName) {
    	if (orderFieldList == null || orderFieldList.isEmpty()) {
    		return;
    	}
    	strBuffer.append(" ORDER BY ");
    	for (int i = 0; i < orderFieldList.size(); i++) {
    		OrderField orderField = orderFieldList.get(i);
    		strBuffer.append(objectName + "." + orderField.getFieldName() + " " + orderField.getOrderType());
    		if (i < orderFieldList.size() - 1) {
    			strBuffer.append(", ");
    		}
		}
    }
    
    /**
     * Add order field
     * @param orderField
     */
    public void addOrderField(OrderField orderField) {
    	if (this.orderFieldList == null) {
    		this.orderFieldList = new ArrayList<OrderField>();
    	}
    	boolean exist = false;
    	if(this.orderFieldList.size() > 0)
	    	for (OrderField o : orderFieldList) {
	    		if(orderField.getFieldName().equals(o.getFieldName()) && orderField.getOrderType().name().equals(o.getOrderType().name()))
	    		{
	    			exist = true;
	    			break;
	    		}
			}
    	if(!exist)
    		this.orderFieldList.add(orderField);
    }
    
}
