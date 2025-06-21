package diff

fun main() {

    var local = arrayListOf(1,5,7,10)
    var remote = arrayListOf(1,8,9,10)
    var toRemove = arrayListOf<Int>()


    local.forEach {
        if (remote.contains(it).not()){
            toRemove.add(it)
        }

    }
   println(toRemove)

    //then save all entries from remote
    //remote vai vir somendte validos ? Ou pode vir algum inativo ou com data vencida ? se vier, preciso validar antes de adicionar
    //estou contando com o fato de não vir, eu removo da lista local
    //remote

}