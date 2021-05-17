package DentalClinic.Pharmacy;

import DentalClinic.Pharmacy.Sale.SaleModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class ReportController {
    public void showPatientList(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../../Patient/ListView.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Patient List");
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private ComboBox<?> cmbxItemList;

    @FXML
    private TextField txtPatoentID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTo;

    @FXML
    private Button bttnPrint;

    @FXML
    private Button bttnClose;

    @FXML
    void closeWindow(ActionEvent event) {

    }

    @FXML
    void printReport(ActionEvent event) throws JRException {

        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\DeeGi\\IdeaProjects\\Dental_clinic_system\\src\\DentalClinic\\Reports\\Invoice_report.jrxml");

        Map<String, SaleModel> parameters = new HashMap<String, SaleModel>();

        JRDataSource dataSource = (JRDataSource) new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JRViewer viewer = new JRViewer(jasperPrint);

        viewer.setOpaque(true);
        viewer.setVisible(true);
    }

}




