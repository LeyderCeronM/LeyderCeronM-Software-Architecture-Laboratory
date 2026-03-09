package co.fernandomulato.interfaces;

import co.fernandomulato.entities.Delivery;

public interface IDeliveryPlugin {

    /**
     * Establece el costo de envío en dólares.
     *
     * @param delivery envío
     * @return costo del envío
     */
    double calculateCost(Delivery delivery);

}
