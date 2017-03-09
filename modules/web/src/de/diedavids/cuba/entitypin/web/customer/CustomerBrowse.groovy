package de.diedavids.cuba.entitypin.web.customer

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.GroupTable
import com.haulmont.cuba.security.entity.Constraint
import com.haulmont.cuba.security.entity.ConstraintCheckType
import com.haulmont.cuba.security.entity.ConstraintOperationType
import com.haulmont.cuba.security.global.UserSession
import de.diedavids.cuba.entitypin.entity.Customer
import de.diedavids.cuba.entitypin.service.PinEntityService

import javax.inject.Inject;

public class CustomerBrowse extends AbstractLookup {

    @Inject
    GroupTable<Customer> customersTable

    @Inject
    UserSession userSession

    @Inject
    Metadata metadata

    @Inject
    PinEntityService pinEntityService

    public void pin() {

        def customer = customersTable.getSingleSelected()

        def cId = userSession.getAttribute('pinEntity')

        pinEntityService.pinEntity(customer)
        pinEntity(customer)
    }

    void pinEntity(Customer customer) {

        userSession.setAttribute('pinEntity', customer.id)

        def c = metadata.create(Constraint)

        c.checkType = ConstraintCheckType.DATABASE

        c.entityName = 'entitypin$Order'
        c.whereClause = '{E}.customer.id = :session$pinEntity'
        c.isActive = true
        c.operationType = ConstraintOperationType.ALL

        userSession.addConstraint(c)
    }
}