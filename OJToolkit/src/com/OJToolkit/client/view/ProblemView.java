/**
 * 
 */
package com.OJToolkit.client.view;

import java.util.ArrayList;

import com.OJToolkit.client.ValueObjects.LanguageData;
import com.OJToolkit.client.ValueObjects.ProblemData;
import com.OJToolkit.client.presenter.ProblemPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author 72B Apr 26, 2011
 */
public class ProblemView extends Composite implements ProblemPresenter.Display {

	private final Button btnSubmit;
	VerticalPanel verticalPanel;
	TextBox lblPrblmTitle;
	ListBox comboBox;
	TextArea txtCode;
	Frame problemStatementFrame;

	public ProblemView() {
		ScrollPanel scrollPanel = new ScrollPanel();
		initWidget(scrollPanel);
		verticalPanel = new VerticalPanel();
		verticalPanel.setSize("100%", "100%");
		scrollPanel.setSize("100%", "100%");
		scrollPanel.add(verticalPanel);

		Label lblNewLabel = new Label("Problem Title: ");
		verticalPanel.add(lblNewLabel);

		lblPrblmTitle = new TextBox();
		lblPrblmTitle.setReadOnly(true);
		verticalPanel.add(lblPrblmTitle);

		// error here with frame
		problemStatementFrame = new Frame();

		verticalPanel.add(problemStatementFrame);

		Label lblNewLabel_1 = new Label("Code");
		verticalPanel.add(lblNewLabel_1);

		txtCode = new TextArea();
		verticalPanel.add(txtCode);
		txtCode.setSize("90%", "300px");

		Label lblLanguage = new Label("Language");
		verticalPanel.add(lblLanguage);

		comboBox = new ListBox();

		verticalPanel.add(comboBox);

		btnSubmit = new Button("Submit");
		verticalPanel.add(btnSubmit);
		btnSubmit.setSize("100px", "28px");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.OJToolkit.client.presenter.ProblemPresenter.Display#getSubmitButton()
	 */
	@Override
	public HasClickHandlers getSubmitButton() {
		return btnSubmit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.OJToolkit.client.presenter.ProblemPresenter.Display#setProblem(com
	 * .OJToolkit.client.ValueObjects.ProblemData)
	 */
	@Override
	public void setProblem(ProblemData problem) {
		problemStatementFrame.setUrl(problem.getUrl());

		problemStatementFrame.setSize("90%", "300px");

		lblPrblmTitle.setText(problem.getProblemName());
		String addedAccountsCookie = Cookies.getCookie("addedAccountsCookie");
		if(!addedAccountsCookie.contains(problem.getOjType())){
			txtCode.setVisible(false);
			btnSubmit.setVisible(false);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.OJToolkit.client.presenter.ProblemPresenter.Display#setLanguages(
	 * java.util.ArrayList)
	 */
	@Override
	public void setLanguages(ArrayList<LanguageData> languages) {
		for (int i = 0; i < languages.size(); i++)
			comboBox.addItem(languages.get(i).getLanguageName(),
					languages.get(i).getLanguageValue());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.OJToolkit.client.presenter.ProblemPresenter.Display#getCode()
	 */
	@Override
	public String getCode() {
		return txtCode.getText();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.OJToolkit.client.presenter.ProblemPresenter.Display#getProblemCode()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.OJToolkit.client.presenter.ProblemPresenter.Display#
	 * getSelectedLanguageValue()
	 */
	@Override
	public String getSelectedLanguageValue() {
		return comboBox.getValue(comboBox.getSelectedIndex());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.OJToolkit.client.presenter.ProblemPresenter.Display#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this;
	}

}
