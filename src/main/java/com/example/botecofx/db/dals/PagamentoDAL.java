package com.example.botecofx.db.dals;

import com.example.botecofx.db.entidades.Pagamento;
import com.example.botecofx.db.util.IDAL;
import com.example.botecofx.db.util.SingletonDB;

import java.util.List;

public class PagamentoDAL implements IDAL<Pagamento> {

    @Override
    public boolean gravar(Pagamento entidade) {
        return false;
    }

    @Override
    public boolean alterar(Pagamento entidade) {
        return false;
    }

    @Override
    public boolean apagar(Pagamento entidade) {
        return false;
    }

    @Override
    public Pagamento get(int id) {
        return null;
    }

    @Override
    public List<Pagamento> get(String filtro) {
        return List.of();
    }
}
