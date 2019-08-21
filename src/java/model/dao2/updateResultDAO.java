
package model.dao2;

import model.dto.updateResult;
import java.sql.SQLException;

public interface updateResultDAO {
    
    public void updateResults(updateResult updateresult) throws SQLException;
}
