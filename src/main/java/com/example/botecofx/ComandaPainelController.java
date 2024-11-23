package com.example.botecofx;

import com.example.botecofx.db.dals.ComandaDAL;
import com.example.botecofx.db.entidades.Comanda;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ComandaPainelController implements Initializable {
    public FlowPane flowPane;
    private ComandaDAL comandaDAL = new ComandaDAL();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarComandas();
    }

    public List<Comanda> buscarComandas() {
        List<Comanda> comandas = new ArrayList<>();
        try {
            comandas = comandaDAL.get("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comandas;
    }


    public void carregarComandas() {
        // Obter as comandas em aberto do banco
        List<Comanda> comandas = buscarComandas();
        // Colocar as comandas na tela
        try {
            for (int i = 0; i < comandas.size(); i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("comanda-view.fxml"));
                Parent root = (Parent) loader.load();
                ComandaController ctr = loader.getController();
                if(i == 0) {
                    ctr.setNovaComanda();
                }
                else
                    ctr.setComanda(comandas.get(i));  // executa o método
                flowPane.getChildren().add(root);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
