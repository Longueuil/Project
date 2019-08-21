package model.dao2;

import model.dto.Result;
import java.sql.SQLException;

public interface ResultDAO {
    
     public void addResult(Result st) throws SQLException;
}
