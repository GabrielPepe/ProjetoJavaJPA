
public class Teste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.setNome("João Silva");
		a1.setIdade(18);
		a1.setMatricula("123456789");
		
		AlunoController con = new AlunoController();
		
		con.salvar(a1);
		
	}

}
