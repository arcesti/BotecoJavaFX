package com.example.botecofx;

import com.example.botecofx.db.dals.ProdutoDAL;
import com.example.botecofx.db.entidades.Comanda;
import com.example.botecofx.db.entidades.Garcom;
import com.example.botecofx.db.entidades.Produto;
import com.example.botecofx.db.entidades.TipoPagamento;
import com.example.botecofx.util.ModalTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

}