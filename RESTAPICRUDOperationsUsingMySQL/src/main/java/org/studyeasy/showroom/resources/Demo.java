package org.studyeasy.showroom.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.studyeasy.showroom.model.ErrorPayLoad;

@Path("/")
public class Demo {

	@Context
	private UriInfo uriInfo;

	@Context
	private ServletContext servletContext;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String welcomeMessage() {
		return "Hello Jax-RS";

	}

	@GET
	@Path("demo")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public String contextDemo(@HeaderParam("header") String header) {

		if (header == null) {
			throw new NotFoundException();
		}
		return "The value of custom header is: " + header;

	}

	@GET
	@Path("demoTOgetURIHeaders")
	@Produces(MediaType.TEXT_PLAIN)
	public String demoContext(@Context HttpHeaders header) {
		return header.getRequestHeaders().keySet().toString();

		// return "Absolute Path: "+uriInfo.getAbsolutePath().toString();

	}
}
