package com.fernandomulato.plugin.manager;

import com.fernandomulato.interfaces.IReportPlugin;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Administrador de plugins de reportes.
 * Utiliza reflexión para cargar dinámicamente los plugins definidos
 * en el archivo plugin.properties.
 */
public class ReportPluginManager {

  private static final String FILE_NAME = "plugin.properties";
  private static final Logger LOGGER = Logger.getLogger(ReportPluginManager.class.getName());

  private static ReportPluginManager instance;

  private Properties pluginProperties;

  private ReportPluginManager() {
    pluginProperties = new Properties();
  }

  public static ReportPluginManager getInstance() {
    if (instance == null) {
      throw new IllegalStateException("ReportPluginManager no ha sido inicializado. Llame init() primero.");
    }
    return instance;
  }

  public static void init(String basePath) throws Exception {

    instance = new ReportPluginManager();
    instance.loadProperties(basePath);

    if (instance.pluginProperties.isEmpty()) {
      throw new Exception("No se pudieron cargar los plugins");
    }
  }

  /**
   * Obtiene un plugin según el tipo de reporte.
   * Ej: html, json, pdf
   */
  public IReportPlugin getReportPlugin(String reportType) {

    String propertyName = "report." + reportType.toLowerCase();

    if (!pluginProperties.containsKey(propertyName)) {
      return null;
    }

    String pluginClassName = pluginProperties.getProperty(propertyName);

    try {

      Class<?> pluginClass = Class.forName(pluginClassName);

      Object pluginObject = pluginClass.getDeclaredConstructor().newInstance();

      if (pluginObject instanceof IReportPlugin) {
        return (IReportPlugin) pluginObject;
      }

    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException
        | InvocationTargetException ex) {

      LOGGER.log(Level.SEVERE, "Error cargando plugin: " + pluginClassName, ex);
    }

    return null;
  }

  private void loadProperties(String basePath) {

    try {

      // Normalizar la ruta para Windows
      if (basePath.startsWith("/") && basePath.contains(":")) {
        basePath = basePath.substring(1);
      }

      String filePath = Paths.get(basePath, FILE_NAME).toString();

      try (FileInputStream stream = new FileInputStream(filePath)) {
        pluginProperties.load(stream);
      }

    } catch (IOException ex) {
      LOGGER.log(Level.SEVERE, "Error cargando archivo de plugins", ex);
    }
  }
}