# CSCI370-Lab_04
AsyncTask

This Lab builds off of the advanced Adapter topics and adds in AsyncTask Threading we have been discussing in class.

## Problem
This lab will have you creating a long running task that will be handled by an AsyncTask.

## Purpose
This lab will build upon your AsyncTask knowledge.

## Steps
### Create Views:
* Open Android Studio and create a basic project. Name the project whatever you like, **AsyncTask** is a good candidate. Choose **The API of your choice but should be at least API 23: Android 6.0 (Marshmallow)**. Next choose just an **Empty Activity**.
* In the **activity_main.xml**, replace the default TextView with
```xml
    <ListView
        android:id="@+id/student"
        android:layout_height="match_parent"
        android:layout_width="match_parent">
    </ListView>
 ```
* Create a layout file name **list_view_row.xml**.
* Add an ImageView and three TextView elements. HINT: Use the following as a starting point and modify once you have that working:
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <RelativeLayout xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/category_thumbnail"
            android:layout_width="90dp"
            android:layout_height="90dp"
            android:layout_alignParentStart="true"
            android:layout_centerVertical="true"
            android:layout_marginBottom="6dp"
            android:layout_marginStart="4dp"
            android:layout_marginTop="6dp"
            android:contentDescription="Desc"
            android:scaleType="centerInside"
            android:text="CS"
            android:textAlignment="center"
            android:textSize="22dp"

            />

        <TextView
            android:id="@+id/last_name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_centerVertical="true"
            android:layout_marginEnd="2dp"
            android:layout_marginStart="4dp"
            android:maxLines="1"
            android:textColor="#000000"
            android:textSize="20dp"
            tools:text="Detail" />

        <RelativeLayout
            android:id="@+id/list_text_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_toEndOf="@id/category_thumbnail"
            android:layout_toStartOf="@id/last_name">

            <TextView
                android:id="@+id/first_name"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="8dp"
                android:layout_marginRight="8dp"
                android:textSize="18sp"
                tools:text="Title" />

            <TextView
                android:id="@+id/major"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/first_name"
                android:layout_marginLeft="8dp"
                android:layout_marginRight="8dp"
                android:layout_marginTop="2dp"
                android:ellipsize="end"
                android:maxLines="3"
                android:textSize="16sp"
                tools:text="Subtitle" />
        </RelativeLayout>
    </RelativeLayout>
</androidx.constraintlayout.widget.ConstraintLayout>

```
* Modifying the thumbnail to be an ImageView will be the **Challenge**. Get the version with TextView workking first. You can use [icons8.com](https://icons8.com/) for icons. I think 96 by 96 is a good size to get.
* Create a Java reference to the ListView in **MainActivity.java**.
* Use the **Student.java** class provided or create a **Student** class in Java (a POJO- Plain Ole Java Object) with three Strings as private member variables (firstName, lastName, and major). Remember, POJO are only constructors, getters, and setters.
* Use the **StudentAdapter.java** class provided to create a **StudentAdapter** class.
* Create a **StudentDao** class that contains a private ArrayList of Students attribute. Make a Constructor that takes in no parameters and builds 5 Students and put them in the ArrayList. Create a method **getAllStudents()** that will return the ArrayList of Students attribute. Execute this code before returning the Student ArrayList **This will be your long running process**.
```
 try {
     Thread.sleep(5000);
 } catch (InterruptedException e) {
     e.printStackTrace();
 }
```
* Create a **StudentAsyncTask** class that extends **AsyncTask** and has the parameters <Void,Void,ArrayList<Student>> .
* Since this class will update the UI thread as well as executing the background thread, you will need to pass in the View piece you want to populate and pass in the Context. These should be private attributes as well as passed into the Constructor.
* Let the IDE Override **doInBackground** and **onPostExecute**.
* The **doInBackground** method should instantiate a **StudentDao** and call **getAllStudents** and return this ArrayList.
* The **onPostExecute** should create a **StudentAdapter** and set the adapter to the ListView.
* In MainActivity.java, create an instance of a StudentAsyncTask and perform the execute() method on it.
* Run your application and test.


### Style the ListView
* Add the following lines to the ListView in **activity_main.xml**:
```xml
<ListView
    ...
    android:dividerHeight="5.0sp"
    android:divider="@android:color/black"
    android:padding="45sp">
</ListView>
```
* Test your code one final time.
* Share, commit, and push lab to your GitHub account

