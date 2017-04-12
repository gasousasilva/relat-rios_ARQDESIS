package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ItemPedido_Beans.ItemPedido;

public class PedidoDAO {
	//INCLUIR
		public void incluir(ItemPedido p) {   
			String sqlInsert = "INSERT INTO pedido(id_pedido, nome_pedido, nome_produto,qtde_produto, valor_produto) VALUES (?, ?, ?,?,?)";     
			try (Connection conn = ConnectionFactory.obtemConexao();     
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {    
				stm.setInt(1, p.getId());    
				stm.setString(2, p.getPedido());    
				stm.setString(3, p.getProduto());
				stm.setInt(4, p.getQtde()); 
				stm.setString(5, p.getValor()); 
				stm.execute();   
				} catch (SQLException e) {   
					e.printStackTrace();   
			}  
		}
		
		//ATUALIZAR
		public void atualizar(ItemPedido p) {   
			String sqlUpdate = "UPDATE pedido SET nome_pedido=?, nome_produto=?,qtde_produto=?, valor_produto=? WHERE id_pedido=?";      
			try (Connection conn = ConnectionFactory.obtemConexao();     
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {    
					stm.setInt(1, p.getId());    
					stm.setString(2, p.getPedido());    
					stm.setString(3, p.getProduto());
					stm.setInt(4, p.getQtde()); 
					stm.setString(5, p.getValor());   
					stm.execute();   
					} catch (Exception e) {    
						e.printStackTrace();   }  
			} 
		
		//EXCLUIR
		public void excluir(ItemPedido p) {   
			String sqlDelete = "DELETE FROM pedido WHERE id_pedido = ?";    
			try (Connection conn = ConnectionFactory.obtemConexao();     
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {    
				stm.setInt(1, p.getId());    
				stm.execute();   
				} catch (Exception e) {    
					e.printStackTrace();   
				}  
			} 
		
		//CARREGAR
		public ItemPedido carregar(ItemPedido p) {   
			//ItemPedido p = new ItemPedido();   
			String sqlSelect = "SELECT nome_pedido, nome_produto, qtde_produto, valor_produto FROM pedido WHERE id_pedido = ?";    
			try (Connection conn = ConnectionFactory.obtemConexao();     
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {    
					stm.setInt(1, p.getId());    
					try (ResultSet rs = stm.executeQuery();) {     
						if (rs.next()) {      
							p.setPedido(rs.getString("nome_pedido"));      
							p.setProduto(rs.getString("nome_produto")); 
							p.setQtde(rs.getInt("qtde_produto")); 
							p.setValor(rs.getString("valor_produto")); 
							}    
						} catch (SQLException e) {     
							e.printStackTrace();    }  
					} catch (SQLException e1) {    
						System. out .print(e1.getStackTrace());  
						}   return p;  
					}
}
