package org.acme;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Utilities {
    
    private String message = "my message";

    

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Produces
    public int getNumberOfGreetings(){
        return 1;
    }

    @PostConstruct
    public void init(){
        System.out.println("Utilities instance created!!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Utilities instance gonna dye!");
    }

    @Produces
    List<String> greetings(){
        String[] greetings = new String[]{"hello", "hola", "chao"};
        return Arrays.asList(greetings);
    }

}
