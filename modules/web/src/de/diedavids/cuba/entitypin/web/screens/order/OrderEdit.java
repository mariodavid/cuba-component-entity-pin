package de.diedavids.cuba.entitypin.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.entitypin.entity.Order;

@UiController("entitypin$Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}