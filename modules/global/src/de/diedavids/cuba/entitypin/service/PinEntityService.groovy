package de.diedavids.cuba.entitypin.service

import de.diedavids.cuba.entitypin.entity.Customer


public interface PinEntityService {
    String NAME = "entitypin_PinEntityService";

    void pinEntity(Customer customer)
}