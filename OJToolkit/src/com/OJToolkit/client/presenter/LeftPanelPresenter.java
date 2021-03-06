package com.OJToolkit.client.presenter;

import com.OJToolkit.client.view.LeftPanelView;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LeftPanelPresenter implements Presenter {
	public interface Display {
		Widget asWidget();
		void setEnabled(boolean isEnabled);
		void setSelected(LeftPanelView.Labels labelName);
	}

	private final Display display;

	public LeftPanelPresenter(final Display display) {
		this.display = display;
		String isEnabledCookie = Cookies.getCookie("isEnabledCookie");
		if (isEnabledCookie != null) {
			display.setEnabled(true);
		}
		else{
			display.setEnabled(false);
		}
		bind();
	}
	
	public void setSelected(LeftPanelView.Labels labelName) {
		this.display.setSelected(labelName);
	}
      
	private void bind() {
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
}
