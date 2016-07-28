package com.valhallagame.persistantbug;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;

import org.glassfish.hk2.api.Factory;

public class UserFactory implements Factory<User> {

	@Inject
	// if the context argument is removed the crash no longer triggers
	public UserFactory(ContainerRequestContext context) {
	}

	@Override
	public User provide() {
		return new User("test");
	}

	@Override
	public void dispose(User t) {
	}
}