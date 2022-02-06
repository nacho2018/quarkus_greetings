package org.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingService {
    
    @Inject
    private List<String> greetings;
    
    public String greeting(String name){
        return "Hello " + name;
    }

    public String getGreetingChain(){
        StringBuilder sBuilder = new StringBuilder();
        
        for (String greeting : greetings){
            if (greeting.equalsIgnoreCase("hola"))
                sBuilder.append(" en español: " + greeting);
            else if (greeting.equalsIgnoreCase("hello"))
                sBuilder.append(" en inglés: " + greeting);
            else if (greeting.equalsIgnoreCase("chao"))
                sBuilder.append(" en italiano: " + greeting);
            else 
                sBuilder.append(" en español: " + greeting);
        }

        return sBuilder.toString();
    }
}
