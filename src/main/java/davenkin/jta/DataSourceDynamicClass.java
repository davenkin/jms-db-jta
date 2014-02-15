package davenkin.jta;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/5/14
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.XADataSource;

import com.arjuna.ats.internal.jdbc.DynamicClass;

public class DataSourceDynamicClass implements DynamicClass {
    @Override
    public XADataSource getDataSource(String dbName) throws SQLException {
        try {
            InitialContext ic = new InitialContext();
            return (XADataSource) ic
                    .lookup("java:MyDataSource");
        } catch (NamingException e) {
            throw new SQLException(null, e);
        }
    }
}

