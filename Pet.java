package com.petshop.model;

public class Pet {
    private Integer id;
    private String nomeTutor;
    private String nomePet;
    private String raca;
    private String telefone;

    // Construtor vazio
    public Pet() {
    }

    // Construtor com parâmetros
    public Pet(Integer id, String nomeTutor, String nomePet, String raca, String telefone) {
        this.id = id;
        this.nomeTutor = nomeTutor;
        this.nomePet = nomePet;
        this.raca = raca;
        this.telefone = telefone;
    }

    // Getter e Setter para o ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter e Setter para o Nome do Tutor
    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    // Getter e Setter para o Nome do Pet
    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    // Getter e Setter para a Raça
    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    // Getter e Setter para o Telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método toString para exibir informações do objeto
    @Override
    public String toString() {
        return "Pet [id=" + id + ", nomeTutor=" + nomeTutor + ", nomePet=" + nomePet + ", raca=" + raca
                + ", telefone=" + telefone + "]";
    }
}
