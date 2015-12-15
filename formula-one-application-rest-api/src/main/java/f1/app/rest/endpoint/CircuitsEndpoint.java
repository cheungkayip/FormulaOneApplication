package f1.app.rest.endpoint;

import java.io.InputStream;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

/**
 * @author edwin
 */
@Path("/circuits")
public class CircuitsEndpoint {

	/**
	 * @return The data available on all F1 circuits.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() throws Exception {
		final String circuitsDataURL = "http://ergast.com/api/f1/2015/circuits.json";

		final InputStream is = new URL(circuitsDataURL).openStream();
		try {
			return IOUtils.toString(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
}