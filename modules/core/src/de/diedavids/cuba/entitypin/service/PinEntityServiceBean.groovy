package de.diedavids.cuba.entitypin.service

import com.haulmont.cuba.core.global.Metadata
import com.haulmont.cuba.core.global.UserSessionSource
import com.haulmont.cuba.security.entity.Constraint
import com.haulmont.cuba.security.entity.ConstraintCheckType
import com.haulmont.cuba.security.entity.ConstraintOperationType
import de.diedavids.cuba.entitypin.entity.Customer
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(PinEntityService.NAME)
public class PinEntityServiceBean implements PinEntityService {

    @Inject
    UserSessionSource userSessionSource

    @Inject
    Metadata metadata

    @Override
    void pinEntity(Customer customer) {

        def userSession = userSessionSource.userSession

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