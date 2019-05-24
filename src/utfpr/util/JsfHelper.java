package utfpr.util;

import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class JsfHelper {

	public static long getId(String parameterName) {
		long value = -1;
		String valueText = (String) FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get(parameterName);
		try {
			Long id = new Long(valueText);
			value = id.longValue();
		} catch (NumberFormatException e) {
			throw new RuntimeException("couldn't parse '" + parameterName + "'='" + valueText + "' as a long");
		}
		return value;
	}

	public static void addMessage(String message) {
		if (message != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		}
	}

	public static void setSessionAttribute(String key, Object value) {
		final Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			sessionMap.put(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getSessionAttribute(String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}

	public static void removeSessionAttribute(String key) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
	}

	public static String getParameter(String name) {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}
	
	public static HttpSession getHttpSession() {
		FacesContext facescontext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facescontext.getExternalContext().getSession(true);
		return session;
	}
		
	public static void addErrorMessage(String message) {
		if (message != null) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, facesMsg);
		}
	}
	  
	public static void addInfoMessage(String message) {
		if (message != null) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, facesMsg);
		} 
	}
	
	public static void addWarningMessage(String message) {
		if (message != null) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, facesMsg);
		}
	}

	public static void resetMessages() {
		FacesContext context = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> iter = context.getMessages();
		while (iter.hasNext()) {
			iter.next();
			iter.remove();
		}
	}
	
}