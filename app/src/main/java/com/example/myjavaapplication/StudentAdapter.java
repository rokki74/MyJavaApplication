package com.example.myjavaapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myjavaapplication.api.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout (e.g., student_item.xml)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        // Bind student data to the ViewHolder (e.g., set text to TextViews)
        holder.positionTextView.setText("UserId: "+student.getPosition());
        holder.admissionNumberTextView.setText("UserId: "+student.getAdmission_number());
        holder.nameTextView.setText("Id: "+student.getName());
        holder.classIdTextView.setText("Position: "+student.getClass_id());
        holder.streamTextView.setText("Completed: "+student.getStream());  // Update to display your desired student field
        holder.createdAtTextView.setText("Title: " + student.getCreated_at()); // Assuming you have a "details" field in Student class
        holder.updatedAtTextView.setText("Title: " + student.getUpdated_at());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView positionTextView;
        TextView admissionNumberTextView;
        TextView nameTextView;
        TextView classIdTextView;
        TextView streamTextView;
        TextView createdAtTextView;  // Added for displaying details
        TextView updatedAtTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            positionTextView = itemView.findViewById(R.id.studentPosition);
            admissionNumberTextView = itemView.findViewById(R.id.studentAdmissionNumber);
            nameTextView = itemView.findViewById(R.id.studentName);
            classIdTextView = itemView.findViewById(R.id.studentClassId);
            streamTextView = itemView.findViewById(R.id.studentStream);
            createdAtTextView = itemView.findViewById(R.id.studentCreatedAt);  // Added for details
            updatedAtTextView = itemView.findViewById(R.id.studentUpdatedAt);

        }
    }
}