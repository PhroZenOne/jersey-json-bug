package com.valhallagame.persistantbug;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.valhallagame.persistantbug.Main;

public class BugTrigger {

    private WebTarget target;
	private HttpServer server;

    @Before
    public void setUp() throws Exception {
        // start the server
       server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }
    
    @After
    public void tearDown(){
    	server.shutdownNow();
    }

    @Test
    public void testTrigger() {
      target.path("test").request().get(String.class);
    }
}
