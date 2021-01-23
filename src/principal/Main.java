package principal;

import entities.Cliente;
import factories.ConnectionFactory;
import repositories.ClienteRepository;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			ConnectionFactory factory = new ConnectionFactory();
			
			ClienteRepository clienteRepository = new ClienteRepository(factory.getConnection());
			
			Cliente cliente = new Cliente(null, "Cintia", "cintiaalves.eng@gmail.com", "111.111.111-11");
			clienteRepository.create(cliente);
			
			System.out.println("Cliente cadastrado com sucesso!");
			
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
