package com.example.botecofx;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ComandaPainelController implements Initializable {
    public FlowPane flowPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarComandas();
    }

    public void carregarComandas() {
        // Obter as comandas em aberto do banco
        // Colocar as comandas na tela
        try {
            for (int i = 0; i < 10; i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Comanda-view.fxml"));
                Parent root = (Parent) loader.load();
                ComandaController ctr = loader.getController();
                ctr.setNumeroComanda(i);  // executa o método

                flowPane.getChildren().add(root);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
