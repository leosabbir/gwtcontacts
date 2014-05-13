package com.home.server;


import java.util.List;

import com.home.server.entities.ContactDetailsEntity;
import com.home.server.service.IContactsService;
import com.home.shared.FieldVerifier;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;
import com.home.shared.services.IGreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class GreetingServiceImpl implements IGreetingService {

	private final IContactsService contactService;
	
	public GreetingServiceImpl(IContactsService contactService){
		this.contactService = contactService;
	}
	
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		ContactDetails test = new ContactDetails();
		test.setAddress("Hogwart");
		test.setMobile("017657686");
		test.setFirstName("Tom");
		//this.contactService.save(test);
		Object obj = this.contactService.findContact(1);
		//this.contactService.delete(3);
		List<ContactNameId> allContacts = this.contactService.getAllContacts();
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = "";//getServletContext().getServerInfo();
		String userAgent = "";//getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
