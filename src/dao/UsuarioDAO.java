
package dao;
import com.mysql.jdbc.PreparedStatement;
import connect.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

// classe
public class UsuarioDAO {
    
    // -- metodos
    
    public Boolean save(Usuario usuario){
        // query
        String sql = "INSERT INTO usuario(nome,idade) VALUES (?,?)";
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        int exec = 0;
        Boolean msg = false;
        try{
            //conexao
            conn = ConnectionFactory.createConnectionToMySql();
            //preparando
            pstmt =  (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,usuario.getNome());//bind 1
            pstmt.setInt(2,usuario.getIdade());// bind 2
            
            // execute
            exec = pstmt.executeUpdate();
            
            if(exec > 0){
                msg = true;
            }else{
                msg = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();// erro
        }finally{
            // close connect
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        
        return msg;
        
    }
    //
    public List<Usuario> getAll() throws SQLException{
        
        // query
        String sql = "SELECT * FROM usuario";
        
        // var -usuario_dados
        List<Usuario> usuario_dados = new ArrayList<Usuario>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try{
            // conexao
            conn = connect.ConnectionFactory.createConnectionToMySql();
            // preparando
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            // array do resultado
            rset = pstmt.executeQuery();
            
            while(rset.next()){// passando valores para var(usuario_dados)
                
                Usuario usuario = new Usuario();// objeto
                
                usuario.setId(rset.getInt("id") );// id
                usuario.setNome(rset.getString("nome"));// nome
                usuario.setIdade(rset.getInt("idade"));// idade
                
                usuario_dados.add(usuario);// adiciona na variavel (array)
            }
            
        }catch(Exception e){// erro
            e.printStackTrace();
        }finally{
            
            if(conn!= null){
                conn.close();
            }
            if(pstmt!= null){
                pstmt.close();
            }
            if(rset!= null){
                rset.close();
            }
        }
        
        return usuario_dados;// retorna array 
        
    }
    
    public Boolean update(int id,String nome,int idade) throws Exception{
        // query
        String sql = "UPDATE usuario SET nome = ?,idade = ? WHERE id = ?";
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        int exec = 0;
        Boolean msg = false;
        try{
            // conexao
            conn = connect.ConnectionFactory.createConnectionToMySql();
            // preparando
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,nome);// bind 1
            pstmt.setInt(2,idade);// bind 2
            pstmt.setInt(3,id);// bind 3
            
            // execução (boolean)
            exec = pstmt.executeUpdate();
            
            if(exec > 0){
                msg = true;
            }else{
                msg = false;
            }
            
            
        }catch(Exception e){// erro
            e.printStackTrace();
        }finally{
            
            if(conn!= null){
                conn.close();
            }
            if(pstmt!= null){
                pstmt.close();
            }
            
        }
        
        // mensagem de exclusao

        return msg;
        
    
    }
    
    public Boolean delete(int id) throws Exception{
        // query
        String sql = "DELETE FROM usuario WHERE id = ?";
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        int exec = 0;
        Boolean msg = false;
        try{
            // conexao
            conn = connect.ConnectionFactory.createConnectionToMySql();
            // preparando
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1,id);// bind 1
            
            // execução (boolean)
            exec = pstmt.executeUpdate();
            
            if(exec > 0){
                msg = true;
            }else{
                msg = false;
            }
            
            
        }catch(Exception e){// erro
            e.printStackTrace();
        }finally{
            
            if(conn!= null){
                conn.close();
            }
            if(pstmt!= null){
                pstmt.close();
            }
            
        }
        
        // mensagem de exclusao

        return msg;
        
    }
}
