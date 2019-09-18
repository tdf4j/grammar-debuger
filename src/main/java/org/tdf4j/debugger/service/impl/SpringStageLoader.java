package org.tdf4j.debugger.service.impl;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.tdf4j.debugger.service.StageLoader;

import java.io.IOException;
import java.net.URL;

@Component
public class SpringStageLoader implements ApplicationContextAware, StageLoader {

    private static final String FXML_DIR = "/view/fxml/";
    private static final String MAIN_STAGE = "main.fxml";

    @Value("${title}")
    private String appTitle;
    private ApplicationContext context;

    private Parent loadParent() {
        final FXMLLoader loader = new FXMLLoader();
        final URL fxml = this.getClass().getResource(FXML_DIR + MAIN_STAGE);
        return parentFrom(loader, fxml);
    }

    private Parent parentFrom(final FXMLLoader loader, final URL fxml) {
        try {
            initLoader(loader, fxml);
            return loader.load(fxml.openStream());
        } catch (IOException e) {
            //todo: logger
            throw new RuntimeException("Can't load fxml", e);
        }
    }

    private void initLoader(final FXMLLoader loader, final URL fxml) {
        loader.setLocation(fxml);
        loader.setClassLoader(this.getClass().getClassLoader());
        loader.setControllerFactory(context::getBean);
    }

    @Override
    public Stage loadMainStage(final Stage primaryStage) {
        primaryStage.setScene(new Scene(loadParent()));
        primaryStage.setOnHidden(event -> Platform.exit());
        primaryStage.setTitle(appTitle);
        return primaryStage;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}
