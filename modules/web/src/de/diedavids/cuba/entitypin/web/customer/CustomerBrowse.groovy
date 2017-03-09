package de.diedavids.cuba.entitypin.web.customer

import com.haulmont.cuba.core.global.Metadata
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.GroupTable
import com.haulmont.cuba.gui.data.CollectionDatasource
import com.haulmont.cuba.security.entity.Constraint
import com.haulmont.cuba.security.entity.ConstraintCheckType
import com.haulmont.cuba.security.entity.ConstraintOperationType
import com.haulmont.cuba.security.global.UserSession
import com.haulmont.cuba.web.AppUI
import de.diedavids.cuba.entitypin.entity.Customer
import de.diedavids.cuba.entitypin.service.PinEntityService
import de.diedavids.cuba.entitypin.web.screens.ExtAppMainWindow
import de.diedavids.cuba.entitypin.web.screens.PinAction

import javax.inject.Inject

public class CustomerBrowse extends AbstractLookup {

    @Inject
    GroupTable<Customer> customersTable

    @Inject
    CollectionDatasource<Customer, UUID> customersDs

    @Inject
    UserSession userSession

    @Inject
    Metadata metadata

    @Inject
    PinEntityService pinEntityService

    @Override
    void init(Map<String, Object> params) {
        super.init(params)
        customersTable.addAction(new PinAction())
    }

    void pin() {
        def customer = customersTable.getSingleSelected()
        pinEntity(customer)
    }

    void pinEntity(Customer customer) {
        def mainWindow = AppUI.current.topLevelWindow
        mainWindow.pinEntity(customer)
        customersDs.refresh()
    }
}