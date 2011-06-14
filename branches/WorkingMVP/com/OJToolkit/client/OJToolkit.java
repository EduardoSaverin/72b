package com.OJToolkit.client;

import java.util.ArrayList;

import com.OJToolkit.client.Contents.ContentLogin;
import com.OJToolkit.client.Contents.ContentProblemList;
import com.OJToolkit.client.Contents.TestNorth;
import com.OJToolkit.client.Contents.TestWestUi;
import com.OJToolkit.client.Services.CoderService;
import com.OJToolkit.client.Services.CoderServiceAsync;
import com.OJToolkit.client.Services.LanguageService;
import com.OJToolkit.client.Services.LanguageServiceAsync;
import com.OJToolkit.client.Services.LoginService;
import com.OJToolkit.client.Services.LoginServiceAsync;
import com.OJToolkit.client.Services.SubmissionService;
import com.OJToolkit.client.Services.SubmissionServiceAsync;
import com.OJToolkit.client.ValueObjects.ProblemData;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@SuppressWarnings("unused")
public class OJToolkit implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();

		DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
		dockLayoutPanel.setSize("100%", "100%");
		rootPanel.add(dockLayoutPanel, 0, 0);

      /**
       * North panel
       */
		AbsolutePanel topPanel = new AbsolutePanel();
		dockLayoutPanel.addNorth(topPanel, 10);
		topPanel.setSize("100%", "100%");

      /**
       * West panel
       */
		AbsolutePanel leftPanel = new AbsolutePanel();
		dockLayoutPanel.addWest(leftPanel, 15);
		leftPanel.setSize("100%", "100%");

      /**
       * Center panel
       */
		AbsolutePanel core = new AbsolutePanel();
		dockLayoutPanel.add(core);
		
		
		SubmissionServiceAsync submissionService = GWT
		.create(SubmissionService.class);
		
		LanguageServiceAsync languageService = GWT
		.create(LanguageService.class);
		
		CoderServiceAsync coderService = GWT
		.create(CoderService.class);
		
		LoginServiceAsync loginService = GWT
		.create(LoginService.class);
		

		
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(eventBus, submissionService, languageService, loginService, coderService);
		appViewer.go(core,topPanel,leftPanel);
		
		
	

	}
}