package org.tdf4j.debugger;

import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.io.IOException;

public class JavaFXApplication extends javafx.application.Application {
    private static ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
       final ApplicationContext applicationContext = new GenericXmlApplicationContext("appcontext.xml");
       applicationContext.getBean(Application.class).run();
       launch(args);
    }

    @Override
    public void init() {
        context = new ClassPathXmlApplicationContext("appcontext.xml");
    }

    @Override
    public void start(Stage stage) throws IOException {
        SpringStageLoader.loadMain().show();
    }

    @Override
    public void stop() throws IOException {
        context.close();
    }
}
