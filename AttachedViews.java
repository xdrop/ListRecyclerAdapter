import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Attached views passed to a click listener in case they need to be updated
 */
public class AttachedViews {

    private Map<Integer,TextView> updateableText;
    private Map<Integer,View> generalViews;

    private ImageView imageView;


    public AttachedViews() {
        updateableText = new HashMap<>();
        generalViews = new HashMap<>();
    }

    /**
     * Get's a TextView based on the id assigned to it
     * @param id Id attached to the TextView requested
     * @return The TextView or null if no matching id found
     */
    public TextView getTextView(int id){
        return updateableText.get(id);
    }

    /**
     * Attach a TextView using an Id
     * @param id The TextView identifier
     * @param textView The TextView
     */
    public void attachTextView(int id,TextView textView){
        updateableText.put(id,textView);
    }


    /**
     * @return The assigned ImageView
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Attaches a (single) ImageView
     * @param imageView The ImageView to be attached
     */
    public void attachImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * Attach a View using an id
     * @param id The View identifier
     * @param view The View
     */
    public void attachView(int id,View view){
        generalViews.put(id,view);
    }

    /**
     * Get an attached View based on the id assigned to it
     * @param id The unique identifier
     * @return The View attached to the id or null if no matching id found
     */
    public View getView(int id){
        return generalViews.get(id);
    }
}
