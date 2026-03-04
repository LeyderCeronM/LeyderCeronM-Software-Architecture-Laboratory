package com.fernandomulato;

import javax.swing.SwingUtilities;

import com.fernandomulato.Application.services.ClsAppointmentService;
import com.fernandomulato.Domain.core.kernel.ClsKernel;
import com.fernandomulato.Infrastructure.repository.ClsInMemoryAppointmentRepository;
import com.fernandomulato.Presentation.controller.ClsAppointmentController;
import com.fernandomulato.Presentation.views.ClsMainFrame;

public class App 
{
    public static void main( String[] args )
    {
        // --- Microkernel bootstrap ---
        ClsKernel kernel = ClsKernel.defaultKernel();
        kernel.loadPlugins(); // via Java ServiceLoader

        // --- Core (domain) ---
        var repo = new ClsInMemoryAppointmentRepository();
        var service = new ClsAppointmentService(repo, kernel.getEventBus(), kernel.getOptionalPersistence());
        var controller = new ClsAppointmentController(service);

        SwingUtilities.invokeLater(() -> {
            ClsMainFrame frame = new ClsMainFrame(controller, kernel);
            frame.setVisible(true);

            System.out.println("Directorio de ejecución:");
            System.out.println(System.getProperty("user.dir"));
            System.out.println("user.dir = " + System.getProperty("user.dir"));
        });
    }
}
