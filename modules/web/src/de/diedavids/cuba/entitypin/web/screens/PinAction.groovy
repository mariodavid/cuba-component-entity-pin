package de.diedavids.cuba.entitypin.web.screens

import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.ListComponent
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction
import com.haulmont.cuba.web.AppUI

class PinAction extends ItemTrackingAction implements Action.HasOpenType {

    public static final String ACTION_ID = 'pin'
    private final String ACTION_MSG_KEY = 'actions.Pin'


    WindowManager.OpenType openType

    PinAction() {
        this(ACTION_ID)
    }

    PinAction(String id) {
        this(null, id)
    }

    protected PinAction(ListComponent target, String id) {
        super(target, id)

        this.caption = messages.getMainMessage(ACTION_MSG_KEY)
        this.icon = 'icons/pin.png'
    }

    @Override
    void actionPerform(Component component) {

        def mainWindow = AppUI.current.topLevelWindow
        mainWindow.pinEntity(target.singleSelected)
        target.datasource.refresh()
//        Window dokumentWindow = target.frame.openWindow(
//                'pl$Dokument.browse',
//                openType ?: WindowManager.OpenType.DIALOG,
//                [entity: target.singleSelected])
//
//        dokumentWindow.addCloseListener(new Window.CloseListener() {
//            @Override
//            void windowClosed(String actionId) {
//                updateCaption()
//            }
//        })
    }
}
