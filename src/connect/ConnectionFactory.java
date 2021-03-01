 
package connect;
import java.sql.Connection;
import java.sql.DriverManager;

// classe
public class ConnectionFactory {
    
    //  -- VAR
    
    private static final String username = "root";
    private static final String password = "1234";
    private static final String database_url = "jdbc:mysql://localhost:3306/crudjava?useSSL=false";
    
    
    
    
    // -- metodos
    
    
    // CONEXAO
    public static Connection createConnectionToMySql() throws Exception{
        
        // fazendo conexao
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(database_url,username,password);
         
        return conn;
    }
    
    
    
    
    // MAIN
    public static void main(String[] args) throws Exception{
        
        // pegando CONEXAO para msg
        Connection conn = createConnectionToMySql();
        
        if(conn != null){
            System.out.println("Conexão feita com sucesso");
            conn.close();
        }
    }
    
}



