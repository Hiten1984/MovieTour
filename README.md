# MovieTour
An Android application to fetch popular or highest rated movies from theMovieDb site and use the most common practises used in android.

Commit 2:
In this commit I have changed the normal fetching of data from webservice and use a view model as a separate class that is not controlled by UI.
Whenever UI launches the Main Activity, it fetches for the data using the view model and gets a list of movies which is then passed on to the view and updates the view accordingly.

In the upcoming commits, I will be using observables and respective pattern to simplify it more step by step.
The app currently show case the use of following libaries in its second commit.
1) Lifecycle

Commit 1:
The app currently show case the use of following libaries in its first commit.
1) Retrofit
2) Butterknife
3) Glide
4) Logging Interceptors
5) Gson Convertor.

In the upcoming Commits I will be adding app integration with ViewMode, LiveData, Rx Java and most importantly adding the MVVM architecture.
