package com.test;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(title = "Car API", version = "1.0"),
        security = @SecurityRequirement(name = "oauth2"),
        servers = @Server(url = "/test/"))
@ApplicationPath("/api")
public class ApplicationConfiguration extends Application {
}
