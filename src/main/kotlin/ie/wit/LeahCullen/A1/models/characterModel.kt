package ie.wit.LeahCullen.A1.models
/*
characterModel manages user data and stores character objects
 */
data class characterModel(  var id: Long = 0,
                            var name: String = "",
                            var gender: String = "",
                            var race: String = "",
                            var background: String = "")