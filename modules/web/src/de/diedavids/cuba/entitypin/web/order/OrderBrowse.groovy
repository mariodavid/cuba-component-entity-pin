package de.diedavids.cuba.entitypin.web.order

import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.GroupTable
import de.diedavids.cuba.entitypin.entity.Order
import de.diedavids.cuba.entitypin.web.screens.PinAction

import javax.inject.Inject

public class OrderBrowse extends AbstractLookup {


    @Inject
    GroupTable<Order> ordersTable

    @Override
    void init(Map<String, Object> params) {
        super.init(params)
        ordersTable.addAction(new PinAction())
    }
}