package com.example.myjavaapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myjavaapplication.api.Teacher;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {

    private List<Teacher> teacherList;

    public TeacherAdapter(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout (e.g., student_item.xml)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Teacher teacher = teacherList.get(position);
        // Bind student data to the ViewHolder (e.g., set text to TextViews)
        holder.userIdTextView.setText("UserId: "+teacher.getUserId());
        holder.idTextView.setText("Id: "+teacher.getId());
        holder.positionTextView.setText("Position: "+teacher.getPosition());
        holder.titleTextView.setText("Completed: "+teacher.getCompleted());  // Update to display your desired student field
        holder.completedTextView.setText("Title: " + teacher.getTitle()); // Assuming you have a "details" field in Student class

    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userIdTextView;
        TextView idTextView;
        TextView positionTextView;
        TextView titleTextView;
        TextView completedTextView;  // Added for displaying details

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userIdTextView = itemView.findViewById(R.id.teacherUserId);
            idTextView = itemView.findViewById(R.id.teacherId);
            positionTextView = itemView.findViewById(R.id.teacherPosition);
            titleTextView = itemView.findViewById(R.id.teacherTitle);
            completedTextView = itemView.findViewById(R.id.teacherCompleted);  // Added for details

        }
    }
}