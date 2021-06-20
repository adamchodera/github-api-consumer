# GitHub API consumer
A basic Android app that shows my public repositories and then retrieves their respective last commits.

## Architecture
- MVVM
- Single Activity

## Libraries Used
- **Android Jetpack:**
  ViewModel, LiveData, Data Binding, RecyclerView, Fragments, Navigation
- **Retrofit**
- **Dagger2**

## Improvements:
- Implement "Task 4" - fetch data via GraphQL, more: [https://docs.github.com/en/graphql/overview/about-the-graphql-api]
- Implement pagination when fetching repositories list 
[https://docs.github.com/en/rest/reference/repos#list-repositories-for-a-user]
- A new domain layer that uses UseCases for business logic
- Implement unit tests
- Implement UI test
- Wrapping API Responses and error handling
- CI/CD
- LiveData Adapter for Retrofit [https://gist.github.com/AkshayChordiya/15cfe7ca1842d6b959e77c04a073a98f]
- Display ProgressBar when fetching data
- Add Toolbar's navigation
- New features eg. searching for the users

## Things I would do differently:
- Create views via Jetpack Compose
- Use Hilt instead of Dagger
- Extract model to the separate module if the project's full scope is bigger than the assignment itself
- Use Kotlin DSL to write custom build code for eg. dependencies across all the modules