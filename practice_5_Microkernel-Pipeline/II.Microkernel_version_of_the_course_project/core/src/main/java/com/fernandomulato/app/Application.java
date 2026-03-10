package com.fernandomulato.app;

import com.fernandomulato.presentation.Console;

import java.io.File;

import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fernandomulato.plugin.manager.ReportPluginManager;

public class Application {

  public static void main(String[] args) {

    // Inicializar el plugin manager con la ruta base de la aplicación.
    String basePath = getBaseFilePath();
    try {
      ReportPluginManager.init(basePath);

      Console presentationObject = new Console();
      presentationObject.start();

    } catch (Exception ex) {
      Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
    }

  }

  /**
   * Obtiene la ruta base donde está corriendo la aplicación, sin importar que
   * sea desde un archivo .class o desde un paquete .jar.
   *
   */
  private static String getBaseFilePath() {
    try {

      String path = Application.class
          .getProtectionDomain()
          .getCodeSource()
          .getLocation()
          .toURI()
          .getPath();

      path = URLDecoder.decode(path, "UTF-8");

      File pathFile = new File(path);

      if (pathFile.isFile()) {
        path = pathFile.getParent();
      }

      if (!path.endsWith(File.separator)) {
        path += File.separator;
      }

      return path;

    } catch (Exception ex) {
      Logger.getLogger(Application.class.getName())
          .log(Level.SEVERE, "Error obteniendo la ruta base", ex);
      return null;
    }
  }

}
