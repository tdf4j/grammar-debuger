package org.tdf4j.debugger.service.impl;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tdf4j.debugger.service.Application;
import org.tdf4j.debugger.service.StageLoader;

@Component
public class ApplicationImpl implements Application {

    private final StageLoader stageLoader;
    private Stage mainStage;

    @Autowired
    public ApplicationImpl(final StageLoader stageLoader) {
        this.stageLoader = stageLoader;
    }

    @Override
    public void start(final Stage stage) {
        this.mainStage = stageLoader.loadMainStage(stage);
        mainStage.show();
    }

    @Override
    public void stop() {
        mainStage.close();
    }

}
