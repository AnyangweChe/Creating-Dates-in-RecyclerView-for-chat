# Creating-Dates-in-RecyclerView-for-chat
Simple code to create dates in recyclerView like in chat apps like whatsapp or notifications page like linkedin

Before you start, make sure that you updated your Android Studio to latest version. Currently my Android Studio is updated to Android Studio 3.3.2.

Open build.gradle and add recycler view dependency. # com.android.support:recyclerview-v7:28.0.0-alpha-3, com.android.support:recyclerview-v7:28.0.0-alpha-3 # and rebuild the project.

In the MainActivity.java , create the adapter class. The adapter has a constructor used in passing data to the RecyclerView.

Create layout xml called list_item.xml. This layout file renders a single row in recycler view by displaying movie name, genre and year of release.

8. Now open MainActivity.java and do the below changes. Here, we create another arraylist ArrayList<String> years = new ArrayList<String>(); .We loop through ArrayList<String> year = new ArrayList<String> , add new values to the array and leave the index empty for values that are already in the array.
  
Create new arraylist years

ArrayList<String> years = new ArrayList<String>();
Loop through arraylist
for (String yeas : year) {
    if (years.contains(yeas)) {
        years.add("");
    } else {
        years.add(yeas);
    }
}
  
9. We then tell our adapter not to display views that don’t have data. We change the value we are passing to the constructor from year to years.
From
// Initialise adapter with constructor values
        ContentAdapter mAdapter = new ContentAdapter(title,genres,year,date);
To

ContentAdapter mAdapter = new ContentAdapter(title,genre,year,date);

Condition statement in adapter
for (String yeas : year) {
    if (years.contains(yeas)) {
        years.add("");
    } else {
        years.add(yeas);
    }
}

Now if you run the app, you can see the movies displayed in a list manner.


![recycler view dates](https://miro.medium.com/max/1080/1*YSzkNhsUU47Hmd4Oagxbrw.png)
