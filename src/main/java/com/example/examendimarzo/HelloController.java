package com.example.examendimarzo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;
import utils.MYSQLConecction;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField textNombre;
    @FXML
    private ChoiceBox<String> choiceboxSexo;
    @FXML
    private Spinner<Integer> spinnerEdad;
    @FXML
    private ChoiceBox<String> choiceboxActividad;
    @FXML
    private TextArea textObservaciones;
    @FXML
    private Label lbInfo;
    @FXML
    private Button btnSave;
    @FXML
    private Spinner<Double> spinnerPeso;
    @FXML
    private Spinner<Double> spinnerTalla;
    @FXML
    private Button btnPDFDownload;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceboxActividad.getItems().addAll("Sedentario", "Moderado", "Activo", "Muy Activo");
        choiceboxSexo.getItems().addAll("Masculino", "Femenino");

        SpinnerValueFactory<Integer> edadFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 18);
        spinnerEdad.setValueFactory(edadFactory);

        SpinnerValueFactory<Double> pesoFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(20.0, 300.0, 60,0.5);
        spinnerPeso.setValueFactory(pesoFactory);

        SpinnerValueFactory<Double> tallaFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(40.0, 300.0, 160.0, 0.5);
        spinnerTalla.setValueFactory(tallaFactory);
    }

    @FXML
    public void save(ActionEvent actionEvent) {
        String nombre = textNombre.getText();
        String sexo = choiceboxSexo.getValue();
        int edad = spinnerEdad.getValue();
        double peso = spinnerPeso.getValue();
        double talla = spinnerTalla.getValue();
        String actividad = choiceboxActividad.getValue();

        double ger;
        double get;

        if (sexo != null && actividad != null) {
            if (sexo.equals("Masculino")) {
                ger = 66.473 + (13.751 * peso) + (5.0033 * talla) - (6.755 * edad);
            } else {
                ger = 655.0955 + (9.463 * peso) + (1.8496 * talla) - (4.6756 * edad);
            }

            switch (actividad) {
                case "Sedentario":
                    get = ger * (sexo.equals("Masculino") ? 1.3 : 1.3);
                    break;
                case "Moderado":
                    get = ger * (sexo.equals("Masculino") ? 1.6 : 1.5);
                    break;
                case "Activo":
                    get = ger * (sexo.equals("Masculino") ? 1.7 : 1.6);
                    break;
                case "Muy Activo":
                    get = ger * (sexo.equals("Masculino") ? 2.1 : 1.9);
                    break;
                default:
                    get = 0.0;
            }

            lbInfo.setText("El cliente " + nombre + " tiene \nun GER de " + ger + " y \nun GET de " + get);
        } else {
            lbInfo.setText("Por favor, complete toda la \ninformación antes de calcular.");
        }
    }

    @FXML
    public void downloadPDF(ActionEvent actionEvent) {
        Connection connection = MYSQLConecction.getConexion();
        try {
            JasperPrint jasper = JasperFillManager.fillReport("informeClientes.jasper",new HashMap<>(),connection);
            JRViewer visor = new JRViewer(jasper);
            JFrame ventana = new JFrame("Listado de Clientes");
            ventana.getContentPane().add(visor);
            ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ventana.pack();
            ventana.setVisible(true);
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasper));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Clientes.pdf"));
            exp.setConfiguration(new SimplePdfExporterConfiguration());
            exp.exportReport();
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}