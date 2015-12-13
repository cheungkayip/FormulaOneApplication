package f1.app.rest.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author edwin
 */
@Path("/drivers")
public class DriverEndpoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		System.out.println("GET");
		return ("{test:test}");
	}
}