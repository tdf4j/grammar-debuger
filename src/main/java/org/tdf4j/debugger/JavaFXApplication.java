package org.tdf4j.debugger;

import javafx.stage.Stage;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tdf4j.debugger.service.Application;

public class JavaFXApplication extends javafx.application.Application {

    private Application application;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        this.application = new GenericXmlApplicationContext("appcontext.xml")
                .getBean(Application.class);
    }

    @Override
    public void start(final Stage stage) {
        application.start(stage);
    }

    @Override
    public void stop() {
        application.stop();
    }

}
