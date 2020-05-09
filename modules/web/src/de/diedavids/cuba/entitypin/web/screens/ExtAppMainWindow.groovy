package de.diedavids.cuba.entitypin.web.screens


import com.haulmont.cuba.gui.components.*
import com.haulmont.cuba.security.global.UserSession
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow
import de.diedavids.cuba.entitypin.service.PinEntityService
import de.diedavids.cuba.entitypin.web.EntityPinnedEvent

import javax.inject.Inject

class ExtAppMainWindow extends AppMainWindow {

    @Inject
    Button pinBtn

    @Inject
    UserSession userSession

    @Inject
    PinEntityService pinEntityService


    void releasePin() {
        def entity = userSession.getAttribute("pinEntity")
        pinEntityService.unpinEntity(entity)
        userSession.removeAttribute("pinEntityId")

        pinBtn.enabled = false
        pinBtn.caption = formatMessage('pinEntity.noPin');


        showNotification("Pin released", Frame.NotificationType.TRAY);
    }

    @org.springframework.context.event.EventListener
    void pinEntity(EntityPinnedEvent entityPinnedEvent) {

        def entity = entityPinnedEvent.getEntity()
        def instanceCaption = entity.instanceName

        showOptionDialog(
                formatMessage('pinEntity.title'),
                formatMessage('pinEntity.message', instanceCaption),
                Frame.MessageType.CONFIRMATION,
                [
                        new DialogAction(DialogAction.Type.OK) {
                            @Override
                            void actionPerform(Component component) {

                                userSession.setAttribute('pinEntityId', entity.id)
                                userSession.setAttribute('pinEntity', entity)

                                pinEntityService.pinEntity(entityPinnedEvent.getEntity())
                                Object pinEntity = userSession.getAttribute("pinEntity");
                                if (pinEntity != null) {
                                    showNotification(formatMessage('pinEntity.pinned.message', instanceCaption), Frame.NotificationType.TRAY);
                                    pinBtn.caption = instanceCaption;
                                    pinBtn.enabled = true
                                    pinBtn.addStyleName('pin-button-pinned')
                                }
                            }
                        },
                        new DialogAction(DialogAction.Type.CANCEL)
                ] as List<Action>
        )

    }
}