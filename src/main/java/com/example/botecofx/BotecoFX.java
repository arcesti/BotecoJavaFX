package com.example.botecofx;

import com.example.botecofx.db.dals.ProdutoDAL;
import com.example.botecofx.db.entidades.Produto;
import com.example.botecofx.db.util.SingletonDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BotecoFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BotecoFX.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if(!SingletonDB.conectar()) {
            System.out.println(SingletonDB.getConexao().getMensagemErro());
        }
        ProdutoDAL dal =new ProdutoDAL();
        Produto prod = dal.get(1);
        prod.setPreco(prod.getPreco() * 1.1);
        dal.alterar(prod);
        //launch();
    }
}