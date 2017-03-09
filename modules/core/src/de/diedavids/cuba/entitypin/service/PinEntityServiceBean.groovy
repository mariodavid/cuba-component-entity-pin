package de.diedavids.cuba.entitypin.service

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.LoadContext
import com.haulmont.cuba.core.global.Metadata
import com.haulmont.cuba.core.global.UserSessionSource
import com.haulmont.cuba.security.entity.Group
import de.diedavids.cuba.entitypin.entity.Customer
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(PinEntityService.NAME)
public class PinEntityServiceBean implements PinEntityService {

    @Inject
    UserSessionSource userSessionSource

    @Inject
    Metadata metadata

    @Inject
    DataManager dataManager


    @Override
    void pinEntity(Entity entity) {
        def entityName = entity.getMetaClass().getName()

        def userSession = userSessionSource.userSession

        userSession.setAttribute('pinEntity', entity)
        userSession.setAttribute('pinEntityId', entity.id)

        LoadContext loadContext = LoadContext.create(Group)
                .setQuery(LoadContext.createQuery(
                "select e from sec\$Group e where e.parent.id = '5d4601d6-9894-b0af-64b8-83de6d7396ec' and e.name = '$entityName'"
        )
        )

        loadContext.setView('group.copy')
        Group group = dataManager.load(loadContext)

        group.constraints.each {
            userSession.addConstraint(it)
        }
    }

    @Override
    void unpinEntity(Entity entity) {

        def entityName = entity.getMetaClass().getName()
        def userSession = userSessionSource.userSession

        userSession.removeAttribute('pinEntity')
        userSession.removeAttribute('pinEntityId')


        LoadContext loadContext = LoadContext.create(Group)
                .setQuery(LoadContext.createQuery(
                "select e from sec\$Group e where e.parent.id = '5d4601d6-9894-b0af-64b8-83de6d7396ec' and e.name = '$entityName'"
        )
        )

        loadContext.setView('group.copy')
        Group group = dataManager.load(loadContext)

        group.constraints.each {
            userSession.removeConstraint(it)
        }

    }
}