package pos.pdwm.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    public Usuarios(){
    }

    public Usuarios(UsuarioRecord dados){
        this.nome = dados.CadastroNome();
        this.email = dados.CadastroEmail();
        this.telefone = dados.CadastroTelefone();
    }




    
}
