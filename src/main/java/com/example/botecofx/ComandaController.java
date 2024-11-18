package com.example.botecofx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ComandaController {
    public AnchorPane anchorPane;
    public Label lbNumCommand;
    public Label lbValor;
    static public int id;

    public void onGerenciarComanda(MouseEvent mouseEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(BotecoFX.class.getResource("comanda-form-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void setNumeroComanda(int id) {
        // Buscar o numero da comanda pelo id recebido
        this.id = id;
        lbNumCommand.setText(""+id);
        // Atualizar o valor
        lbValor.setText("R$ 10,00");
    }
}
