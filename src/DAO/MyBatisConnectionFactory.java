
package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 *
 * @author Sergio
 */
public class MyBatisConnectionFactory {

    private SqlSessionFactory sqlSessionFactory;

    public  SqlSession getSQLSession()throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        
        return sqlSessionFactory.openSession();
    }
}
