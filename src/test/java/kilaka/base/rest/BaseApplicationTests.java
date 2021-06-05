package kilaka.base.rest;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.MessageFormat;

//todo: Simpler way to test rest api.

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseApplicationTests
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testPersonAvailable()
	{
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
				MessageFormat.format("http://localhost:{0,number,#}/api/available/aaa", port), String.class);

		BDDAssertions.then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
