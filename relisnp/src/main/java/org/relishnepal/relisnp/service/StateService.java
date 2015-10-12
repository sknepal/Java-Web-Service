package org.relishnepal.relisnp.service;


import java.sql.SQLException;
import java.util.List;

import org.relishnepal.relisnp.beans.State;
import org.relishnepal.relisnp.model.StateManager;

public class StateService {
	public List<State> getAllMessages() throws SQLException{
		return StateManager.displayAllRows();
	}
	
	public State getMessage(String stateId) throws SQLException{
		return StateManager.getRow(stateId);
	}
	
	public State addMessage(State state) throws SQLException{
		return StateManager.insert(state);
	}
	
	public State updateMessage(State state) throws SQLException{
		return StateManager.update(state);
	}
	
	public void deleteMessage(String stateId) throws SQLException{
		 StateManager.delete(stateId);
	}
}
