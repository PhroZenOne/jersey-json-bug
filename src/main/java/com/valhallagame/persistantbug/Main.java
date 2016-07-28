package com.valhallagame.persistantbug;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:1234/";

	public static void main(String[] args) throws Exception {
		startServer();
	}

	static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("com.valhallagame.persistantbug");

		// used to inject the user in the requests.
		rc.register(new AbstractBinder() {
			@Override
			protected void configure() {
				bindFactory(UserFactory.class).proxy(true).proxyForSameScope(true).to(User.class).in(RequestScoped.class);
			}
		});

		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
		
	}




}
