package example.notification.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import example.notification.dto.Relation;

@Component
@Path("relations")
public class RelationResource extends AbstractResource {

	@GET
	@Path("{relationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Relation getRelation(@PathParam("relationId") Long relationId) throws Exception {
		return relationService.getRelation(relationId);
	}

}
