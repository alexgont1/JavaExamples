import java.sql.SQLException;
import java.util.List;

public class TestDBqueries {

	public static void main(String[] args) throws SQLException {

		DBManager.setMysqlDBConnection();

		// 1 column
		List<String> query = DBManager.getMysqlQuery("select City from students;");

		for (String q : query) {
			System.out.println(q);
		}

		// or you can select 1 element
		String s = DBManager
				.getMysqlQuery("select City from students;").get(0);
		System.out.println(s);
	}
}
