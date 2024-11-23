package com.example.botecofx;

import com.example.botecofx.db.dals.ProdutoDAL;
import com.example.botecofx.db.entidades.Comanda;
import com.example.botecofx.db.entidades.Garcom;
import com.example.botecofx.db.entidades.Produto;
import com.example.botecofx.db.entidades.TipoPagamento;
import com.example.botecofx.db.util.SingletonDB;
import com.example.botecofx.util.ModalTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;

public class ComandaFormController {

    public Button btProduto;
    @FXML
    private ComboBox<Garcom> cbGarcom;

    @FXML
    private ComboBox<TipoPagamento> cbTipoPagamento;

    @FXML
    private TableColumn<Comanda.Item, String> colProduto;

    @FXML
    private TableColumn<Comanda.Item, String> colQuant;

    @FXML
    private TableColumn<Comanda.Item, String> colValor;

    @FXML
    private DatePicker dpData;

    @FXML
    private Label lbValor;

    @FXML
    private Spinner<Integer> spQuant;

    @FXML
    private TextArea taDesc;

    @FXML
    private TableView<Comanda.Item> tableView;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNumero;

    Produto produto = null;

    @FXML
    void onAdd(ActionEvent event) {

    }

    @FXML
    void onCancelar(ActionEvent event) {

    }

    @FXML
    void onConfirmar(ActionEvent event) {

    }

    @FXML
    void onFinalizar(ActionEvent event) {

    }

    @FXML
    void onImprimir(ActionEvent event) {
        int comandaId = ComandaController.id;
        HashMap hashMap = new HashMap();
        hashMap.put("comanda_id", comandaId);
        gerarRelatorioSubReport("reports/comandaPrint.jasper", "Comanda", hashMap);
    }

    @FXML
    void onSelProduto(ActionEvent event) {
        ModalTable modalTable = new ModalTable(new ProdutoDAL().get(""),
                                new String[]{"nome", "preco", "categoria"},
                                "nome");
        Stage stage=new Stage();
        stage.setScene(new Scene(modalTable));
        stage.setWidth(600); stage.setHeight(480); stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        produto = (Produto)modalTable.getSelecionado();
        btProduto.setText(produto.toString());
    }

    private void gerarRelatorioSubReport(String relat, String titulotela, Map parametros)
    {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(relat, parametros,
                    SingletonDB.getConexao().getConnect());
            JasperViewer viewer = new JasperViewer(jasperPrint,false);

            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);//maximizado
            viewer.setTitle(titulotela);
            viewer.setVisible(true);
        } catch (JRException erro) {
            System.out.println(erro);
        }
    }
}