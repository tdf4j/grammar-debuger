package org.tdf4j.debugger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final Service service;

    @Autowired
    public Application(final Service service) {
        this.service = service;
    }

    void run() {
        service.test();
    }

}
