package de.diedavids.cuba.entitypin.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.entitypin.entity.Customer;

@UiController("entitypin$Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}