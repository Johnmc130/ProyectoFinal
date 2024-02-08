/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Steven Zhicay
 */
public class CargarImagenesSteven {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/Proyecto_Final";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        uploadImageToDatabase(7); // Reemplaza 1 con el ID del procesador que estás actualizando
    }

    public static void uploadImageToDatabase(int idProcesador) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Crear un objeto FileChooser para seleccionar la imagen
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selecciona una imagen");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                // Convertir la imagen a un array de bytes
                byte[] imageData = convertImageToBytes(selectedFile);

                // Actualizar la base de datos con la imagen
                updateImageInDatabase(connection, idProcesador, imageData);

                System.out.println("Imagen cargada exitosamente.");
            } else {
                System.out.println("Operación cancelada por el usuario.");
            }

            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] convertImageToBytes(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            fis.read(imageData);
            return imageData;
        }
    }

    private static void updateImageInDatabase(Connection connection, int idProcesador, byte[] imageData) throws SQLException {
        String sql = "UPDATE Procesador SET imagen = ? WHERE id_procesador = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBytes(1, imageData);
            preparedStatement.setInt(2, idProcesador);

            preparedStatement.executeUpdate();
        }
    }
}