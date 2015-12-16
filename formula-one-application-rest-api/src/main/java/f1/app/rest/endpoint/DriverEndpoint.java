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
@Path("/drivers")
public class DriverEndpoint {

	/**
	 * @return The data available on all F1 drivers.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() throws Exception {
		final String driversDataURL = "http://ergast.com/api/f1/2015/drivers.json";

		final InputStream is = new URL(driversDataURL).openStream();
		try {
			return IOUtils.toString(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	/**
	 * @return The data available on all F1 drivers' standings.
	 */
	@GET
	@Path("/standings")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStandings() throws Exception {
		final String driversStandingsDataURL = "http://ergast.com/api/f1/2015/driverStandings.json";

		final InputStream is = new URL(driversStandingsDataURL).openStream();
		try {
			return IOUtils.toString(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
}