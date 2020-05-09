package de.diedavids.cuba.entitypin.web.screens.order;

import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.entitypin.entity.Customer;
import de.diedavids.cuba.entitypin.entity.Order;
import de.diedavids.cuba.entitypin.web.EntityPinnedEvent;

import javax.inject.Inject;

@UiController("entitypin$Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {

    @Inject
    protected Events events;
    @Inject
    protected GroupTable<Order> ordersTable;

    @Subscribe("ordersTable.pin")
    protected void onordersTablePin(Action.ActionPerformedEvent event) {
        Order order = ordersTable.getSingleSelected();
        events.publish(new EntityPinnedEvent(this, order));
    }
}