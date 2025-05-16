package Uebung3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

class User {
	private static int ID = 0;
	protected String _username;
	protected String _email;
	protected final int _id;
	
	public User(String username, String email) {
		assert (username != null);
		assert (email != null);
		
		this._username = username;
		this._email = email;
		this._id = ID++;
	}
	
	/**
	 * Get the username of this user. This will never be null!
	 */
	public String getUsername() {
		return this._username;
	}
	
	/**
	 * Get the email of this user. This will never be null!
	 */
	public String getEmail() {
		return this._email;
	}
	
	/**
	 * returns generated ID of this user
	 */
	public int getID() {
		return this._id;
	}
}

/** Eigener Code sollte niemals dazu führen, dass Exceptions geworfen werden → eigene Exceptions zu erstellen hier
 * 	fragwürdig (und Verwendung umgehbar) */

//class NoUsernameException extends RuntimeException {
//	public NoUsernameException() {
//		super("Not registered user has no username");
//	}
//}
//
//class NoEmailException extends RuntimeException {
//	public NoEmailException() {
//		super("Not registered user has no email");
//	}
//}

class NotRegisteredUser extends User {
	
	public NotRegisteredUser() {
		super("", "");
	}
	
	/** Siehe Kommentar Zeile 44 für Zeilen 68 und 74, "spezieller" User kann Methoden aus Superklasse erben,
	 * 	Rückgabewert an Konstruktor ablesbar */
	
	@Override
	public String getUsername() {
//		throw new NoUsernameException();
		return super.getUsername();
	}
	
	@Override
	public String getEmail() {
//		throw new NoEmailException();
		return super.getEmail();
	}
}

class EnterpriseUser extends User {
	private String _personalAssistant;
	
	/** this._email = null verstößt gegen Assertion in Zeile 15 (email != null) und ist durch Aufruf des Konstruktors
	 *  darüber in Zeile 85 mit "" als Parameter für email auch unsinnig */
	public EnterpriseUser(String username, String personalAssistant) {
		super(username, "");
//		this._email = null;
		this._personalAssistant = personalAssistant;
	}
	
	public String getPersonalAssistant() {
		return this._personalAssistant;
	}
}


public class Liskov {
	/** Siehe Kommentar Zeile 44, statt Exception zu werfen, darüber informieren, dass User keinen spezifischen Namen,
	 * 	aber in jedem Fall eine ID hat, unnötiger try-catch-Block mit möglichem Programmabbruch vermeidbar */
	public static void main(String[] args) {
		final Collection<User> users = new LinkedList<>();
		users.add(new EnterpriseUser("enterprise-customer", "CEO"));
		users.add(new User("max", "max.mustermann@mail.io"));
		users.add(new NotRegisteredUser());
		
		for (final User user : users) {
//			try {
//				System.out.println(user.getUsername() + " (" + user.getID() + ")");
//			} catch (NoUsernameException e) {
//				System.err.println("Cannot print user with ID " + user.getID());
//			}
			if (Objects.equals(user.getUsername(), "")) {
				System.out.println("The user has no username but the ID is " + user.getID() + ".");
			}
			else System.out.println("The username is " + user.getUsername() + " and the ID is " + user.getID() + ".");
		}
	}
}
