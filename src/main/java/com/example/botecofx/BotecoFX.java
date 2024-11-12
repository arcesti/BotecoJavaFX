package com.example.botecofx;

import com.example.botecofx.db.dals.ComandaDAL;
import com.example.botecofx.db.dals.GarcomDAL;
import com.example.botecofx.db.dals.ProdutoDAL;
import com.example.botecofx.db.entidades.Comanda;
import com.example.botecofx.db.entidades.Garcom;
import com.example.botecofx.db.entidades.Produto;
import com.example.botecofx.db.util.SingletonDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class BotecoFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BotecoFX.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if(!SingletonDB.conectar()) {
            System.out.println(SingletonDB.getConexao().getMensagemErro());
        }

//        Garcom garcom = new Garcom();
//        garcom.setId(1);
//        Comanda comanda = new Comanda(100, "comanda teste", LocalDate.now(), 98, 'A', garcom);
//        ProdutoDAL produtoDAL = new ProdutoDAL();
//        comanda.addItem(new Comanda.Item(produtoDAL.get(6), 4, 15));
//        comanda.addItem(new Comanda.Item(produtoDAL.get(7), 1, 35));
//        comanda.addItem(new Comanda.Item(produtoDAL.get(4), 1, 10));
//        if(!new ComandaDAL().gravar(comanda)) {
//            System.out.println(SingletonDB.getConexao().getMensagemErro());
//        }
//        ComandaDAL dal = new ComandaDAL();
//        Comanda comanda = dal.get(6);
//        System.out.println(comanda.getNumero());
//        System.out.println(comanda.getItens());

        /*ProdutoDAL dal =new ProdutoDAL();
        Produto prod = dal.get(1);
        prod.setPreco(prod.getPreco() * 1.1);
        dal.alterar(prod);*/
        launch();
    }
}