package com.example.personalinfoapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileFragment extends Fragment {

    EditText firstname,lastname,email,gender,date,city;
    FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseFirestore firestore;
    NavController navController;
    // Button Home;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Profile");
        firstname= view.findViewById(R.id.firstName);
        lastname=view.findViewById(R.id.lastName);
        email=view.findViewById(R.id.email);
        date=view.findViewById(R.id.date);
        gender=view.findViewById(R.id.gender);
        city=view.findViewById(R.id.city);
        //   Home=view.findViewById(R.id.home);
        firestore=FirebaseFirestore.getInstance();
        fAuth=FirebaseAuth.getInstance();


        //  navController = Navigation.findNavController(getActivity(),R.id.host_fragment);
        readFireStore();

/*        Home.setOnClickListener(view1 -> {
            navController.navigate(R.id.dashboardFragment);

        });

 */
    }



    public void readFireStore() {
        user = fAuth.getCurrentUser();
        DocumentReference docRef = firestore.collection("User").document(user.getUid());

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {

                    String FirstName = documentSnapshot.getString("FirstName");
                    String LastName = documentSnapshot.getString("LastName");
                    String Gender = documentSnapshot.getString("Gender");
                    String Date = documentSnapshot.getString("date");
                    String City = documentSnapshot.getString("City");
                    String Email = documentSnapshot.getString("Email");
                    firstname.setText(FirstName);
                    lastname.setText(LastName);
                    email.setText(Email);
                    date.setText(Date);
                    gender.setText(Gender);
                    city.setText(City);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "error in data iporting", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }