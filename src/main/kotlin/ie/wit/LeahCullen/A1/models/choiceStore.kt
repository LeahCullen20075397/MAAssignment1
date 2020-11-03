package ie.wit.LeahCullen.A1.models

interface choiceStore {
    fun findAll(): List<choiceModel>
    fun findOne(id: Long): choiceModel?
    fun create(choice: choiceModel)
    fun update(choice: choiceModel)
}