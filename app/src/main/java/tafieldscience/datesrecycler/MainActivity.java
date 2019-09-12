package tafieldscience.datesrecycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> year = new ArrayList<String>();
    ArrayList<String> years = new ArrayList<String>();
    ArrayList<String> genre = new ArrayList<String>();
    ArrayList<String> date = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding sample data
        title.add("Inside Out");
        title.add("Monsters");
        title.add("Kill Bill");
        title.add("Inside Out");
        title.add("Monsters");
        title.add("Kill Bill");
        title.add("Mission Imposible 3");
        title.add("The Godfather");
        title.add("Die Another Day");

        date.add("15 August");
        date.add("1 July");
        date.add("5 September");
        date.add("30 March");
        date.add("2 January");
        date.add("27 October");
        date.add("13 March");
        date.add("20 February");
        date.add("7 April");

        year.add("2018");
        year.add("2018");
        year.add("2018");
        year.add("2015");
        year.add("2015");
        year.add("2015");
        year.add("2010");
        year.add("2010");
        year.add("2010");

        genre.add("Animation");
        genre.add("Horror");
        genre.add("Ninja");
        genre.add("Animation");
        genre.add("Horror");
        genre.add("Ninja");
        genre.add("Action");
        genre.add("Drama");
        genre.add("Syfy");

        for (String yeas : year) {
            if (years.contains(yeas)) {
                years.add("");
            } else {
                years.add(yeas);
            }
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Initialise adapter with constructor values
        ContentAdapter mAdapter = new ContentAdapter(title,genre,years,date);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Set adapter to recyclerView
        recyclerView.setAdapter(mAdapter);

    }

    // Provide a reference to the views for eacg data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre,date;

        private ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            date = (TextView) view.findViewById(R.id.date);
        }
    }

    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        ArrayList<String> title = new ArrayList<String>();
        ArrayList<String> genre = new ArrayList<String>();
        ArrayList<String> year = new ArrayList<String>();
        ArrayList<String> date = new ArrayList<String>();

        // Adapter Constructor
        ContentAdapter(ArrayList<String> title1,ArrayList<String> genre1, ArrayList<String> year1, ArrayList<String> date1) {
            title = title1;
            genre = genre1;
            year = year1;
            date = date1;
        }

        // Create new Views
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_items, viewGroup, false);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            // Get elements from your dataset at this position
            if(year.get(i).isEmpty()){
                viewHolder.year.setVisibility(View.GONE) ;
            }else{
                viewHolder.year.setText(year.get(i));
            }
            viewHolder.title.setText(title.get(i));
            viewHolder.genre.setText(genre.get(i));
            viewHolder.date.setText(date.get(i));
        }

        // Return size of dataset
        @Override
        public int getItemCount() {
            return title.size();
        }
    }
}
