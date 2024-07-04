/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.model;

import java.util.Date;

public class Hospede {
    
    private int id_hospede;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Date dataNascimento;
    private String endereco;

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the id_hospede
     */
    public int getId_hospede() {
        return id_hospede;
    }

    /**
     * @param id_hospede the id_hospede to set
     */
    public void setId_hospede(int id_hospede) {
        this.id_hospede = id_hospede;
    }
    
    
    
    

    
}