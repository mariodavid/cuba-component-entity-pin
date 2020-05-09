package de.diedavids.cuba.entitypin.web.screens.customer;

import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.entitypin.entity.Customer;
import de.diedavids.cuba.entitypin.web.EntityPinnedEvent;

import javax.inject.Inject;

@UiController("entitypin$Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    protected Events events;
    @Inject
    protected GroupTable<Customer> customersTable;

    @Subscribe("customersTable.pin")
    protected void onCustomersTablePin(Action.ActionPerformedEvent event) {
        Customer customer = customersTable.getSingleSelected();
        events.publish(new EntityPinnedEvent(this, customer));
    }
}