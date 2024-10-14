package com.example.botecofx;

import com.example.botecofx.db.dals.CategoriaDAL;
import com.example.botecofx.db.dals.ProdutoDAL;
import com.example.botecofx.db.dals.TipoPagamentoDAL;
import com.example.botecofx.db.entidades.Categoria;
import com.example.botecofx.db.entidades.Produto;
import com.example.botecofx.db.entidades.TipoPagamento;
import com.example.botecofx.db.entidades.Unidade;
import com.example.botecofx.db.util.SingletonDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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

        /*List<TipoPagamento> tpPgtos = new TipoPagamentoDAL().get("tpg_id > 0");
        int i = 0;
        while(i < tpPgtos.size()) {
            System.out.println("Id: " + tpPgtos.get(i).getId() + "\nNome: " + tpPgtos.get(i).getNome());
            System.out.println("\n");
            i++;
        }*/

        /*Categoria cat = new CategoriaDAL().get(1);
        Unidade uni = new Unidade(1, "Bebida");
        Produto prod = new Produto("Coca", 5.99, "Coca Gelada", cat, uni);
        new ProdutoDAL().gravar(prod);*/

        /*List<Produto> prod = new ProdutoDAL().get("prod_id > 0");
        int i = 0;
        while(i < prod.size()) {
            System.out.println("Nome: " + prod.get(i).getNome() + "\nId: " + prod.get(i).getId() + "\nPreço: " + prod.get(i).getPreco() + "\nDescrição: " + prod.get(i).getDescr());
            System.out.println("\n");
            i++;
        }*/

        /*Categoria categoria = new Categoria("Lanche");
        new CategoriaDAL().gravar(categoria);*/

        //launch();
    }
}