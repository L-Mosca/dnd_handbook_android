# dnd_handbook_android

This is a native Android App that i create to learn and improve my skills around jetpack compose.

I'm using [D&D Api](https://www.dnd5eapi.co/) to show game bestiary and for users create your characters. I wanna to improve the user experience with D&D.
Don't wast your time with game rules, only play the game while the software do the boring things.

My intention is create simple screens and then i'll increment with more technologies and improve the app structure and architecture.

___

## Main Technologies:

* [Hilt](https://developer.android.com/training/dependency-injection/hilt-jetpack?hl=pt-br)
* [Navigation](https://developer.android.com/develop/ui/compose/navigation?hl=pt-br)
* [Data Store](https://developer.android.com/training/data-storage?hl=pt-br)
* [Retrofit](https://square.github.io/retrofit/)
___

## architecture

In this project i'm using MVVM arch.

All Screens class contains a ViewModel (extends android [ViewModel](https://developer.android.com/reference/android/arch/lifecycle/ViewModel)) provided by hilt.

ViewModel contains all screen logic (to turn easy apply unit tests and separate the logic from view).

___

## Layers

Basically this software contains three layers:

* Presentation
* Domain
* Data

<img src="https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-data-overview.png?hl=pt-br" alt="layers" width="400" height="600"/>

### UI
UI layer contains all styles and views (a screen it's a presentaion layer component).

### Domain
Domain layer contains the bussiness logic. In this case it's composite by UseCases and ViewModels class.

### Data
Data layer container all classes that's fetch data on external or internal environment. In this software it's repositories, retrofit, DAO, preferences data store class...

___

## Navigation

Navigation it's provided by NavGraph class. This class contains all navigation logic, animation and routes.

Routes example:
```
@Serializable
object SplashRoute : Route(route = "splashRoute")

@Serializable
data class MonsterDetailRoute(val monsterIndex: String) : Route(route = "monsterDetailRoute")
```

Nav Graph:
```
NavHost(navController = navController, startDestination = SplashRoute) {
        animatedComposable<SplashRoute> {
            SplashScreen(navController)
        }
...
}
```

obs: animatedComposable it's an inline extension function to provide a route with default animation style:
```
inline fun <reified T> NavGraphBuilder.animatedComposable(
    noinline content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) where T : Route {
    composable<T>(
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
        content = content,
    )
}
```


Use *data class* to share args between routes and intercept shared data on ViewModel:
```
@HiltViewModel
class MonsterDetailViewModel @Inject constructor(
    private val getMonsterDetailUseCase: GetMonsterUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {
...
init {
        savedStateHandle.get<String>(Constants.MONSTER_DETAIL_SCREEN_ARGUMENT)
            ?.let { monsterIndex ->
                getMonsterDetail(monsterIndex)
            }
    }
...
}
```
 
## Available Features

Actually you can use bestiary screen (list with all monsters) and monster detail screen (screen with
monster attributes, like a bestiary book)

<img src="screenshots/bestiary_screen.png" alt="Bestiary" width="300"/> <img src="screenshots/monster_detail_screen.png" alt="Monster Detail" width="300"/>

___

## Future Features:

* Feature to create lists with monster
* Create or edit monster
* Share list with NFC

___

Last update: 07/2025.
