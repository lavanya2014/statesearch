package com.states.rest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@Path("/states")
public class StateSearchService {

	@GET
	@Path("/get/{searchStates:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStates(@PathParam("searchStates") String searchStates) {

		try {
			if (searchStates == null || "".equals(searchStates.trim())) {
				searchStates = "";
			}
			else
			{
				searchStates = searchStates.toUpperCase();
			}

			String statesText = ClientBuilder.newClient().target("http://services.groupkt.com/state/get/USA/all")
					.request().accept(MediaType.APPLICATION_JSON).get(String.class);

			JSONObject jsonObj = new JSONObject(statesText);
			List<String> inputs = Arrays.asList(searchStates.split(","));

			JSONArray statesArray = (JSONArray) ((JSONObject) jsonObj.get("RestResponse")).get("result");
			JSONObject[] finalStates = {};
			JSONArray responseArray = new JSONArray();

			if (searchStates.length() > 0) {
				finalStates = StreamSupport.stream(statesArray.spliterator(), false)
						.filter(state -> inputs.contains(((JSONObject) state).get("name").toString().toUpperCase())
								|| (inputs.contains(((JSONObject) state).get("abbr").toString().toUpperCase())))
						.toArray(JSONObject[]::new);
				for (JSONObject o : finalStates) {
					responseArray.put(o);
				}
			} else {
				responseArray = statesArray;
			}

			return Response.status(200).entity(responseArray.toString()).build();
		} catch (JSONException | NullPointerException ex) {
			return Response.status(200).entity("Uh Oh! unable to get states info, please try again.").build();
		}

	}

}