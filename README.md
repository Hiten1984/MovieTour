# MovieTour
An Android application to fetch popular or highest rated movies from theMovieDb site and use the most common practises used in android.

Commit 5:
-----------
Added a menu option of swapping between popular and Highest rated movies and calling a differnet api using the same process,
making the life of developer so easy to just add the api and add connection since rest of the setup is already done.

Commit 4:
-------------

Finally I have added the dependency injection by adding component, module and a application class.

######## A litle overview:
1. Dependencies are the objects that we need to instantiate inside a class. So the entity who will provide us the objects that are called dependencies is called Dependency Provider.
In this case my AppModule.class is the dependency Provider,
2. Now, we have the dependency consumer; it is a class where we need to instantiate the objects. But now we don’t need to instantiate as dagger will provide the dependency, and for this, we just need to annotate the object declaration with @Inject.
3. Components acts as interface between the dependency Consumer and provider.

Commit 3:
------------
In this commit, I have added Observables to simply the data observing.
1) RxJava
2) RxAndroid

In the upcoming commits will be adding repository and other architectural components.

Commit 2:
-----------
In this commit I have changed the normal fetching of data from webservice and use a view model as a separate class that is not controlled by UI.
Whenever UI launches the Main Activity, it fetches for the data using the view model and gets a list of movies which is then passed on to the view and updates the view accordingly.

In the upcoming commits, I will be using observables and respective pattern to simplify it more step by step.
The app currently show case the use of following libaries in its second commit.
1) Lifecycle
2) ViewModel

Commit 1:
----------
The app currently show case the use of following libaries in its first commit.
1) Retrofit
2) Butterknife
3) Glide
4) Logging Interceptors
5) Gson Convertor.

In the upcoming Commits I will be adding app integration with ViewMode, LiveData, Rx Java and most importantly adding the MVVM architecture.

Screenshots
** Screen -1 **

- ![alt text](https://github.com/Hiten1984/MovieTour/tree/master/screenshots/screenshots1.png)


** Screen -2 **
- ![alt text](https://github.com/Hiten1984/MovieTour/tree/master/screenshots/screenshots2.png)
