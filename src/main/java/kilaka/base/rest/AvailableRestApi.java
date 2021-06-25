package kilaka.base.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class AvailableRestApi
{
	@GetMapping("/available/{id}")
	public String isAvailable(@PathVariable String id)
	{
		return MessageFormat.format("{0} is available!!!!", id);
	}
}
