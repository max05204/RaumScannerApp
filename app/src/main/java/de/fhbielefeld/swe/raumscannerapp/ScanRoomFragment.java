package de.fhbielefeld.swe.raumscannerapp;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import de.fhbielefeld.swe.raumscannerapp.databinding.FragmentScanRoomBinding;

public class ScanRoomFragment extends Fragment {

    private FragmentScanRoomBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentScanRoomBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnBackMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ScanRoomFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);

            }
        });

        binding.btnEnter.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = binding.inRoomnumber.getText().toString();

                if (true){ // wenn es noch noch nicht exestiert
                    NavHostFragment.findNavController(ScanRoomFragment.this).navigate(R.id.action_SecondFragment_to_addRoom);
                    editRoomFragment.
                }
                else{ //wenn es schon exestiert
                    NavHostFragment.findNavController(ScanRoomFragment.this).navigate(R.id.action_SecondFragment_to_showRoomFragment);
                }

            }
        }));




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}