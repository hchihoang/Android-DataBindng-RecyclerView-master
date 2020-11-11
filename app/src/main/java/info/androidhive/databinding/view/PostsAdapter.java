package info.androidhive.databinding.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import info.androidhive.databinding.R;
import info.androidhive.databinding.databinding.PostRowItemBinding;
import info.androidhive.databinding.model.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private List<Post> postList;
    private LayoutInflater layoutInflater;
   // private PostsAdapterListener listener;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final PostRowItemBinding binding;

        public MyViewHolder(final PostRowItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


    public PostsAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
       // this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        PostRowItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.binding.setPost(postList.get(position));
        final Post post = postList.get(position);
        holder.binding.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Post clicked! " + post.getImageUrl(), Toast.LENGTH_SHORT).show();
//                if (listener != null) {
//                    listener.onPostClicked(postList.get(position));
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

//    public interface PostsAdapterListener {
//        void onPostClicked(Post post);
//    }
}
