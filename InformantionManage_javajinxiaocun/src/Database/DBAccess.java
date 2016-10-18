package Database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.*;
import org.apache.ibatis.session.*;


public class DBAccess {
	
	public SqlSession getSqlSession() throws IOException{
		
		Reader reader=Resources.getResourceAsReader("Config/Configuration.xml");
		
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession =sqlSessionFactory.openSession();
		
		return sqlSession;
		
	}

}
