package biblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private String autor;
    @Column
    private String editora;
    

    public Livro(int id, String titulo, String autor, String editora){
        id = this.id;
        titulo = this.titulo;
        autor = this.autor;
        editora = this.editora;
    }


    public int getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getEditora() {
        return editora;
    }


    public void setEditora(String editora) {
        this.editora = editora;
    }

    
}
