package principal;

import java.util.ArrayList;
import java.util.List;

import principal.daos.EmpresaDAO;
import principal.daos.LojaDAO;
import principal.models.Empresa;
import principal.models.Loja;

public class Programa {
	
	public static void main(String[] args) {
		
		Empresa e1 = new Empresa();			
		e1.setCNPJ("444444");
		e1.setNome("Ppeita");
		
		EmpresaDAO edao = new EmpresaDAO();
		edao.salvar(e1);		
		
				
		Loja l1 = new Loja();		
		l1.setCNPJ("55555555");
		l1.setEmpresa(e1);
				
		Loja l2 = new Loja();		
		l2.setCNPJ("66666666");
		l2.setEmpresa(e1);
				
		LojaDAO lojadao = new LojaDAO();		
		lojadao.salvar(l1);
		lojadao.salvar(l2);
		
		
		List<Loja> lojas = new ArrayList<>();
		lojas.add(l1);
		lojas.add(l2);
		
		e1.setLojas(lojas);
		edao.atualizar(e1);		
		
		
	}
}
