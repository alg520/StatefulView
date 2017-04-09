package uk.co.jamiecruwys.interfaces;

import android.support.annotation.NonNull;

import uk.co.jamiecruwys.State;

/**
 * Contract for transitioning between states
 */
public interface StateChange
{
	/**
	 * Sets the new view state to transition to
	 * @param state which it is transitioning to
	 */
	void setState(@NonNull State state);
}