package de.diedavids.cuba.entitypin.web.screens;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Timer;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.security.global.UserSession;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.util.Map;

public class ExtAppMainWindow extends AppMainWindow {

    @Inject
    Button pinBtn;

    @Inject
    UserSession userSession;

    @Inject
    ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        Object pinEntity = userSession.getAttribute("pinEntity");
        if (pinEntity != null) {
            pinBtn.setCaption(pinEntity.toString());
        }


        Timer helloTimer = componentsFactory.createTimer();
        // add timer to the screen
        addTimer(helloTimer);
        // set timer parameters
        helloTimer.setDelay(5000);
        helloTimer.setRepeating(true);
        // add execution handler
        helloTimer.addActionListener(timer -> {

            pinClick();
        });
        // add stop listener
        helloTimer.addStopListener(timer -> {
            showNotification("Timer is stopped", NotificationType.HUMANIZED);
        });
        // start the timer
        helloTimer.start();
    }

    public void pinClick() {

        Object pinEntity = userSession.getAttribute("pinEntity");
        if (pinEntity != null) {
            showNotification("pinEntity" + pinEntity, NotificationType.TRAY);
            pinBtn.setCaption(pinEntity.toString());
        }
        else {

            showNotification("nix da...", NotificationType.TRAY);
        }
    }
}