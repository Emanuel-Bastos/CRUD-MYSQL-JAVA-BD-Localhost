package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.petshop.model.Pet;
import DatabaseConnection.Conexao;


public class PetDAO {
    // Método para inserir um novo Pet no banco de dados
    public void inserirPet(Pet pet) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conector();
            String sql = "INSERT INTO cadastro_clientes_pets (nome_tutor, nome_pet, raca, telefone) VALUES (?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, pet.getNomeTutor());
            stmt.setString(2, pet.getNomePet());
            stmt.setString(3, pet.getRaca());
            stmt.setString(4, pet.getTelefone());

            stmt.executeUpdate();
            System.out.println("Dado inserido no banco com sucesso");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    // Método para deletar um Pet do banco de dados com base no ID
    public void deletarPet(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conector();
            String sql = "DELETE FROM cadastro_clientes_pets WHERE id = ?";
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Dado removido do banco com sucesso");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    // Método para atualizar informações de um Pet no banco de dados
    public void atualizarPet(Pet pet) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conector();
            String sql = "UPDATE cadastro_clientes_pets SET nome_tutor = ?, nome_pet = ?, raca = ?, telefone = ? WHERE id = ?";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, pet.getNomeTutor());
            stmt.setString(2, pet.getNomePet());
            stmt.setString(3, pet.getRaca());
            stmt.setString(4, pet.getTelefone());
            stmt.setInt(5, pet.getId());

            stmt.executeUpdate();
            System.out.println("Dado atualizado no banco com sucesso");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    // Método para listar todos os Pets do banco de dados
    public List<Pet> listarPets() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pet> listaDePets = new ArrayList<>();

        try {
            conexao = Conexao.conector();
            String sql = "SELECT * FROM cadastro_clientes_pets";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setNomeTutor(rs.getString("nome_tutor"));
                pet.setNomePet(rs.getString("nome_pet"));
                pet.setRaca(rs.getString("raca"));
                pet.setTelefone(rs.getString("telefone"));

                listaDePets.add(pet);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }

        return listaDePets;
    }
}
