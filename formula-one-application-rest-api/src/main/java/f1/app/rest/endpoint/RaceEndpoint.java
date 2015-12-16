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
@Path("/races")
public class RaceEndpoint {

	/**
	 * @return The data available on all F1 races.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() throws Exception {
		final String raceResultsDataURL = "http://ergast.com/api/f1/2015/results.json";

		final InputStream is = new URL(raceResultsDataURL).openStream();
		try {
			return IOUtils.toString(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
}