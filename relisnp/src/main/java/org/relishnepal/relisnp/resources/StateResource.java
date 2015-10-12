package org.relishnepal.relisnp.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.relishnepal.relisnp.beans.State;
import org.relishnepal.relisnp.service.StateService;

@Path("/states")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StateResource {
	StateService statesService = new StateService();
	
	@GET
	public List<State> getMessages() throws SQLException{
		return statesService.getAllMessages();
	}
	
	@POST
	public State addMessage(State state) throws SQLException{
		return statesService.addMessage(state);
	}
	
	@PUT
	@Path("/{stateId}")
	public State updateMessage(@PathParam("stateId") String stateId, State state) throws SQLException{
		state.setStateId(stateId);
		return statesService.updateMessage(state);
	}
	
	@GET
	@Path("/{stateId}")
	public State getMessage(@PathParam("stateId") String stateId) throws SQLException{
		return statesService.getMessage(stateId);
	}
	
	@DELETE
	@Path("/{stateId}")
	public void deleteMessage(@PathParam("stateId") String stateId) throws SQLException{
		statesService.deleteMessage(stateId);
	}
	
}
