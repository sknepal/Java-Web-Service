package org.relishnepal.relisnp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.relishnepal.relisnp.beans.State;
import org.relishnepal.relisnp.db.DBType;
import org.relishnepal.relisnp.db.DBUtil;

public class StateManager {
	public static List<State> displayAllRows() throws SQLException {
		List<State> list = new ArrayList<State>();
		String sql = "SELECT stateId, stateName FROM states";
				try(
						Connection conn = DBUtil.getConnection(DBType.MYSQL);
						Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = stmt.executeQuery(sql);
						) {
					while (rs.next()) {
						State state = new State();
						String stateId = rs.getObject("stateId", String.class);
						String stateName = rs.getObject("stateName", String.class);
						state.setStateId(stateId);
						state.setStateName(stateName);
						list.add(state);
						
					}
				} catch (SQLException e) {
					DBUtil.processException(e);
				} 
				
				return list;
		
	}
	
	public static State getRow(String stateId) throws SQLException {
	
		String sql = "SELECT * FROM states WHERE stateId = ?";
		ResultSet rs = null;
		
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setString(1, stateId);
			rs = stmt.executeQuery();
			
			if (rs.next()){
				State state = new State();
				state.setStateId(stateId);
				state.setStateName(rs.getObject("stateName", String.class));
				return state;
			}else{
				System.err.println("No rows were found.");
				return null;
				
			}		
			}catch(SQLException e){
			System.err.println(e);
			return null;
		}finally{
			if (rs != null){
				rs.close();
			}
		}
	}
	
	
	public static State insert(State state) throws SQLException {
		
		String sql = "INSERT INTO states (stateId, stateName) " + "VALUES (?, ?)";
		ResultSet keys = null;
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				){		
			stmt.setString(1, state.getStateId());
			stmt.setString(2, state.getStateName());
			}catch(SQLException e){
			System.err.println(e);
			return null;
		}finally{
			if (keys != null) keys.close();
		}
		return state;
	}
	
	public static State update(State state) throws SQLException {
		String sql = "UPDATE states SET " +
					"stateName = ? " +
					"WHERE stateId = ?";
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setString(1, state.getStateName());
			stmt.setString(2, state.getStateId());
			
			int affected = stmt.executeUpdate();
			System.out.println(affected);
			if (affected==1){
				return state;
			}else{
				return null;
			}
		}
		catch(SQLException e){
			System.err.println(e);
			return null;
		}
	
	}
	public static void delete(String stateId) throws SQLException {
		String sql = "DELETE FROM states WHERE stateId = ?";
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setString(1, stateId);
			int affected = stmt.executeUpdate();
			if (affected == 1){
				System.out.println("Deleted the row.");
			}else{
				System.out.println("Could not perform the delete operation.");
			}
		}
		catch(SQLException e){
			System.err.println(e);
		}
	}
}
