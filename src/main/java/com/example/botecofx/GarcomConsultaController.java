package com.example.botecofx;

import com.example.botecofx.db.entidades.Garcom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GarcomConsultaController implements Initializable {
    @FXML
    private TableColumn<Garcom, String> colCidade;

    @FXML
    private TableColumn<Garcom, String> colFone;

    @FXML
    private TableColumn<Garcom, String> colId;

    @FXML
    private TableColumn<Garcom, String> colNome;

    @FXML
    private TableView<Garcom> tabela;

    @FXML
    private TextField tfFiltro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onAlterar(ActionEvent event) {

    }

    @FXML
    void onExcluir(ActionEvent event) {

    }

    @FXML
    void onFechar(ActionEvent event) {

    }

    @FXML
    void onFiltro(KeyEvent event) {

    }

    @FXML
    void onNovo(ActionEvent event) {

    }
}
