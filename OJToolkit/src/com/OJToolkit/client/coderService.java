package com.OJToolkit.client;


import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("coder")
public interface coderService extends RemoteService {
	public void addCoder(String username, String SPOJUsername, String SPOJPassword) throws NotLoggedInException;
	public ArrayList<CoderData> viewCoders() throws NotLoggedInException;
	public boolean checkRegistered() throws NotLoggedInException;  
	
	
}
