package pos.pdwm.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pos.pdwm.record.LoginUserRecord;


@Entity
@Table(name = "login", schema = "public")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;


    //Getters
    public int getIdUser() {
        return idUser;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }



    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LoginUser(){}//Constructor vazio - estudar uso do Lombok

    public LoginUser(LoginUserRecord dados){
        this.nome = dados.LoginNome();
        this.email = dados.LoginEmail();
        this.senha = dados.LoginSenha();
    }
    

}
