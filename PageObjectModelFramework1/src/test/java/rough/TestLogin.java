package rough;

import pages.LoginPage;

public class TestLogin {

	public static void main(String[] args) {

		LoginPage login = new LoginPage();
		login.doLogin("user", "pass");

	}

}
