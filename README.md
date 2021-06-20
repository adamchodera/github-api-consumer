# GitHub API consumer
A basic Android app that shows the public repositories of a particular user (mralexgray) and then 
retrieves their respective last commits.

## Architecture
- MVVM

## Libraries Used
- **Android Jetpack**
  ViewModel, LiveData, Data Binding, RecyclerView, Fragments, Navigation
- **Retrofit**
- **Dagger2**

## Improvements:
- Implement pagination when fetching repositories list 
[https://docs.github.com/en/rest/reference/repos#list-repositories-for-a-user]
- A new domain layer that uses UseCases for business logic
- Implement more UI test
- Implement more unit tests
- Error handling eg lack of Internet connection
- CI/CD
- New features eg. searching for the users
- LiveData Adapter for Retrofit [https://gist.github.com/AkshayChordiya/15cfe7ca1842d6b959e77c04a073a98f]
- Display ProgressBar when fetching data

