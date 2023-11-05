package Emailer;
import java.util.Scanner;
import java.util.ArrayList;

public class Email {
	
	private String subject;
	private String body;
	private ArrayList<String> recepients;
	private boolean sent;
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public ArrayList<String> getRecepients() {
		return recepients;
	}

	public void setRecepients(ArrayList<String> recepients) {
		this.recepients = recepients;
	}

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public Email(String subject, String body, ArrayList<String> recepients, boolean sent) {
		this.subject = subject;
		this.body = body;
		this.recepients = recepients;
		this.sent = sent;
	}
	
	public Email() {
		this.subject = "";
		this.body = "";
		this.recepients = null;
		this.sent = false;
	}
	
	public Email(String subject, String body, ArrayList<String> recepients) {
		this.subject = subject;
		this.body = body;
		this.recepients = recepients;
		this.sent = false;
	}

	@Override
	public String toString() {
		String recipientString = "";
		for(String recipient : recepients) {
			recipientString += recipient;
		}
		String status = "not sent";
		if(sent) {
			status = "sent";
		}
		return String.format("To:\t%s\nSubject:\t%s\nStatus:\t%s\nBody:\t%s\n",recipientString, subject, status, body );
	}

	public void send() {
			sent = true;
		}
	public String toFileFriendlyString() {
		String recipientString = "";
		for(String recipient : recepients) {
			recipientString += recipient;
		}
		String status = "not sent";
		if(sent) {
			status = "sent";
		}
		return String.format("%s\t%s\t%s\t%s\n",recipientString, subject, body,status);
	}
}
