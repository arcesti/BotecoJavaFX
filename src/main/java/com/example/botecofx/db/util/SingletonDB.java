package com.example.botecofx.db.util;

public class SingletonDB {
    private static Conexao conexao;
    private SingletonDB() {

    }
    public static boolean conectar() {
        conexao = new Conexao();
        return conexao.conectar("jdbc:postgresql://localhost/","botecodb",
                               "postgres", "arcesti123");
    }
    public static Conexao getConexao() {
        return conexao;
    }
}
