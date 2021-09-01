package tw.da.model;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseService {
	@Autowired
	private HouseDao hDao;

	public House selectById(int houseid) throws SQLException {
		return hDao.selectById(houseid);
	}

	
	public List<House> selectAll(){
    
    	return   hDao.selectAll();
    }
}