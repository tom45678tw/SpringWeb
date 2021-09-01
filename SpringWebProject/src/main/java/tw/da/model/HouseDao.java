package tw.da.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository("houseDao")
public class HouseDao {
    @Autowired
	private SessionFactory sessionFactory=null;
      
    public House selectById(int houseId) throws SQLException {
    	Session session = sessionFactory.getCurrentSession();
    	House hBean = session.get(House.class, houseId);
    	return hBean;
    }
    
    public List<House> selectAll(){
    	Session session = sessionFactory.getCurrentSession();
    	String hql="from House";
    	Query<House> query = session.createQuery(hql,House.class);
    	return query.list();
    }
}
