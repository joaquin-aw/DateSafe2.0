package com.example.datesafe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WarningMan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_profile);

        TextView warningNote = findViewById(R.id.WarningNote);

        findViewById(R.id.warning_button).setOnClickListener(v -> {
            // Create an EditText to allow the user to input the reason for the warning
            final EditText reasonEditText = new EditText(WarningMan.this);
            reasonEditText.setHint("Enter reason for warning...");

            // Create the AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(WarningMan.this);
            builder.setTitle("Submit Warning");
            builder.setMessage("Please enter the reason for submitting a warning:");
            builder.setView(reasonEditText);

            // Set the Submit button functionality
            builder.setPositiveButton("Submit", (dialog, which) -> {
                String reason = reasonEditText.getText().toString();
                if (reason.isEmpty()) {
                    Toast.makeText(WarningMan.this, "Please enter a reason.", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle the reason input (e.g., save it or send it to the server)
                    Toast.makeText(WarningMan.this, "Warning submitted: " + reason, Toast.LENGTH_SHORT).show();
                    warningNote.setVisibility(View.VISIBLE);
                    // Optionally, dismiss the dialog after submission
                    dialog.dismiss();
                }
            });

            // Set the Cancel button
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

            // Show the dialog
            builder.show();

        });
    }
}

