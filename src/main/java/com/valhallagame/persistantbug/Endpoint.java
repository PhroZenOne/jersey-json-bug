package com.valhallagame.persistantbug;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("test")
@Produces(MediaType.TEXT_PLAIN)
@LoginRequired
public class Endpoint {

	@GET
	public String getAll(@Context User user) {
		return user.getUsername();
	}

}
