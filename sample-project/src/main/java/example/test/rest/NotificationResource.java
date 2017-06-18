package example.test.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import example.test.dto.Notification;

@Component
@Path("crm")
public class NotificationResource extends AbstractResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotification(@QueryParam("notificationId") long notificationId) throws Exception {
		Notification notifications = notificationService.getNotification(notificationId);
		return Response.status(Response.Status.OK).entity(notifications).build();

	}

}
