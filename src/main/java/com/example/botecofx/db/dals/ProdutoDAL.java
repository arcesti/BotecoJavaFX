package com.example.botecofx.db.dals;

import com.example.botecofx.db.entidades.Categoria;
import com.example.botecofx.db.entidades.Produto;
import com.example.botecofx.db.entidades.Unidade;
import com.example.botecofx.db.util.IDAL;
import com.example.botecofx.db.util.SingletonDB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAL implements IDAL<Produto> {

    @Override
    public boolean gravar(Produto entidade) {
        String sql = """
                INSERT INTO produto(cat_id, uni_id, prod_nome, prod_preco, prod_descr) VALUES(#1, #2, '#3', #4, '#5');
                """;
        sql = sql.replace("#1","" + entidade.getCategoria().getId());
        sql = sql.replace("#2", "" + entidade.getUnidade().getId());
        sql = sql.replace("#3", entidade.getNome());
        sql = sql.replace("#4", ""+entidade.getPreco());
        sql = sql.replace("#5", entidade.getDescr());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean alterar(Produto entidade) {
        String sql = """
                UPDATE produto SET prod_nome='#1'
                                   prod_descr='#2'
                                   prod_preco=#3
                        WHERE prod_id=#4;
                """;
        sql = sql.replace("#1", entidade.getNome());
        sql = sql.replace("#2", entidade.getDescr());
        sql = sql.replace("#3", ""+entidade.getPreco());
        sql = sql.replace("#4","" + entidade.getId());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean apagar(Produto entidade) {
        return SingletonDB.getConexao().manipular("DELETE FROM produto WHERE prod_id=" + entidade.getId());
    }

    @Override
    public Produto get(int id) {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE prod_id=" + id;
        ResultSet resultSet = SingletonDB.getConexao().consultar(sql);
        try {
            if(resultSet.next()) {
                int catId = resultSet.getInt("cat_id");
                int uniId = resultSet.getInt("uni_id");
                Categoria categoria = getCategoriaById(catId);
                Unidade unidade = getUnidadeById(uniId);
                produto = new Produto(id, resultSet.getString("prod_nome"),
                                      resultSet.getDouble("prod_preco"),
                                      resultSet.getString("prod_descr"),
                                      categoria,
                                      unidade
                                     );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    @Override
    public List<Produto> get(String filtro) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto ";
        if (!filtro.isEmpty()) {
            sql += "WHERE " + filtro;
        }
        sql+=" ORDER BY prod_nome";
        ResultSet resultSet = SingletonDB.getConexao().consultar(sql);
        try {
            while (resultSet.next()) {
                Categoria categoria = getCategoriaById(resultSet.getInt("cat_id"));
                Unidade unidade = getUnidadeById(resultSet.getInt("uni_id"));
                produtos.add(new Produto(resultSet.getInt("prod_id"),
                                         resultSet.getString("prod_nome"),
                                         resultSet.getDouble("prod_preco"),
                                         resultSet.getString("prod_descr"),
                                         categoria,
                                         unidade
                                        ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

    private Unidade getUnidadeById(int uniId) {
        ResultSet resultSet = SingletonDB.getConexao().consultar("SELECT * FROM unidade WHERE uni_id=" + uniId);
        Unidade uni = null;
        try {
            if(resultSet.next()) {
                uni = new Unidade(resultSet.getInt("uni_id"), resultSet.getString("uni_nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uni;
    }

    private Categoria getCategoriaById(int catId) {
        ResultSet resultSet;
        resultSet = SingletonDB.getConexao().consultar("SELECT * FROM categoria WHERE cat_id=" + catId);
        Categoria cat = null;
        try {
            if (resultSet.next())
                cat = new Categoria(resultSet.getInt("cat_id"), resultSet.getString("cat_nome"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cat;
    }
}
