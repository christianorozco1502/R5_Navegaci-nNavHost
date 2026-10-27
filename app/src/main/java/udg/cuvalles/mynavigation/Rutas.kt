
package udg.cuvalles.mynavigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data class ProfileRoute(
    val userId: String,
    val userName: String
)
