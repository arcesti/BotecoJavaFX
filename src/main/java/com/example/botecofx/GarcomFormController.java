package com.example.botecofx;

import com.example.botecofx.db.dals.GarcomDAL;
import com.example.botecofx.db.entidades.Garcom;
import com.example.botecofx.db.util.SingletonDB;
import com.example.botecofx.util.ApisService;
import com.example.botecofx.util.MaskFieldUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class GarcomFormController implements Initializable {
    @FXML
    private Button btCancelar;

    @FXML
    private Button btConfirmar;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfEnd;

    @FXML
    private TextField tfFone;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfUf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tfNome.requestFocus();
            }
        });
        MaskFieldUtil.cpfField(tfCpf);
        MaskFieldUtil.cepField(tfCep);
        MaskFieldUtil.foneField(tfFone);
        //se for uma alteração
        if(GarcomConsultaController.garcom!=null) {
            Garcom aux = GarcomConsultaController.garcom;
            tfNome.setText(aux.getNome());
        }
        //preencher os dados do garçom

    }

    @FXML
    void onCancelar(ActionEvent event) {
        btCancelar.getScene().getWindow().hide();;
    }

    @FXML
    void onCofirmar(ActionEvent event) {
        Garcom garcom = new Garcom(tfNome.getText(), tfCpf.getText(), tfCep.getText(), tfEnd.getText()
                                   ,tfNumero.getText(), tfCidade.getText(), tfUf.getText(), tfFone.getText());
        if(!new GarcomDAL().gravar(garcom)) {
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erro ao gravar garcom: "+ SingletonDB.getConexao().getMensagemErro());
            alert.showAndWait();
        }
        btConfirmar.getScene().getWindow().hide();
    }

    @FXML
    void tfNome(ActionEvent event) {

    }

    public void onBuscarCep(KeyEvent keyEvent) {
        if(tfCep.getText().length() == 9) {
            String dados = ApisService.consultaCep(tfCep.getText(), "json");
            JSONObject json = new JSONObject(dados);
            tfCidade.setText(json.getString("localidade"));
            tfEnd.setText(json.getString("logradouro"));
            tfUf.setText(json.getString("uf"));
        }
    }
}
