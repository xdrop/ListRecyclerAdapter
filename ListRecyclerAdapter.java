import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;


public abstract class ListRecyclerAdapter<T,E extends ListRecyclerAdapter.ViewHolder> extends
        RecyclerView.Adapter<E> {

    private List<T> mDataSet = new ArrayList<>();
    private static ItemClickListener itemClickListener;

    public void addAll(final List<T> elements){
        mDataSet.addAll(elements);
        notifyDataSetChanged();
    }

    public void clear() {
        mDataSet.clear();
        notifyDataSetChanged();
    }

    protected static ItemClickListener getItemClickListener(){
        return itemClickListener;
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setItemClickListener(ItemClickListener<T> itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public static class ViewHolder<T> extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private T item;
        private AttachedViews attachedViews = new AttachedViews();
        public ViewHolder(View v) {
            super(v);
        }

        public void setItem(T item) {
            this.item = item;
        }

        protected AttachedViews getAttachedViews(){
            return attachedViews;
        }

        @Override
        public void onClick(View v) {
            getItemClickListener().onItemClick(item,getAdapterPosition(),v,attachedViews);
        }
    }

    public interface ItemClickListener<T> {

    /**
     * Called when an item is clicked
     * @param item An instance of the item clicked data source
     * @param position Position of item in the adapter
     * @param clickedView The clicked view
     * @param attachedViews Any attached views that might need to be updated
     */
    void onItemClick(T item, int position, View clickedView,AttachedViews attachedViews);

    /**
     * Called when an item is long clicked
     * @param item An instance of the item clicked data source
     * @param position Position of item in the adapter
     * @param clickedView The clicked view
     * @param attachedViews Any attached views that might need to be updated
     */
    void onItemLongClick(T item, int position, View clickedView,AttachedViews attachedViews);

	}

}
