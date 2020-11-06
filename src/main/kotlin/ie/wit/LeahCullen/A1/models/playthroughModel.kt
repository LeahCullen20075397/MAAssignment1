package ie.wit.LeahCullen.A1.models
/*
playthroughModel manages user data and stores playthrough objects
all 3 parts of a playthrough belongs to a playthrough. So each list is brought into
the playthroughModel
 */
data class playthroughModel(    var id: Long = 0,
                                var characters: MutableList<characterModel> = mutableListOf(),
                                var relationships: MutableList<relationshipModel> = mutableListOf(),
                                var choices: MutableList<choiceModel> = mutableListOf())