package de.diedavids.cuba.entitypin.service

import com.haulmont.cuba.core.entity.Entity

public interface PinEntityService {
    String NAME = "entitypin_PinEntityService";

    void pinEntity(Entity entity)
    void unpinEntity(Entity entity)
}