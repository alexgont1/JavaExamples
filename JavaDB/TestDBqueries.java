import java.sql.SQLException;
import java.util.List;

public class TestDBqueries {

	public static void main(String[] args) throws SQLException {
		
		DBManager.setMysqlDBConnection();

		//1 column
		List<String> query = DBManager.getMysqlQuery("select City from students;");
		
		for(String q: query) {
			System.out.println(q);
		}
	}
}
