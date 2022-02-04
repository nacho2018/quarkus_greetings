package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @Inject
    Utilities utilities;

    @Inject
    int numberOfGreetings;

    @Inject
    List<String> listOfGreetings;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam(value="name") String name) {
        System.out.println("The name is " + name);
        return service.greeting(name);
    }

    /**
     * compose a simple message by adding string
     * from an application-scope bean
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "hello " + utilities.getMessage();
    }

    /**
     * Returns the numbers of greetings by using
     * a producer method
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/numGreetings")
    public String numGreetings(){
       return "number of greetings is " + numberOfGreetings;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greetings/list")
    public List<String> list(){
        System.out.println("changes from local");
        System.out.println("changes from local 2");
        System.out.println("changes from local 3");
        return listOfGreetings;

    }
}
