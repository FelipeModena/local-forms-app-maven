package modena.matricula.db.entity;

public class MatriculaEntity {

    public String nomeCompletoEstudante;
    public int idadeEstudante;
    public String emailEstudante;
    public String enderecoEstudante;
    public String cepEstudante;
    public String telefoneEstudante;
    public String userEstudante; // username e PK no banco
    public String senhaEstudante;
    public String cursoEstudante;
    public String observacao;
    public boolean ativo = false;

    public MatriculaEntity(String nomeCompletoEstudante, int idadeEstudante, String emailEstudante,
            String enderecoEstudante, String cepEstudante, String telefoneEstudante, String userEstudante,
            String senhaEstudante, String cursoEstudante, String observacao, boolean ativo) {
        this.nomeCompletoEstudante = nomeCompletoEstudante;
        this.idadeEstudante = idadeEstudante;
        this.emailEstudante = emailEstudante;
        this.enderecoEstudante = enderecoEstudante;
        this.cepEstudante = cepEstudante;
        this.telefoneEstudante = telefoneEstudante;
        this.userEstudante = userEstudante;
        this.senhaEstudante = senhaEstudante;
        this.cursoEstudante = cursoEstudante;
        this.observacao = observacao;
        this.ativo = ativo;
    }

    public MatriculaEntity() {

    }

}
