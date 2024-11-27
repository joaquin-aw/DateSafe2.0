package com.example.datesafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private final List<Event> eventList;
    private final Context context;

    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);

        // Set event details
        holder.eventName.setText(event.getName());
        holder.eventDate.setText("Date: " + event.getDate());
        holder.eventDescription.setText(event.getDescription());

        // Update button state based on sign-up status
        if (event.isSignedUp()) {
            holder.signUpButton.setText("Unregister");
        } else {
            holder.signUpButton.setText("Sign Up");
        }

        // Button click listener
        holder.signUpButton.setOnClickListener(v -> {
            if (event.isSignedUp()) {
                // Unregister logic
                event.setSignedUp(false);
                Toast.makeText(context, "Unregistered from " + event.getName(), Toast.LENGTH_SHORT).show();
            } else {
                // Sign-up logic
                event.setSignedUp(true);
                Toast.makeText(context, "Signed up for " + event.getName(), Toast.LENGTH_SHORT).show();
            }
            notifyItemChanged(position); // Refresh button state
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventName, eventDate, eventDescription;
        Button signUpButton;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventDate = itemView.findViewById(R.id.eventDate);
            eventDescription = itemView.findViewById(R.id.eventDescription);
            signUpButton = itemView.findViewById(R.id.signUpButton);
        }
    }
}
