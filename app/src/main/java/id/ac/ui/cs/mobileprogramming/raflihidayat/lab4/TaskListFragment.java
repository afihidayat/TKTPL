package id.ac.ui.cs.mobileprogramming.raflihidayat.lab4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.raflihidayat.lab4.databinding.FragmentTaskListBinding;

public class TaskListFragment extends Fragment {
    private FragmentTaskListBinding binding;
    private DetailsFragment detailsFragment = new DetailsFragment();


    public TaskListFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_task_list, container,false);
        return binding.getRoot();
    }

     @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<Item> list = new ArrayList<>();
        list.add(new Item("Monday", "Debugging", "Learn about different types of errors in Java and practice finding them"));
        list.add(new Item("Monday", "Design patterns", "Learn more about Observer and Adapter patterns"));
        list.add(new Item("Tuesday", "Algorithms", "Study quick sort algorithm"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        binding.recyclerView.setAdapter(adapter);
         adapter.setListener((v, position) -> {
             viewModel.setSelected(adapter.getItemAt(position));
             getParentFragmentManager().beginTransaction()
                     .replace(R.id.container, detailsFragment)
                     .addToBackStack(null)
                     .commit();
         });
     }
}