package biblioteca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Column;

@Entity
public class Emprestimo implements Serializable{

    private static final long serialVersionUID = 1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @Column
    private Date dataEmprestimo;
    @Column
    private Date dataDevolucao;


    public Emprestimo(int id, User user, Livro livro, Date dataEmprestimo, Date dataDevolucao) {
        this.id = id;
        this.user = user;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }


    public int getId() {
        return id;
    }



    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }


    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }


    public Date getDataDevolucao() {
        return dataDevolucao;
    }


    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    
}
