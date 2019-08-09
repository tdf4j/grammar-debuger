package org.tdf4j.debugger;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TMP {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new GenericXmlApplicationContext("appcontext.xml");
        applicationContext.getBean(Application.class).run();
    }

}
