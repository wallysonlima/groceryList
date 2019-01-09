package wallyson.lima.grocerylist.UI;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import wallyson.lima.grocerylist.Activities.DetailsActivity;
import wallyson.lima.grocerylist.Model.Grocery;
import wallyson.lima.grocerylist.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
     private Context context;
     private List<Grocery> groceryItems;

    public RecyclerViewAdapter(Context context, List<Grocery> groceryItems) {
        this.context = context;
        this.groceryItems = groceryItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Grocery grocery = groceryItems.get(position);

        holder.groceryItemName.setText(grocery.getName());
        holder.quantity.setText(grocery.getQuantity());
        holder.dateAdded.setText(grocery.getDateItemAdded());
    }

    @Override
    public int getItemCount() {
        return groceryItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView groceryItemName, quantity, dateAdded;
        public Button editButton, deleteButton;
        public int id;

        public ViewHolder(@NonNull View view, Context ctx) {
            super(view);

            context = ctx;

            groceryItemName = view.findViewById(R.id.name);
            quantity = view.findViewById(R.id.quantity);
            dateAdded = view.findViewById(R.id.dateAdded);

            editButton = view.findViewById(R.id.editButton);
            deleteButton = view.findViewById(R.id.deleteButton);

            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // go to next screen DetailsActivity
                    int position = getAdapterPosition();

                    Grocery grocery = groceryItems.get(position);
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("name", grocery.getName());
                    intent.putExtra("quantity", grocery.getQuantity());
                    intent.putExtra("date", grocery.getId());
                    intent.putExtra("date", grocery.getDateItemAdded());
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.editButton:
                    break;

                case R.id.deleteButton:
                    break;
            }
        }
    }
}
