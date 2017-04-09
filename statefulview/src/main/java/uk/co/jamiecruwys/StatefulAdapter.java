package uk.co.jamiecruwys;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import uk.co.jamiecruwys.contracts.ViewStateChange;

/**
 * A {@link android.support.v7.widget.RecyclerView.Adapter} that can update a {@link StatefulView} using a callback.
 * To use, you must call {@link #registerStatefulDataObserver()} to register and {@link #unregisterStatefulDataObserver()} to unregister.
 * This is done in the same way that you would use {@link #registerAdapterDataObserver(RecyclerView.AdapterDataObserver)} and {@link #unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver)}
 */
public abstract class StatefulAdapter<VH extends ViewHolder> extends RecyclerView.Adapter<VH>
{
	@NonNull private ViewStateChange callback;

	private RecyclerView.AdapterDataObserver statefulDataObserver = new RecyclerView.AdapterDataObserver()
	{
		@Override public void onChanged()
		{
			super.onChanged();

			if (getItemCount() == 0)
			{
				callback.setViewState(ViewState.EMPTY);
			}
			else
			{
				callback.setViewState(ViewState.LOADED);
			}
		}
	};

	public StatefulAdapter(@NonNull ViewStateChange callback)
	{
		this.callback = callback;
	}

	/**
	 * Register a new stateful observer to listen for data changes that will change the view state
	 */
	public void registerStatefulDataObserver()
	{
		registerAdapterDataObserver(statefulDataObserver);
	}

	/**
	 * Unregister a stateful observer currently listening for data changes that will change the view state
	 */
	public void unregisterStatefulDataObserver()
	{
		unregisterAdapterDataObserver(statefulDataObserver);
	}
}