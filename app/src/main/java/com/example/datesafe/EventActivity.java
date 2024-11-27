package com.example.datesafe;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        RecyclerView recyclerView = findViewById(R.id.eventsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Event> events = new ArrayList<>();
        events.add(new Event("Pottery Making", "December 1, 2024", "Learn the art of pottery with hands-on experience."));
        events.add(new Event("Bar Event", "December 5, 2024", "Join us for a night of drinks and music at the local bar."));
        events.add(new Event("Running Club", "December 10, 2024", "Group run through scenic trails in the city."));
        events.add(new Event("Study Group", "December 12, 2024", "Collaborate and learn in a focused group setting."));
        events.add(new Event("Video Game Tournament", "December 15, 2024", "Compete in an epic gaming battle."));
        events.add(new Event("Movie Theatre Night", "December 18, 2024", "Enjoy the latest blockbuster with friends."));
        events.add(new Event("Hiking Adventure", "December 20, 2024", "Explore nature and enjoy breathtaking views."));
        events.add(new Event("Arcade Night", "December 22, 2024", "Relive the classics with a fun-filled arcade night."));
        events.add(new Event("Go Kart Racing", "December 25, 2024", "Experience the thrill of racing with friends."));

        EventAdapter adapter = new EventAdapter(this, events);
        recyclerView.setAdapter(adapter);
    }
}

