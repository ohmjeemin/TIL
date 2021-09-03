package book200.mid

fun <T,R> T.map(mapper: (T)->R):R?{
    return mapper(this)
}