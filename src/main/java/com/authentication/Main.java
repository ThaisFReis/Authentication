package com.authentication;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.filter.UriConnegFilter;

import com.authentication.middleware.authMiddleware;
import com.authentication.router.userRouter;

public class Main extends ResourceConfig {

    public Main() {
        // Registra os roteadores
        register(userRouter.class);

        // Registra os middleware
        register(authMiddleware.class);
        register(RolesAllowedDynamicFeature.class);
        register(UriConnegFilter.class);

        // Define a pasta onde ficam as classes dos controladores
        packages("com.authentication.controller");
    }

    public static void main(String[] args) {
        // Cria uma instância do servidor de aplicativos
        org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory.createHttpServer(
                    java.net.URI.create("http://localhost:8080/"),
                    new Main(),
                    false
            );
    }
}