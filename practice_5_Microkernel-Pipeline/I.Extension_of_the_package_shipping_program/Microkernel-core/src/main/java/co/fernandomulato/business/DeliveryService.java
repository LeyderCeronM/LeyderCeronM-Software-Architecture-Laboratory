package co.fernandomulato.business;

import co.fernandomulato.entities.Delivery;
import co.fernandomulato.interfaces.IDeliveryPlugin;
import co.fernandomulato.plugin.manager.DeliveryPluginManager;

public class DeliveryService {

  public double calculateDeliveryCost(Delivery deliveryData) throws Exception {

    String countryCode = deliveryData.getCountryCode();
    DeliveryPluginManager manager = DeliveryPluginManager.getInstance();
    IDeliveryPlugin plugin = manager.getDeliveryPlugin(countryCode);

    if (plugin == null) {
      throw new Exception("No hay un plugin disponible para el país indicado: " + countryCode);
    }

    return plugin.calculateCost(deliveryData);

  }

}
