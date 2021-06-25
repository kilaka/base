package kilaka.base.rest;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//todo: Simpler way to test rest api.

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseApplicationIT
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testPersonAvailable()
	{
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + port + "/api/available/aaaaa", String.class);

		BDDAssertions.then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
