
package aplicacao;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Usuario;

public class Main{// classe
    // -- metodos
    public static void main(String[] args) throws SQLException, Exception{
        
        // objetos
        Scanner scan = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario1 = new Usuario();
        
        // var
        int escolha;
        
        
        // interface 
        while(true){
        
        System.out.println(" **** Usuarios do Banco de dados **** ");
        
            System.out.println("\n Escolha uma das opções abaixo: \n\n"+
            " 1 - Listar todos os usuario \n 2 - Criar usuario \n "
            +"3 - Deletar usuario \n 4 - Editar usuario \n 5 - Sair do programa ");
            
           // entrada escolha
           System.out.print("\n\n Input: ");
           escolha = scan.nextInt();
           
           
           
        switch(escolha){
             case 1:
                 // read        
                 for(Usuario usu : usuarioDAO.getAll()){
                     System.out.println(" Id: "+ usu.getId());
                     System.out.println(" Nome: "+ usu.getNome());
                     System.out.println(" Idade: "+ usu.getIdade()+"\n");
                 }
                 
                 
                break;

             case 2:
                 // var
                 String nome;
                 int idade;


                 System.out.print(" Qual o nome do usuario : ");
                 nome = scan.next();

                 System.out.print("Qual a idade do usuario: ");
                 idade = scan.nextInt();

                 // create
                 usuario1.setIdade(idade);
                 usuario1.setNome(nome);

                 if(usuarioDAO.save(usuario1)){
                     System.out.println("\n\nCriado com sucesso");
                 }else{
                     System.out.println("\n\n Erro ao criar \n Verifique se as informações colocadas estão corretas\n");
                 }



                break;

             case 3:
                 // var
                 int id;

                 System.out.print(" Digite o ID do Usuario que deseja deletar: ");
                 id = scan.nextInt();

                 // delete
                 if(usuarioDAO.delete(id) != true){
                     System.out.println("\n\nErro ao deletar \n Verifique se as informações colocadas estão corretas\n");
                 }else{
                     usuarioDAO.delete(id);
                     System.out.println("\n\nDeletado com sucesso\n");
                 }

                break;

             case 4:

                 System.out.print(" Digite o ID do Usuario que deseja Atualizar: ");
                 id = scan.nextInt();

                 System.out.print(" Digite o Novo nome: ");
                 nome = scan.next();

                 System.out.print(" Digite a Nova idade: ");
                 idade = scan.nextInt();

                 // update
                 if(usuarioDAO.update(id,nome,idade) != true){
                     System.out.println(" \n\n Erro ao atualizar \n Verifique se as informações colocadas estão corretas\n");
                 }else{
                     usuarioDAO.update(id,nome,idade);
                     System.out.println("\n\n Atualizado com sucesso\n");
                 }
                break;

             case 5:
                 // sair
                 System.out.println("\n\n Programa finalizado\n");
                 System.exit(0);
                 break;
             default:
                 System.out.println("\n\n Opção Invalida. Tente novamente\n");
        }
        
        
        
        
        
        
            // ??
             String escolha2;
             System.out.print("-----------------------------------\n Deseja continuar ? \n S ou N : ");
             escolha2 = scan.next();
             
             switch(escolha2){
                case "S":
                    break;
                case "s":
                    break;
                case "N":
                    System.exit(0);
                    break;
                case "n":
                  System.exit(0);
                  break;
                             
             }
        }
    }
}