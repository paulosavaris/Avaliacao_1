package pos.pdwm.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pos.pdwm.dto.UsuariosDTO;
import pos.pdwm.record.UsuarioRecord;

@Entity
@Table(name = "usuarios", schema = "public")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    //Getters
    public int getId() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }



    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuarios(){
    }

    public Usuarios(UsuarioRecord dados){
        this.nome = dados.CadastroNome();
        this.email = dados.CadastroEmail();
        this.telefone = dados.CadastroTelefone();
    }


    public boolean isEqual(UsuariosDTO form) {//para comparar se os campos da entidade são iguais aos campos do objeto TarefasDTO
        return Objects.equals(this.nome, form.getUserNomeEdit()) &&
        Objects.equals(this.email, form.getUserEmailEdit()) &&
        Objects.equals(this.telefone, form.getUserTelefoneEdit());
    }


}
