package ie.wit.LeahCullen.A1.models

data class playthroughModel(    var id: Long = 0,
                                var characters: MutableList<characterModel> = mutableListOf(),
                                var relationships: MutableList<relationshipModel> = mutableListOf(),
                                var choices: MutableList<choiceModel> = mutableListOf())