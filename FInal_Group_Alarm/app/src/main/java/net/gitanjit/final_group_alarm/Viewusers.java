package net.gitanjit.final_group_alarm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Viewusers extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<UserHelperClass> list;
    UserListAdapter adapter;
    FirebaseUser firebaseUser;
    private ProgressDialog progressDialog;
    private static final String TAG = "MyActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewusers);
        mFirebaseAuth = FirebaseAuth.getInstance();

        reference =  FirebaseDatabase.getInstance().getReference("Users");
        recyclerView = findViewById(R.id.recyclerusers);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("List loading...");
        progressDialog.show();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()) {

                    progressDialog.dismiss();
                    list = new ArrayList<>();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {


                        progressDialog.setMessage("List is maybe visible...");
                        UserHelperClass p = dataSnapshot1.getValue(UserHelperClass.class);
                        list.add(p);
                        String h=p.fullName;
                        Log.d(TAG,h);


                    }
                    System.out.println(list);
                    if (list.isEmpty()) {
                        Toast.makeText(Viewusers.this, "Sorry! No users in our database!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Viewusers.this, MainActivity.class));
                    } else {
                        adapter = new UserListAdapter(Viewusers.this, list);
                        recyclerView.setAdapter(adapter);

                        adapter.setOnItemClickListener(new UserListAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {


                                startActivity(new Intent(Viewusers.this, AddUserToGrp.class));

                            }
                        });
                    }
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(Viewusers.this, "Sorry! No users in our database!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Viewusers.this, MainActivity.class));
                }            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Viewusers.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }









    public void main_return(View view) {
        startActivity(new Intent(Viewusers.this, MainActivity.class));
        finish();
    }
}