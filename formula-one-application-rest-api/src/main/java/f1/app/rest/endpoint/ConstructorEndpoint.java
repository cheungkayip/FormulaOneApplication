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
@Path("/constructors")
public class ConstructorEndpoint {

	/**
	 * @return The data available on all F1 constructors.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() throws Exception {
		final String constructorDataURL = "http://ergast.com/api/f1/2015/Constructors.json";

		final InputStream is = new URL(constructorDataURL).openStream();
		try {
			return IOUtils.toString(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	/**
	 * @return The data available on all F1 constructor's standings.
	 */
	@GET
	@Path("/standings")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStandings() throws Exception {
		final String constructorStandingsDataURL = "http://ergast.com/api/f1/2015/constructorStandings.json";

		final InputStream is = new URL(constructorStandingsDataURL).openStream();
		try {
			return IOUtils.toString(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
}