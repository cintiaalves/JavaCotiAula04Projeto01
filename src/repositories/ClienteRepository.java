package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import interfaces.IClienteRepository;


public class ClienteRepository implements IClienteRepository {
	
	private Connection connection;
	
	public ClienteRepository(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(Cliente cliente) throws Exception {
		
		String query = "insert into cliente values(null, ?, ?, ?)";
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, cliente.getNome());
		statement.setString(2,  cliente.getEmail());
		statement.setString(3,  cliente.getCpf());
		statement.execute();
		statement.close();
		
		
	}

	@Override
	public void update(Cliente cliente) throws Exception {
		
		String query = "update cliente set nome  = ?, email = ?, cpf = ? where idcliente = ?";
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setInt(4, cliente.getIdCliente());
		statement.execute();
		statement.close();
		
	}

	@Override
	public void delete(Cliente cliente) throws Exception {
		
		String query = "delete from cliente where idcliente = ?";
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();
		statement.close();
		
		
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		
		String query = "select * from cliente";
		
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		while(result.next()) {
			
			Cliente cliente = new Cliente();
			
			cliente.setIdCliente(result.getInt("idcliente"));
			cliente.setNome(result.getString("nome"));
			cliente.setEmail(result.getString("email"));
			cliente.setCpf(result.getString("cpf"));
			
			lista.add(cliente);
			
			
		}
		
		return lista;
	}
	
	
	
	

}
