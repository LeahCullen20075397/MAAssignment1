package ie.wit.LeahCullen.A1.models

interface characterStore {
    fun findAll(): List<characterModel>
    fun findOne(id: Long): characterModel?
    fun create(character: characterModel)
    fun update(character: characterModel)
}