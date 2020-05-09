package de.diedavids.cuba.entitypin.web;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.events.UiEvent;
import org.springframework.context.ApplicationEvent;

public class EntityPinnedEvent extends ApplicationEvent implements UiEvent {


    private final Entity entity;

    public EntityPinnedEvent(Object source, Entity entity) {
        super(source);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
