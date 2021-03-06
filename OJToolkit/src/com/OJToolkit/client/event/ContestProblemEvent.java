/**
 * 
 */
package com.OJToolkit.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author 72B
 *         Apr 26, 2011
 */
public class ContestProblemEvent extends GwtEvent<ContestProblemEventHandler> {

	public static Type<ContestProblemEventHandler> TYPE = new Type<ContestProblemEventHandler>();

	public ContestProblemEvent() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public Type<ContestProblemEventHandler> getAssociatedType() {

		return TYPE;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared
	 * .EventHandler)
	 */

	@Override
	protected void dispatch(ContestProblemEventHandler handler) {
		handler.onContestProblems(this);
		
	}

}
