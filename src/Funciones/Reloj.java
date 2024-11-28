import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reloj extends JFrame {

    private JLabel fechaLabel;
    private JLabel horaLabel;

    public Reloj() {
        // Configurar el layout del JFrame
        setLayout(new GridLayout(2, 1)); // Dos filas para las etiquetas

        // Inicializar las etiquetas
        fechaLabel = new JLabel();
        horaLabel = new JLabel();

        // Establecer fuentes y alineaciones
        fechaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        horaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        fechaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        horaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar las etiquetas al JFrame
        add(fechaLabel);
        add(horaLabel);

        // Configurar la fecha inicial
        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        fechaLabel.setText("Fecha: " + fechaActual);

        // Actualizar la hora con un Timer
        Timer timer = new Timer(1000, e -> {
            String horaActual = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            horaLabel.setText("Hora: " + horaActual);
        });
        timer.start();
    }
}

