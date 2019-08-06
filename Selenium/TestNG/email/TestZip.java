import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestZip {

	public static void main(String[] args) throws AddressException, MessagingException {
		String zipName[] = testUtil.zip("s:/screenshot");
		System.out.println(zipName[0]+"\t"+zipName[1]);
		monitoringMail mail = new monitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, zipName[0], zipName[1]);
	}

}
