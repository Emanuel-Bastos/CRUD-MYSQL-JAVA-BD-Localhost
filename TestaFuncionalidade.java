package com.petshop.tteste;

import java.sql.SQLException;

import com.petshop.dao.PetDAO;
import com.petshop.model.Pet;


public class TestaFuncionalidade {

    public static void main(String[] args) throws ClassNotFoundException {
        TestaFuncionalidade testeFunc = new TestaFuncionalidade();

        // Descomente a linha abaixo para inserir um pet
        //	testeFunc.testaInsercao();

        // Descomente a linha abaixo para deletar um pet
        //	testeFunc.testaExclusao();

        // Descomente a linha abaixo para atualizar um pet
         	testeFunc.testaAtualizacao();

        // Descomente a linha abaixo para listar todos os pets
         	testeFunc.testaSelecao();
    }

    public void testaInsercao() throws ClassNotFoundException {
        Pet pet = new Pet();
        pet.setNomeTutor("Alexandre");
        pet.setNomePet("Dog3");
        pet.setRaca("Viralata");
        pet.setTelefone("123456790");

        PetDAO dao = new PetDAO();
        try {
            dao.inserirPet(pet);
            System.out.println("Dado inserido no banco com sucesso");
        } catch (SQLException e) {
            System.out.println("Problemas na conexao com o banco de dados." + e);
        }
    }

    public void testaExclusao() throws ClassNotFoundException {
        PetDAO dao = new PetDAO();
        try {
            dao.deletarPet(4); // Supondo que queremos excluir o pet com ID 1
            System.out.println("Dado removido do banco com sucesso");
        } catch (SQLException e) {
            System.out.println("Problemas na conexao com o banco de dados." + e);
        }
    }

    public void testaAtualizacao() throws ClassNotFoundException {
        Pet pet = new Pet();
        pet.setId(2); // Supondo que queremos atualizar o pet com ID 3
        pet.setNomeTutor("Pedro Afonso");
        pet.setNomePet("DogAtualizado");
       

        PetDAO dao = new PetDAO();
        try {
            dao.atualizarPet(pet);
            System.out.println("Dado atualizado no banco com sucesso");
        } catch (SQLException e) {
            System.out.println("Problemas na conexao com o banco de dados." + e);
        }
    }

    public void testaSelecao() throws ClassNotFoundException {
        PetDAO dao = new PetDAO();
        try {
            for (Pet pet : dao.listarPets()) {
                System.out.println(pet);
            }
        } catch (SQLException e) {
            System.out.println("Problemas na conexao com o banco de dados." + e);
        }
    }
}
