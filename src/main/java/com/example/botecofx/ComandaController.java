package com.example.botecofx;

import com.example.botecofx.db.entidades.Comanda;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void setComanda(Comanda comanda) {
        // Buscar o numero da comanda pelo id recebido
        this.id = comanda.getNumero();
        lbNumCommand.setText(""+id);
        // Atualizar o valor
        lbValor.setText("" + comanda.getValor());
    }

    public void setNovaComanda() throws IOException {
        lbNumCommand.setText("+");
        lbNumCommand.setFont(Font.font(40));
        anchorPane.setStyle("-fx-background-color: #008F39; -fx-background-radius: 16; -fx-border-radius: 16;");
        // ARRUMAR O EVENTO DE CLIQUE
        lbValor.setText("");
    }
}
